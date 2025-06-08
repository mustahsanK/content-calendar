package com.funcexec.content_calendar.controller;

import com.funcexec.content_calendar.repository.ContentCollectionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/")
    public String content() {
        return "Content Calendar";
    }
}
