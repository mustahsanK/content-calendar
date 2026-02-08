package com.funcexec.content_calendar.repository;

import com.funcexec.content_calendar.model.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ContentCollectionRepository {
  private final List<Content> content = new ArrayList<>();

  public ContentCollectionRepository() {
  }

  public List<Content> findAll() {
    return content;
  }

  public boolean existsById(Integer id) {
    return content.stream().filter(o -> o.id().equals(id)).count() == 1;
  }

  public Optional<Content> findById(Integer id) {
    return content.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  public void save(Content c) {
    content.add(c);
  }

  public void modifyById(Content c, Integer id) {
    content.removeIf(o -> o.id().equals(id));
    content.add(c);
  }

  public void removeById(Integer id) {
    content.removeIf(o -> o.id().equals(id));
  }
}
