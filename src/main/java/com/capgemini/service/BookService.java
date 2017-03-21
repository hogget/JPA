package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.Book;

public interface BookService {
    List<Book> findAllBooks();
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(Long authorId);
    Book findBookById(Long id);

    Book saveBook(Book book);
}
