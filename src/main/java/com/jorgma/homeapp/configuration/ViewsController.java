package com.jorgma.homeapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jorgma on 2017-10-26.
 */
@Controller
public class ViewsController {

    @Autowired
    Environment environment;


    private String indexPath() {
        if (environment.getProperty("spring.profiles.active").equals("dev")) {
            System.out.println("is dev");
            return "homeapp/dist/";
        }
        return "/";
    }


    @RequestMapping(value = {
            "/",
            "/dashboard",
            "/entry-board",
            "/stations",
            "/weather",
            "/weather/**"
    }, method = RequestMethod.GET)
    public String index() {
        return "forward:" + indexPath() + "index.html";
    }
}
