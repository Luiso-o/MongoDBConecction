package org.example.Clases;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private static int contador = 1;
    private final int idTicket;
    private final List<Producto> productos;

    public Ticket() {
        this.idTicket = contador++;
        this.productos = new ArrayList<>();
    }

    // Métodos para agregar y obtener productos
    public List<Producto> getProductos() {
        return productos;
    }

    // Getters y setters

    public int getIdTicket() {
        return idTicket;
    }

}
