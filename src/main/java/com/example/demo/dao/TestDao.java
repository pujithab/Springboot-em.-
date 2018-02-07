package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Test;
@Repository
@Transactional
public class TestDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	
	public void saveTest(Test test ) {
		entityManager.persist(test);

	}
}
