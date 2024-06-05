package com.riwi.simulacro_prueba_spring_boot.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "enrollment") //Nombre en la DB
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id // Especificando la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollment_id;
    private LocalDate enrollment_date;

    // Tiene 2 llaves foráneas
    // user_id
    // course_id

    // Muchos a 1 con user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id") // reference o constraint column (esta anotación hace la relación del constraint), name para colocarle como se va a llamar y referencedColumnName para colocar de donde viene, es decir, el nombre de la llave primaria, columnDefinition es para especificarle un nombre en específico
    private User user; // Con quien vamos a hacer la relación. Esto es lo mismo que va en el mappedBy

    // Muchos a 1 con course
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id") // reference o constraint column (esta anotación hace la relación del constraint), name para colocarle como se va a llamar y referencedColumnName para colocar de donde viene, es decir, el nombre de la llave primaria, columnDefinition es para especificarle un nombre en específico
    private Course course; // Con quien vamos a hacer la relación. Esto es lo mismo que va en el mappedBy

}
