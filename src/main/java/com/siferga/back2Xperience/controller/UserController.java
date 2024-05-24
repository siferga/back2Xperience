package com.siferga.back2Xperience.controller;

import ch.qos.logback.core.model.Model;
import com.siferga.back2Xperience.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView home(Model model) {
        return new ModelAndView("index");
    }

    @GetMapping("/chart")
    public ModelAndView callSp(@RequestParam int serviceId ) {
        String jsonData = UserService.convertListMapToJson(userService.callSpProjectCollaboratorsByService(serviceId));
        return new ModelAndView("chart", "jsonData", jsonData);
    }

}
