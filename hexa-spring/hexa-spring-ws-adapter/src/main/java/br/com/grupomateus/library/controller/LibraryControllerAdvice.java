package br.com.grupomateus.library.controller;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LibraryControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IllegalAccessException.class)
  public ResponseEntity<ErrorMessage> handleGenericException(IllegalAccessException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(ErrorMessage.builder()
            .title("Validation error")
            .message(ex.getMessage())
            .build()
        );
  }

  @Data
  @Builder
  public static class ErrorMessage {
    private String title;
    private String message;
    private String code;
  }

}
