package com.controller;

import org.springframework.boot.web.servlet.error.ErrorController;

public class MyErrorController implements ErrorController{

//	@RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "error";
    }
}
