package com.riwi.simulacro_prueba_spring_boot.utils.exceptions;

public class BadRoleException extends RuntimeException{
    public BadRoleException (String message){
        super(message);
    }
}
