package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;
import com.example.demo.model.Test;
@Repository
@Transactional
public class TestDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	
	public void saveTest(Test test ) {
		entityManager.persist(test);

	}
	public List<Test> TestView()
	{
		List<Test> testList= new ArrayList<Test>();
		String hql="from Test";
		testList =entityManager.createQuery(hql).getResultList();
		for(Test Details:testList) {
			System.out.println("id="+Details.getId() +"\nftname="+Details.getFtname() +"\nlname="+Details.getLname());
		}
		return testList;
	}
	
	public void TestUpdate() {
		
		List<Test> testList2 =new ArrayList<Test>();
		String ql ="update Test set lname=:n where id=:i";
		
		
		Query q=entityManager.createQuery(ql);  
		q.setParameter("n","Udit Kumar");  
		q.setParameter("i",1);  
		
		int status=q.executeUpdate(); 
		
		System.out.println(status);
		for(Test Details:testList2) {
			System.out.println("id="+Details.getId()+"lname="+Details.getLname());
		}
		
		}
		
		public void TestDelete() {
			
			String hq="delete from Test where id=1";
			Query query=entityManager.createQuery(hq);
			query.executeUpdate();
			int status=query.executeUpdate(); 
			System.out.println(status);
			
		}
		
		
public void TestDelete(int id) {
			
			String hq="delete from Test where id=:i";
			Query query=entityManager.createQuery(hq);
			
			query.setParameter("i",id); 
			
			int status=query.executeUpdate(); 
			
			System.out.println(status);
			
		}
	
	
	
}
