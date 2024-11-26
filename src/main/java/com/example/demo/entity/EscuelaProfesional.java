package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "escuela_profesional")
public class EscuelaProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "carrera", length = 250)
    private String carrera;

    @ManyToOne
    @JoinColumn(name = "id_facultad", nullable = false)
    @JsonIgnore
    private Facultad facultad;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "escuelaProfesional")
    @JsonIgnore
    private Set<Directora> directoras;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "escuelaProfesional")
    @JsonIgnore
    private Set<Tutores> tutores;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "escuelaProfesional")
    @JsonIgnore
    private Set<Practicante_EP> practicante_EP;

    @OneToMany(mappedBy = "escuelaProfesional", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Coordinador> coordinadores;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "escuela_linea",
        joinColumns = @JoinColumn(name = "escuela_id"),
        inverseJoinColumns = @JoinColumn(name = "linea_id")
    )
    private Set<Linea> lineas = new HashSet<>();

}
