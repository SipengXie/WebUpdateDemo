package com.example.webupdatedemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
网页跳转Controller
 */
@Controller
public class redirectController {
    @RequestMapping(value = "/opinion", method = RequestMethod.GET)
    public String re_opinion() {
        return "opinion";
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String re_review() {
        return "review";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String re_modify() {
        return "modify";
    }
}
