package com.riwi.simulacro_prueba_spring_boot.domain.entities;

import com.riwi.simulacro_prueba_spring_boot.utils.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "user") //Nombre en la DB
@Data // Esta anotación trae: get, set, toString, equal hashCode
@Builder // Patrón de diseño para crear clases
/**
 * Sin el patrón de diseño builder, las clases se crean de la
 * siguiente manera:
 * Clase clase = new Clase
 * Clase.setName("dsdsfd")
 * clase.setAge(23);
 *
 * Con el patrón de diseño builder la creamos de la siguiente manera
 * por ejemplo::
 * Clase.builder()
 * .name("ddsfdf")
 * .age(12)
 * .build();
 * */
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id // Especificando la primary key
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 100)
    private String full_name;

    // Enum
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    /** Para que no se cree un bucle de toString, tenemos que quitar
     * esto del toString de lombook con la anotación @ToString.Exclude
     * para que lombook dentro de su anotación @Data le haga toString
     * a la entidad como tal (lo que hay arriba) menos a lo de abajo
     * (las relaciones).
     * Para que no genere una llave dentro de Java, (un serial)
     * utilizamos la anotación @EqualsAndHashCode.Exclude, esto es
     * para no crear otro espacio en memoria */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    // Relación de entidades
    // De 1 a Muchos con enrollment
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, //El EAGER es para que venga con el join implícito. El EAGER se utiliza en la relación fuerte. // Puede ser EAGER o LAZY, pero como queremos que nos traiga toda la lista, queremos que venga con el join de una vez, entonces lo dejamos como EAGER
            mappedBy = "userId", // mappedBy es el nombre de quien lo está mapeando a él en la otra clase
            orphanRemoval = false
    )
    private List<Enrollment> enrollments; // Es una lista porque es de uno a muchos

    // De 1 a Muchos con course
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, // Puede ser EAGER o LAZY, pero como queremos que nos traiga toda la lista, queremos que venga con el join de una vez, entonces lo dejamos como EAGER
            mappedBy = "userInstructor", // mappedBy es el nombre de quien lo está mapeando a él en la otra clase
            orphanRemoval = false
    )
    private List<Course> courses;

    // De 1 a Muchos message sender
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, // Puede ser EAGER o LAZY, pero como queremos que nos traiga toda la lista, queremos que venga con el join de una vez, entonces lo dejamos como EAGER
            mappedBy = "userSender", // mappedBy es el nombre de quien lo está mapeando a él en la otra clase
            orphanRemoval = false
    )
    private List<Message> messagesSender;

    // De 1 a Muchos message receiver
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, // Puede ser EAGER o LAZY, pero como queremos que nos traiga toda la lista, queremos que venga con el join de una vez, entonces lo dejamos como EAGER
            mappedBy = "userReceiver", // mappedBy es el nombre de quien lo está mapeando a él en la otra clase
            orphanRemoval = false
    )
    private List<Message> messagesReceiver;

    // De 1 a muchos submissions
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, // Puede ser EAGER o LAZY, pero como queremos que nos traiga toda la lista, queremos que venga con el join de una vez, entonces lo dejamos como EAGER
            mappedBy = "userId", // mappedBy es el nombre de quien lo está mapeando a él en la otra clase
            orphanRemoval = false
    )
    private List<Submission> submissions;

}
