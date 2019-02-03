package com.kingshuk.springsecurity.controller;

import com.kingshuk.springsecurity.model.RegistrationDAO;
import com.kingshuk.springsecurity.model.entities.RegistrationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationDAO registrationDAO;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    /*@GetMapping
    public ModelAndView showRegistrationPage(){
        ModelMap map=new ModelMap();
        map.put("user",new RegistrationData());
        map.put("role",new UserRole());

        return new ModelAndView("common/registration",map);
    }*/

    @GetMapping("/showForm.htm")
    public String showRegistrationPage(Model theModel) {
        //theModel.addAttribute("user",new RegistrationData());
        //theModel.addAttribute("role",new UserRole());
        theModel.addAttribute("registrationInfo", new RegistrationData());

        return "common/registration";
    }

    /*@PostMapping("/processRegistration.htm")
    public String processRegistration(@RequestParam("role") String[] roles,
                                      @Valid @ModelAttribute("registrationInfo") RegistrationData registrationData,
                                      BindingResult bindingResult,
                                      Model theModel) {
        String finalUrl = "common/registration_confirmation";
        /*form validation
        if(bindingResult.hasErrors()){
            theModel.addAttribute("registrationInfo",new RegistrationData());
            theModel.addAttribute("error-message","Please provide valid registration details");
        }

        //if none of the roles are selected throw an error
        if (roles.length == 0) {
            theModel.addAttribute("validationErrorMessage", "Selection of at least one roll is required");
        }

        //check the database if the user already exists
        boolean userAlreadyExists = registrationDAO.checkIfUserExists(registrationData.getUsername());
        if (userAlreadyExists) {
            theModel.addAttribute("registrationInfo", new RegistrationData());
            theModel.addAttribute("validationErrorMessage", "This user ID already exists. Please use another ID");
            finalUrl = "common/registration";
        }

        if (bindingResult.hasErrors() || userAlreadyExists || roles.length == 0) {
            finalUrl = "common/registration";
        }

        //Save the user to database after all the required checks and encryption
        registrationDAO.processRegistration(registrationData,roles);

        return finalUrl;
    }*/

    @PostMapping("/processRegistration.htm")
    public String processRegistration(@Valid @ModelAttribute("registrationInfo") RegistrationData registrationData,
                                      BindingResult bindingResult,
                                      Model theModel) {
        String finalUrl = "common/registration_confirmation";
        /*form validation
        if(bindingResult.hasErrors()){
            theModel.addAttribute("registrationInfo",new RegistrationData());
            theModel.addAttribute("error-message","Please provide valid registration details");
        }*/


        //check the database if the user already exists
        boolean userAlreadyExists = registrationDAO.checkIfUserExists(registrationData.getUsername());
        if (userAlreadyExists) {
            theModel.addAttribute("registrationInfo", new RegistrationData());
            theModel.addAttribute("validationErrorMessage", "This user ID already exists. Please use another ID");
        }

        if (bindingResult.hasErrors() || userAlreadyExists) {
            finalUrl = "common/registration";
        } else {
            //Save the user to database after all the required checks and encryption
            registrationDAO.processRegistration(registrationData);
        }


        return finalUrl;
    }


}
