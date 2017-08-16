package top.itfan.test;

import java.util.List;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ralap on 2017/8/7.
 */
@Controller
@RequestMapping()
public class testController {

    @Autowired
    private TestMapper testMapper;

    @RequestMapping("/getAll")
    public List<TestUser> getAllUser() {
        return testMapper.getAll();
    }

    @RequestMapping("/save")
    public String save(TestUser user) {
        testMapper.save(user);
        return "success";
    }

    @GetMapping("/toVideo")
    public String toVie() {
        return "video";
    }
}
