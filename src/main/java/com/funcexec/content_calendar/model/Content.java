package com.funcexec.content_calendar.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record Content(
    Integer id,
    @NotBlank String title,
    String desc,
    String status,
    String contentType,
    LocalDateTime dateCreated,
    LocalDateTime dateUpdated,
    String url) {
}
