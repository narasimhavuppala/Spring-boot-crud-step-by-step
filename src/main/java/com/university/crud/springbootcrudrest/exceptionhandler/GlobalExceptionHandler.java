package com.university.crud.springbootcrudrest.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.annotation.Priority;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Map<String, String> handleClientSideException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

  /*  @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> getExceptions(Throwable t) {
        System.out.println(t.getMessage());
        System.out.println("Error Occureded");
        t.printStackTrace();
        return new ResponseEntity<String>("Error occured: " + t.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
