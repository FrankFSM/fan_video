package top.itfan.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.itfan.model.Iqiyi;
import top.itfan.model.Video;

/**
 * Created by ralap on 2017/8/14.
 */
@Controller
@Log4j2
public class IndexController {


    /**
     * 使用 thymeleaf
     */
    @RequestMapping("/")
    public String helloHtml(Map<String, Object> map) {

        return "index";
    }

    @GetMapping("/analysis")
    public String analysis() {
        return "analysis";
    }
}
