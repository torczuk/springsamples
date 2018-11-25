package com.github.torczuk;

import com.github.torczuk.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleAccessDeniedException(Exception ex, WebRequest request) {
        String message = ex.getMessage();
        return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
