package com.kingshuk.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeRequestController {

    @RequestMapping(path="/employee", method = {RequestMethod.GET, RequestMethod.POST})
    public String employeeRequestHandler() {
        return "employee/employee_news_update";
    }

    @RequestMapping(path="/leadership", method = {RequestMethod.GET, RequestMethod.POST})
    public String leaderShipRequestController() {
        return "leadership/leadership_news_update";
    }

    @RequestMapping(path="/vendor", method = {RequestMethod.GET, RequestMethod.POST})
    public String vendorRequestController() {
        return "vendor/vendor_news_update";
    }
}
