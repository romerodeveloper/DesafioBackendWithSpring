package com.alura.desafio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    @ManyToOne
    private Cantante cantante;

    public Cancion(){}

    public Cancion(String nombre, String genero) {
        this.nombre = nombre;
        this.genero = Categoria.fromString(genero);

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

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public Cantante getCantante() {
        return cantante;
    }

    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }
}
