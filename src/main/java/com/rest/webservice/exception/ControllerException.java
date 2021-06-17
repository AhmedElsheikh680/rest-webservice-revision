package com.rest.webservice.exception;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> getExceptionNotFound(StudentException studentException){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentException.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> getException( Exception e){
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(e.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
