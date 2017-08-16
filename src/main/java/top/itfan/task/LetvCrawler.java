package top.itfan.task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    @Scheduled(fixedRate = 60 * 1000)
    public void start() {

        Document pcDocument = JsoupUtils.getDocWithPC(LetvInfo.HOME_PAGE_PC);
//        Document phoneTVDocument = JsoupUtils.getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_TV);
//        Document phoneMovieDocument = JsoupUtils.getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_MOVIE);
//        Document phoneCartoonDocument = JsoupUtils
//                .getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_CARTOON);
//        Document phoneZongyiDocument = JsoupUtils
//                .getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_RECOMMEND);
//        Document phoneTvHotDocument = JsoupUtils.getDocWithPhone(LetvInfo.HOME_PAGE_PHONE_TV_HOT);
//        saveCarouselsToRedis(pcDocument);
//        saveRecommendsToRedis(phoneZongyiDocument);
//        saveTVsToRedis(phoneTVDocument);
//        saveMoviesToRedis(phoneMovieDocument);
//        saveCartoonsToRedis(phoneCartoonDocument);
//        saveTVHotsToRedis(phoneTvHotDocument);
//        LogUtils.longInfo(log, "乐视定时爬虫任务结束");
        saveCarouselsToRedis(pcDocument);
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
                videoDTO.setRealUrl(url);
                log.info("Letv:" + title);
                carouselVideos.add(videoDTO);
            }
        }
        System.out.println(carouselVideos);
        String key = RedisKey.VIDEO_PREFIX_HOME_CAROUSEL_KEY + "_" + VideTag.LETV_TAG;
        redisManager.cacheVideos(key, carouselVideos);
    }


}
