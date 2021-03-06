package com.penulisan.ilmiah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Irman Juliansyah
 */

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "user/register";
    }

}
