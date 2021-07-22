package com.beransantur.usermanagementapi.utils.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
public class ExceptionResponse {
    private final String message;
    private final HttpStatus httpStatus;
    private final Date timeStamp;

    public ExceptionResponse(String message, HttpStatus httpStatus, Date timeStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }
}
