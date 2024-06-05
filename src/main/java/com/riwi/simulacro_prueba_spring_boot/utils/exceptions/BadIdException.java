package com.riwi.simulacro_prueba_spring_boot.utils.exceptions;

/** Excepción para cuando esté malo el ID
 *
 * RuntimeException recibe un string conocido como message,
 * acá se puede llamar como uno quiera, pero desde runtime
 * se llama como getMessage, acá le colocamos name para
 * hacer referencia a ese mensaje del nombre del error
 * */
public class BadIdException extends RuntimeException{
    public BadIdException(String name){
        super(name);
    }
}
