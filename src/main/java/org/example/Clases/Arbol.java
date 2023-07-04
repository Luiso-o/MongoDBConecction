package org.example.Clases;

public class Arbol extends Producto {
    private int altura;

    public Arbol(String nombre,int altura, double precio) {
        super(nombre, precio);
        this.altura = altura;
    }

    // Getters y setters

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
