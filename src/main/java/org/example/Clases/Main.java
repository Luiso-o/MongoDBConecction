package org.example.Clases;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Ticket> tickets = new ArrayList<>();

        Ticket ticket1 = new Ticket();

        ticket1.getProductos().add(new Arbol("Arbol",3,4.0));
        ticket1.getProductos().add(new Flor("Flor","Rojo",3.1));
        ticket1.getProductos().add(new Decoracion("Decoración", "Madera",5.2));

        Ticket ticket2 = new Ticket();

        ticket2.getProductos().add(new Arbol("Arbol",1,2.2));
        ticket2.getProductos().add(new Flor("Flor","Amarilla",5.6));
        ticket2.getProductos().add(new Decoracion("Decoración", "Plástico",4.2));

        Ticket ticket3 = new Ticket();

        ticket3.getProductos().add(new Arbol("Arbol",3,3.5));
        ticket3.getProductos().add(new Flor("Flor","Verde",2.1));
        ticket3.getProductos().add(new Decoracion("Decoración", "Madera",3.2));

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);

        Connection connection = new Connection();
        connection.guardarTicketsEnDB(tickets);


    }

}
