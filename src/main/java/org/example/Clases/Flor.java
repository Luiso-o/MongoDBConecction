package org.example.Clases;

public class Flor extends Producto {
    private String color;

    public Flor(String nombre,String color, double precio) {
        super(nombre, precio);
        this.color = color;
    }

    // Getters y setters

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

