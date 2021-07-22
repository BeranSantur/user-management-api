package com.beransantur.usermanagementapi.utils.exceptions;

public class ListOfEntityNotFoundException extends RuntimeException{

    public ListOfEntityNotFoundException(String message) {
        super("No entity with STATUS: "+ message+ " has found");
    }

}
