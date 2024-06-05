package com.riwi.simulacro_prueba_spring_boot.utils.enums;

/** Es una colección de datos que nos obliga si o sí a escoger
 * una de las opciones que tiene por dentro.
 *
 * Se puede hacer de lña siguiente manera:
 * {
 *     STUDENT,
 *     TEACHER
 * }
 *
 * Pero también se puede hacer de la siguiente manera:
 *
 * STUDENT=("STUDENT"),
 * TEACHER=("TEACHER")
 * */
public enum Role {
    ADMIN,
    STUDENT,
    INSTRUCTOR
}
