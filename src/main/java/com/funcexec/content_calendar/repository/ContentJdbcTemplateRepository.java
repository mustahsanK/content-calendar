package com.funcexec.content_calendar.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.funcexec.content_calendar.model.Content;

@Repository
public class ContentJdbcTemplateRepository {

  private final JdbcTemplate jdbcTemplate;

  ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public static Content mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Content(
        rs.getInt("id"),
        rs.getString("title"),
        rs.getString("desc"),
        rs.getString("status"),
        rs.getString("contentType"),
        rs.getTimestamp("dateCreated").toLocalDateTime(),
        rs.getTimestamp("dateUpdated").toLocalDateTime(),
        rs.getString("url"));
  }

  public List<Content> getAllContent() {
    String sql = "SELECT * FROM Content";
    List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
    return contents;
  }

  public Content getContent(Integer id) {
    String sql = "SELECT * FROM Content WHERE id=?";
    Content content = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow, id).getFirst();
    return content;
  }

  public void createContent(Content c) {
    String sql = "INSERT INTO Content (title, desc, status, contentType, dateCreated, url) VALUES(?, ?, ?, ?, NOW(), ?)";
    jdbcTemplate.update(sql, c.title(), c.desc(), c.status(), c.contentType(), c.url());
  }

  public void updateContent(Content c, Integer id) {
    String sql = "UPDATE Content SET title=?, desc=?, status=?, contentType=?, dateUpdated=NOW(), url=? WHERE id=?";
    jdbcTemplate.update(sql, c.title(), c.desc(), c.status(), c.contentType(), c.url(), id);
  }

  public void deleteContent(int id) {
    String sql = "DELETE FROM Content WHERE id=?";
    jdbcTemplate.update(sql, id);
  }
}
