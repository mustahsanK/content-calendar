package com.funcexec.content_calendar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    @GetMapping("/")
    public String content() {
        return "Content Calendar";
    }
}
