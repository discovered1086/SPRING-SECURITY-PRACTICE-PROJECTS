package com.kingshuk.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //@RequestMapping(path = "/", method = RequestMethod.GET)
    @GetMapping("/")
    public String displayHomePage(){
        return "index";
    }
}
