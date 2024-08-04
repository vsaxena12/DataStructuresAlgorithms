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
                //return books.stream().filter(book -> book.getId() == id).findFirst();
                for (Book book : books) {
                        if (book.getId() == id) {
                            return Optional.of(book);
                        }
                }
                return Optional.empty();
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
