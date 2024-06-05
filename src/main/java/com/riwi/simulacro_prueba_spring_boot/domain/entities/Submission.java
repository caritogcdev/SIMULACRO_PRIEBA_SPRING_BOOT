package com.riwi.simulacro_prueba_spring_boot.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "submission") //Nombre en la DB
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Submission {
    @Id // Especificando la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT") //Anotación de Hibernate para definir el tipo de columna como TEXT en vez de @Column(columnDefinition = "TEXT"), ambas anotaciones sirven
    private String content;
    @Builder.Default
    private LocalDateTime submission_date = LocalDateTime.now();
    @Column(precision = 5, scale = 2) // otra forma es @Column(columnDefinition = "DECIMAL(5,2)")
    private BigDecimal grade;

    //Recibe 2 llaves foráneas
    //user_id;
    //assignment_id;

    // Muchos a 1 con user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id") // Nombre de llave foránea y Llave primaria de donde viene
    private User userId; // Esto es lo mismo que va en el mappedBy

    // Muchos a 1 con assignment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignment_id", referencedColumnName = "id")
    private Assignment assignmentId; // Esto es lo mismo que va en el mappedBy
}

/** NOTA: Cuando la relación es unidireccional se empieza por la entidad débil */