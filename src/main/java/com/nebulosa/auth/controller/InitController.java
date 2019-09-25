package com.nebulosa.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String firstPage() {
        return "hellow world";
    }


}
