package com.github.fajarvm.restwebservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Redirect to swagger-ui API docs page
 */
@ApiIgnore
@Controller
public class ApiHomeController {
    @RequestMapping(value = "/")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}
