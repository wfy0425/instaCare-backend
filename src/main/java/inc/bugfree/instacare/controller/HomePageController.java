package inc.bugfree.instacare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

    @GetMapping("/index")
    public String getIndexPage() {
        return "/index";
    }

    @RequestMapping(path = "/loginpage", method = {RequestMethod.GET, RequestMethod.POST})
    public String getLoginPage() {
        return "/site/login";
    }

    @GetMapping("/appointment")
    public String getDiscussPage() {
        return "/site/appointment";
    }

    @GetMapping("/request")
    public String getLetterPage() {
        return "/site/request";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "/site/admin";
    }

    // access denied page
    @GetMapping("/denied")
    public String getDeniedPage() {
        return "/error/404";
    }


}
