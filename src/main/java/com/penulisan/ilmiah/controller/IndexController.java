package com.penulisan.ilmiah.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Irman Juliansyah
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/home/kebudayaan/{idKebudayaan}", method = RequestMethod.GET)
    public String detailKebudayaan() {
        return "detail_kebudayaan";
    }

}
