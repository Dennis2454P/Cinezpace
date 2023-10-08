package com.zinespace.autocines.modelo;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    private String contrasena;

    /* @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Singular
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")  Esta columna "usuario_id" se utiliza como clave foránea en Ticket
    private List<ticket> tickets;*/
}