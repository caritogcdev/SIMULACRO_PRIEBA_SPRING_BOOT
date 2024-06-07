package com.riwi.simulacro_prueba_spring_boot.utils.exceptions;

/** Muestra un mensaje de error sobre el rol (si no viene)*/
public class BadRoleException extends RuntimeException{
    public BadRoleException (String message){
        super(message);
    }
}
