package com.example.demo.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "linea")
public class Linea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", length = 250)
    private String nombre;

    @Column(name = "estado", length = 3)
    private String estado;

    @Column(name = "Nota_max", length = 3)
    private String nota_max;

    @OneToOne(mappedBy = "linea")
    @JsonIgnore
    private Tutores tutores;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "linea")
    @JsonIgnore
    private Set<PPP> practicas;
    
    @ManyToMany(mappedBy = "lineas")
    @JsonIgnore
    private Set<EscuelaProfesional> escuelasProfesionales;

}
