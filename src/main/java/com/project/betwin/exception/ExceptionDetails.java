package com.project.betwin.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {
    protected String title;
    protected String details;
    protected HttpStatus httpStatus;
    protected LocalDateTime timestamp;
}
