package com.riwi.simulacro_prueba_spring_boot.utils.exceptions;

public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException(String id){
        super(id);
    }
}
