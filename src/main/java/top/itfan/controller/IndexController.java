package top.itfan.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.itfan.model.Video;
import top.itfan.serv.service.IndexService;
import top.itfan.source.Letv;
import top.itfan.utils.UrlUtils;

/**
 * Created by ralap on 2017/8/14.
 */
@Controller
@Log4j2
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 首页
     */
    @RequestMapping("/")
    public String index(Map<String, Object> map) {

        map.put("carouselList", indexService.getCarousel());
        map.put("moviesList", indexService.getMovies());
        map.put("hotTVList", indexService.getHotTV());
        map.put("zyList",indexService.getZY());
        return "index";
    }

    /**
     * 解析页
     */
    @GetMapping("/analysis")
    public String analysis() {
        return "analysis";
    }

    /**
     * 播放视频
     */
    @GetMapping("/play")
    public String paly(HttpServletRequest request, HttpServletResponse response, Model model) {
        String url = request.getParameter("u");
        response.setHeader("Access-Control-Allow-Origin", "*");

        Letv letv = new Letv();

        Video video = letv.parse(url);
        model.addAttribute("video", video);

        return "video";
    }

    @GetMapping("/episode")
    @ResponseBody
    public List episodes(HttpServletRequest request) {
        String url = request.getParameter("v");
        url = url.replaceAll("\\?(spm|from).*", "");
        String key = UrlUtils.getTopDomain(url);
        Letv letv = new Letv();
        return letv.parseEpisodes(url);
    }

    @GetMapping("/video")
    @ResponseBody
    public Video video(HttpServletRequest request) {
        String url = request.getParameter("v");
        url = url.replaceAll("\\?(spm|from).*", "");
        Letv letv = new Letv();
        return letv.parse(url);
    }
}
