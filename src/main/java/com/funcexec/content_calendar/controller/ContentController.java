package com.funcexec.content_calendar.controller;

import com.funcexec.content_calendar.model.Content;
import com.funcexec.content_calendar.repository.ContentCollectionRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/content")
public class ContentController {

  private final ContentCollectionRepository repository;

  public ContentController(ContentCollectionRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/about")
  public String content() {
    return "Content Calendar";
  }

  @GetMapping("")
  public List<Content> findAll() {
    return repository.findAll();
  }
}
