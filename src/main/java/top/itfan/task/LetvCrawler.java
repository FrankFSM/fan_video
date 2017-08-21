package top.itfan.task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.media.VideoTrack;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;
import top.itfan.global.Constant.LetvInfo;
import top.itfan.global.Constant.RedisKey;
import top.itfan.global.Constant.VideTag;
import top.itfan.model.Video;
import top.itfan.redis.RedisManager;
import top.itfan.utils.JsoupUtils;
import top.itfan.utils.LogUtils;

/**
 * LetvCrawler
 * 乐视爬取
 *
 * @Author: ralap
 * @Date: created at 2017/8/15 22:09
 */
@Component
@Log4j2
@AllArgsConstructor
public class LetvCrawler {

    @Autowired
    private final RedisManager redisManager;

    /**
     * 每隔1小时，爬乐视官网信息
     */
    @Scheduled(fixedRate = 60 * 60 * 1000)
    public void start() {

        LogUtils.longInfo(log, "定时爬虫任务，【乐视】 --------->>>>>> 【开始】");

        Document pcDocument = JsoupUtils.getDocWithPC(LetvInfo.HOME_PAGE_PC);
        Document phoneTVDocument = JsoupUtils.getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_TV);
        Document phoneMovieDocument = JsoupUtils.getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_MOVIE);
        Document phoneCartoonDocument = JsoupUtils
                .getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_CARTOON);
        Document phoneZongyiDocument = JsoupUtils
                .getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_RECOMMEND);
        Document phoneTvHotDocument = JsoupUtils.getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_TV_HOT);
        saveCarouselsToRedis(pcDocument);
        saveRecommendsToRedis(phoneZongyiDocument);
        saveTVsToRedis(phoneTVDocument);
        saveMoviesToRedis(phoneMovieDocument);
        saveCartoonsToRedis(phoneCartoonDocument);
        saveTVHotsToRedis(phoneTvHotDocument);

        LogUtils.longInfo(log, "定时爬虫任务，【乐视】--------->>>>>> 【结束】");

    }

    /**
     * 爬乐视PC官网-首页轮播信息
     */
    private void saveCarouselsToRedis(Document document) {
        List<Video> carouselVideos = new ArrayList<>();
        Elements carousels = document.select("div.chart-info ul.slides li");
        for (Element carousel : carousels) {
            Video videoDTO = new Video();
            String title = carousel.select("a").attr("title");
            String image = carousel.select("img").attr("data-src");
            String url = carousel.select("a").attr("href");
            if (url.contains("le.com")) {
                videoDTO.setTitle(title);
                if (StringUtils.isEmpty(image)) {
                    image = carousel.select("img").attr("img-src");
                }
                image = image.replace("http:", "");
                videoDTO.setImageUrl(image);
                if (!url.contains("ptv/vplay")) {
                    Document realDocument = JsoupUtils.getDocWithPC(url);
                    Matcher matcher = Pattern.compile("vid:\"(.*?)\"").matcher(realDocument.html());
                    if (matcher.find()) {
                        url = String
                                .format("http://www.le.com/ptv/vplay/%s.html", matcher.group(1));
                    }
                }
                videoDTO.setRawUrl(url);
                log.info("Letv:" + title);
                carouselVideos.add(videoDTO);
            }
        }
        System.out.println(carouselVideos);
        String key = RedisKey.VIDEO_PREFIX_HOME_CAROUSEL_KEY + "_" + VideTag.LETV_TAG;
        redisManager.cacheVideos(key, carouselVideos);
    }

    /**
     * 爬乐视手机站-综艺
     */
    private void saveRecommendsToRedis(Document document) {
        String key = RedisKey.VIDEO_PREFIX_HOME_RECOMMEND_KEY + "_" + VideTag.LETV_TAG;
        redisManager.cacheVideos(key, getVideosFromPhoneDocument(document));
    }

    /**
     * 爬乐视手机站-电视剧
     */
    private void saveTVsToRedis(Document document) {
        String key = RedisKey.VIDEO_PREFIX_HOME_TV_KEY + "_" + VideTag.LETV_TAG;
        redisManager.cacheVideos(key, getVideosFromPhoneDocument(document));
    }

    /**
     * 爬乐视手机站-电视剧-热门
     */
    private void saveTVHotsToRedis(Document document) {
        String key = RedisKey.VIDEO_PREFIX_HOME_TV_HOT_KEY + "_" + VideTag.LETV_TAG;
        redisManager.cacheVideos(key, getHostsFromPhoneDocument(document, 7));
    }

    /**
     * 爬乐视手机站-电影
     */
    private void saveMoviesToRedis(Document document) {
        String key = RedisKey.VIDEO_PREFIX_HOME_MOVIE_KEY + "_" + VideTag.LETV_TAG;
        redisManager.cacheVideos(key, getVideosFromPhoneDocument(document));
    }

    /**
     * 爬乐视手机站-动漫
     */
    private void saveCartoonsToRedis(Document document) {
        String key = RedisKey.VIDEO_PREFIX_HOME_CARTOON_KEY + "_" + VideTag.LETV_TAG;
        redisManager.cacheVideos(key, getVideosFromPhoneDocument(document));
    }

    private List<Video> getVideosFromPhoneDocument(Document document) {
        List<Video> videos = new ArrayList<>();
        Elements videoElements = document.select("div.column_body div a");
        for (Element element : videoElements) {
            Video videoDTO = new Video();
            String title = element.attr("title");
            String image = element.select("span.a_img i").attr("style").replace("background-image:url('", "").replace("')", "");
            image = image.replace("http:","");
            if (org.apache.commons.lang.StringUtils.isEmpty(image)) {
                image = element.select("span.a_img i").attr("data-src");
            }
            String url = String.format("http://www.le.com/ptv/vplay/%s.html", element.attr("data-vid"));
            videoDTO.setTitle(title);
            videoDTO.setImageUrl(image);
            videoDTO.setRealUrl(url);
            log.info("Letv:" + title);
            videos.add(videoDTO);
        }
        return videos;
    }

    private List<Video> getHostsFromPhoneDocument(Document document, int size) {
        List<Video> videos = new ArrayList<>();
        Elements videoElements = document.select("div.column.tab_cnt a");
        for (int i = 0; i < size; i++) {
            Element element = videoElements.get(i);
            Video videoDTO = new Video();
            String title = element.select("i.i1").text();
            String image = element.select("span.a_img i").attr("data-src");
            image = image.replace("http:","");
            String url = String.format("http://www.le.com/ptv/vplay/%s", element.attr("href").replace("/vplay_", ""));
            videoDTO.setTitle(title);
            videoDTO.setImageUrl(image);
            videoDTO.setRealUrl(url);
            log.info("Letv:"+title);
            videos.add(videoDTO);
        }
        return videos;
    }


}
