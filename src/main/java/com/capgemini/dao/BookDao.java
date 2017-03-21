package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.Book;

public interface BookDao extends Dao<Book, Long> {

    List<Book> findBookByTitle(String title);

	List<Book> findBooksByAuthor(Long authorId);
}
