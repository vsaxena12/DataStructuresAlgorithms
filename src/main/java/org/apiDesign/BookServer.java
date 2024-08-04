package org.apiDesign;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class BookServer {
    private static final int PORT = 8000;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/books", new BookHandler());
        server.start();
        System.out.println("Server started on port " + PORT);
    }
}
