package com.beransantur.usermanagementapi.utils.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super("ID: " + message + " is not found. ");
    }

}
