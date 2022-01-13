package com.example.resttest02.api;

import com.example.resttest02.domain.DefaultResponse;
import com.example.resttest02.exception.ClientAlreadyRegistered;
import com.example.resttest02.exception.ClientNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request) {
    Map<String, List<String>> body = new HashMap<>();

    List<String> errors =
        ex.getBindingResult().getFieldErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());

    body.put("errors", errors);

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ClientAlreadyRegistered.class)
  protected ResponseEntity<Object> handleClientAlreadyRegistered(ClientAlreadyRegistered ex) {
    DefaultResponse response =
        DefaultResponse.builder().CVE_Error("campo_duplicado").CVE_Mensaje(ex.getMessage()).build();

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ClientNotFoundException.class)
  protected ResponseEntity<Object> handleClientNotFoundException(ClientNotFoundException ex) {
    DefaultResponse response =
        DefaultResponse.builder().CVE_Error("id_invalida").CVE_Mensaje(ex.getMessage()).build();

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

}
