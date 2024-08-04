package org.apiDesign;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

public class BookHandler implements HttpHandler {
    private BookService bookService = new BookService();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        String response = "";
        int statusCode = 200;

        try {
            if ("GET".equalsIgnoreCase(method)) {
                if ("/books".equals(path)) {
                    response = bookService.getAllBooks().toString();
                } else if (path.matches("/books/\\d+")) {
                    int id = Integer.parseInt(path.split("/")[2]);
                    Optional<Book> book = bookService.getBookById(id);
                    if (book.isPresent()) {
                        response = book.get().toString();
                    } else {
                        statusCode = 404;
                        response = "Book not found";
                    }
                }
            } else if ("POST".equalsIgnoreCase(method) && "/books".equals(path)) {
                String requestBody = new String(exchange.getRequestBody().readAllBytes());
                Book book = new Book();
                book.setId(bookService.getAllBooks().size() + 1); // simple id generation
                book.setTitle(requestBody.split(",")[0]);
                book.setAuthor(requestBody.split(",")[1]);
                bookService.addBook(book);
                response = book.toString();
            } else if ("PUT".equalsIgnoreCase(method) && path.matches("/books/\\d+")) {
                int id = Integer.parseInt(path.split("/")[2]);
                String requestBody = new String(exchange.getRequestBody().readAllBytes());
                Book newBook = new Book();
                newBook.setTitle(requestBody.split(",")[0]);
                newBook.setAuthor(requestBody.split(",")[1]);
                Optional<Book> updatedBook = bookService.updateBook(id, newBook);
                if (updatedBook.isPresent()) {
                    response = updatedBook.get().toString();
                } else {
                    statusCode = 404;
                    response = "Book not found";
                }
            } else if ("DELETE".equalsIgnoreCase(method) && path.matches("/books/\\d+")) {
                int id = Integer.parseInt(path.split("/")[2]);
                boolean success = bookService.deleteBook(id);
                if (success) {
                    response = "Book deleted";
                } else {
                    statusCode = 404;
                    response = "Book not found";
                }
            } else {
                statusCode = 405;
                response = "Method Not Allowed";
            }
        } catch (Exception e) {
            statusCode = 500;
            response = "Internal Server Error";
            e.printStackTrace();
        }

        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(statusCode, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
