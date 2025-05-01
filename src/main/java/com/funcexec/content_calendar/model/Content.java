package com.funcexec.content_calendar;

import java.time.LocalDateTime;

public record Content(
	Integer id,
	String title,
	String desc,
	String status,
	String contentType,
	LocalDateTime dateCreated,
	LocalDateTime dateUpdated,
	String url
) {
}
