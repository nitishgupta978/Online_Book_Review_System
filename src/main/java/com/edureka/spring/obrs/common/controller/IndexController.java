package com.edureka.spring.obrs.common.controller;


import com.edureka.spring.obrs.common.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final String CLASS_NAME = this.getClass().getName();

    @GetMapping("/")
    public String homePage() {
        LogUtil.logDebug(LOG,CLASS_NAME,"homePage","Loading Home Page");
        return "redirect:/book/byCategory?category=all";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
}
