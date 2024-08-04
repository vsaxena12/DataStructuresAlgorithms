# APIs

- Get all books: curl -X GET http://localhost:8000/books
- Get book by ID: curl -X GET http://localhost:8000/books/1
- Add a new book: curl -X POST -d "New Book,Author" http://localhost:8000/books
- Update a book: curl -X PUT -d "Updated Book,New Author" http://localhost:8000/books/1
- Delete a book: curl -X DELETE http://localhost:8000/books/1

Book.java

        package org.apiDesign;

        /**
        * Creating a model
        */
        public class Book {
                private int id;
                private String title;
                private String author;

                public Book() {}

                public Book(int id, String title, String author) {
                        this.id = id;
                        this.title = title;
                        this.author = author;
                }

                public int getId() {
                        return id;
                }

                public void setId(int id) {
                        this.id = id;
                }

                public String getTitle() {
                        return title;
                }

                public void setTitle(String title) {
                        this.title = title;
                }

                public String getAuthor() {
                        return author;
                }

                public void setAuthor(String author) {
                        this.author = author;
                }

                @Override
                public String toString() {
                        return "Book{" +
                                "id=" + id +
                                ", title='" + title + '\'' +
                                ", author='" + author + '\'' +
                                '}';
                }
        }

BookHandler.java

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

        package org.apiDesign;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

        public class BookService {
                private List<Book> books = new ArrayList<>();

                public List<Book> getAllBooks() {
                        return books;
                }

                public Optional<Book> getBookById(int id) {
                        return books.stream().filter(book -> book.getId() == id).findFirst();
                }

                public Book addBook(Book book) {
                        books.add(book);
                        return book;
                }

                public Optional<Book> updateBook(int id, Book newBook) {
                        Optional<Book> optionalBook = getBookById(id);
                        optionalBook.ifPresent(book -> {
                        book.setTitle(newBook.getTitle());
                        book.setAuthor(newBook.getAuthor());
                        });
                        return optionalBook;
                }

                public boolean deleteBook(int id) {
                        return books.removeIf(book -> book.getId() == id);
                }
        }