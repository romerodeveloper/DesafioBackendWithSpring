package com.alura.desafio.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Cantantes")
public class Cantante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    @OneToMany(mappedBy = "cantante" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cancion> canciones;

    public Cantante(){}

    public Cantante(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        canciones.forEach(e -> e.setCantante(this));
        this.canciones = canciones;
    }
}
