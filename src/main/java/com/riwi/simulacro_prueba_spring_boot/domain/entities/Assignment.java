package com.riwi.simulacro_prueba_spring_boot.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "assignment") //Nombre en la DB
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id // Especificando la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignment_id;
    @Column(length = 100, nullable = false)
    private String assignment_title;
    // @Lob se utiliza para mapear datos de tipo TINYTEXT
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDate due_date;

    // Recibe 1 llave foránea
    // lesson_id;
    // Tiene relación también

    // Relación de muchos a 1 lesson
    @ManyToOne(fetch = FetchType.LAZY) // LAZY es carga perezosa
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id") // reference o constraint column (esta anotación hace la relación del constraint), name para colocarle como se va a llamar y referencedColumnName para colocar de donde viene, es decir, el nombre de la llave primaria, columnDefinition es para especificarle un nombre en específico
    private Lesson lesson; // Con quien vamos a hacer la relación

    // Relación de 1 a Muchos con submissions
    @OneToMany(
            fetch = FetchType.EAGER, // Puede ser EAGER o LAZY, pero como queremos que nos traiga toda la lista, queremos que venga con el join de una vez, entonces lo dejamos como EAGER
            cascade = CascadeType.ALL, // Que se actualicen todos los assignments
            mappedBy = "assignment", // mappedBy es el nombre de quien lo está mapeando a él en la otra clase
            orphanRemoval = false // Si se elimina esto, también se eliminan todas las submissions de esto
    )
    private List<Submission> submissions;

}
