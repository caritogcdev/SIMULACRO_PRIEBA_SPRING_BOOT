package com.riwi.simulacro_prueba_spring_boot.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "lesson") //Nombre en la DB
@Data // Esta anotación trae: get, set, toString, equal hashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
    @Id // Especificando la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String lesson_title;
    @Column(columnDefinition = "TEXT")
    private String content;

    // Tiene 1 llave foránea
    // course_id
    // Tiene relación también con assignments

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id") // reference o constraint column (esta anotación hace la relación del constraint), name para colocarle como se va a llamar y referencedColumnName para colocar de donde viene, es decir, el nombre de la llave primaria, columnDefinition es para especificarle un nombre en específico
    private Course courseId; // Con quien vamos a hacer la relación. Esto es lo mismo que va en el mappedBy

    // Relación de 1 a Muchos con assignment
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            fetch = FetchType.EAGER, // Puede ser EAGER o LAZY, pero como queremos que nos traiga toda la lista, queremos que venga con el join de una vez, entonces lo dejamos como EAGER
            cascade = CascadeType.ALL,
            mappedBy = "lessonId",
            orphanRemoval = false
    )
    private List<Assignment> assignments;
}
