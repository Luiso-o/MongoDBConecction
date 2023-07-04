package org.example.Clases;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Connection {
    private static final String DATABASE_URI = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "TiendaDB";
    private static final String COLLECTION_NAME = "MisTickets";

    public void guardarTicketsEnDB(ArrayList<Ticket> tickets) {
        MongoClientURI uri = new MongoClientURI(DATABASE_URI);
        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> ticketsCollection = database.getCollection(COLLECTION_NAME);

            List<Document> documentosTickets = new ArrayList<>();
            for (Ticket ticket : tickets) {
                Document documentoTicket = new Document("productos", new ArrayList<>());
                for (Producto producto : ticket.getProductos()) {
                    if (producto instanceof Arbol arbol) {
                        documentoTicket.getList("productos", Document.class).add(new Document("nombre", arbol.getNombre())
                                .append("altura", arbol.getAltura()).append("precio", arbol.getPrecio()));

                    } else if (producto instanceof Flor flor) {
                        documentoTicket.getList("productos", Document.class).add(new Document("nombre", flor.getNombre())
                                .append("color", flor.getColor()).append("precio", flor.getPrecio()));

                    } else if (producto instanceof Decoracion decoracion) {
                        documentoTicket.getList("productos", Document.class).add(new Document("nombre", decoracion.getNombre())
                                .append("material", decoracion.getMaterial()).append("precio", decoracion.getPrecio()));
                    }
                }
                documentosTickets.add(documentoTicket);
            }

            ticketsCollection.insertMany(documentosTickets);

            System.out.println("Los tickets se han guardado en la base de datos correctamente.");
        } catch (Exception e) {
            System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
        }
    }

    public void guardarTicketEnDB(Ticket ticket) {
        MongoClientURI uri = new MongoClientURI(DATABASE_URI);
        try (MongoClient mongoClient = new MongoClient(uri)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> ticketsCollection = database.getCollection(COLLECTION_NAME);

            Document documentoTicket = new Document("productos", new ArrayList<>());
            for (Producto producto : ticket.getProductos()) {
                if (producto instanceof Arbol arbol) {
                    documentoTicket.getList("productos", Document.class).add(new Document("nombre", arbol.getNombre())
                            .append("altura", arbol.getAltura()).append("precio", arbol.getPrecio()));

                } else if (producto instanceof Flor flor) {
                    documentoTicket.getList("productos", Document.class).add(new Document("nombre", flor.getNombre())
                            .append("color", flor.getColor()).append("precio", flor.getPrecio()));

                } else if (producto instanceof Decoracion decoracion) {
                    documentoTicket.getList("productos", Document.class).add(new Document("nombre", decoracion.getNombre())
                            .append("material", decoracion.getMaterial()).append("precio", decoracion.getPrecio()));
                }
            }

            ticketsCollection.insertOne(documentoTicket);

            System.out.println("El ticket se ha guardado en la base de datos correctamente.");
        } catch (Exception e) {
            System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
        }
    }


}
