package com.beransantur.usermanagementapi.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler {
    private static final HttpStatus notFound = HttpStatus.NOT_FOUND;

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                entityNotFoundException.getMessage(),
                notFound,
                new Date()
        );
        return new ResponseEntity<>(exceptionResponse, notFound);
    }

    @ExceptionHandler(value = {DataBaseSystemException.class})
    public ResponseEntity<Object> handleDatabaseSystemException(DataBaseSystemException dataBaseSystemException) {
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                dataBaseSystemException.getMessage(),
                internalServerError,
                new Date());

        return new ResponseEntity<>(exceptionResponse, internalServerError);
    }

    @ExceptionHandler(value = {ListOfEntityNotFoundException.class})
    public ResponseEntity<Object> handleListOfEntityNotFoundException(ListOfEntityNotFoundException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage(),
                notFound,
                new Date());

        return new ResponseEntity<>(exceptionResponse, notFound);
    }
}
