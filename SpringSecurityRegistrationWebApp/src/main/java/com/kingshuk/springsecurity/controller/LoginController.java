package com.kingshuk.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(path="/requestToLogin", method = {RequestMethod.GET, RequestMethod.POST})
    public String showLoginPage(){
        return "common/login_page";
    }



    @RequestMapping(path="/failedAuthentication",
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String showAuthenticationFailurePage(){
        return "common/catch_401";
    }

    @RequestMapping(path="/failedAuthorization",
            method = {RequestMethod.GET, RequestMethod.POST})
    public String showAuthorizationFailurePage(){
        return "common/catch_403";
    }
}
