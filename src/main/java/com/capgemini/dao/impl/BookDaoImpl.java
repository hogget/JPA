package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.BookDao;
import com.capgemini.domain.Book;

@Repository
public class BookDaoImpl extends AbstractDao<Book, Long> implements BookDao {

    @Override
    public List<Book> findBookByTitle(String title) {
        TypedQuery<Book> query = entityManager.createQuery(
                "select book from BookEntity book where upper(book.title) like concat(upper(:title), '%')", Book.class);
        query.setParameter("title",  title);
        return query.getResultList();
    }
    
	@Override
	public List<Book> findBooksByAuthor(Long authorId) {
		TypedQuery<Book> query = entityManager.createNamedQuery("books.findBooksByAuthor", Book.class);
		query.setParameter("authorId", authorId);
		return query.getResultList();
	}
}
