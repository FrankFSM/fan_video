package top.itfan.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import top.itfan.model.Iqiyi;
import top.itfan.model.Video;

/**
 * Created by ralap on 2017/8/14.
 */
@Controller
@Log4j2
public class AnalysisController {

    Map<String, Object> map;

    @GetMapping("/anay")
    public String analysisByUrl(HttpServletRequest request, Model model) {
        String url = request.getParameter("rawUrl");
        Iqiyi iqiyi = new Iqiyi();
        Video parse = null;
        //http://www.iqiyi.com/v_19rr7if2u4.html
        try {
            parse = iqiyi.parse(url);
            model.addAttribute("video", parse);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        return "/video";
    }


}
