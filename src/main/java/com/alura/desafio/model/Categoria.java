package com.alura.desafio.model;

public enum Categoria {
    BALADAS("Baladas"),
    REGGATON("Perreo"),
    REGEE("Soft"),
    SALSA("Bailable"),
    VALLENATO("Vallenato");
    private String categoria;
    Categoria(String categoria){
        this.categoria = categoria;
    }
    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoria.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

}
