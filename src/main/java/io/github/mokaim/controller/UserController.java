package io.github.mokaim.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView){

        modelAndView.setViewName("register");

        return modelAndView;

    }

}
