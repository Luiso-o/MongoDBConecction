package org.example.Clases;

public class Decoracion extends Producto {
    private String material;

    public Decoracion(String nombre,String material, double precio) {
        super(nombre, precio);
        this.material = material;
    }

    // Getters y setters

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
