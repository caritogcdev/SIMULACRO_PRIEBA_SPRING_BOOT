package com.riwi.simulacro_prueba_spring_boot.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "message") //Nombre en la DB
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id // Especificando la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long message_id;
    @Column(columnDefinition = "TEXT")
    private String message_content;
    private LocalDate sent_date;

    // Relación de Muchos a 1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    private User userSender; // Esto es lo mismo que va en el mappedBy

    // Relación de Muchos a 1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", referencedColumnName = "user_id")
    private User userReceiver; // Esto es lo mismo que va en el mappedBy

    // Relación de Muchos a 1 con course
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course; // Esto es lo mismo que va en el mappedBy
}
