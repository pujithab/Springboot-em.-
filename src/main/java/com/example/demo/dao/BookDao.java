package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
@Transactional
public class BookDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	
	public void saveBook(Book book ) {
		entityManager.persist(book);

	}
	

}
