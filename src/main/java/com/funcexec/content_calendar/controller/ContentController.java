package com.funcexec.content_calendar.controller;

import com.funcexec.content_calendar.model.Content;
import com.funcexec.content_calendar.repository.ContentCollectionRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

  @GetMapping("/{id}")
  public Optional<Content> find(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return repository.findById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void create(@RequestBody Content c) {
    repository.save(c);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PostMapping("/{id}")
  public void update(@RequestBody Content c, @PathVariable Integer id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    repository.modifyById(c, id);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    repository.removeById(id);
  }
}
