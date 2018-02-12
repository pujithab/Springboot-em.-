package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Book;

@Repository
@Transactional
public class BookDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	
	public void saveBook(Book book ) {
		
		
		entityManager.persist(book);

	}
	
public int RecordExistsOrNot(Book book ) {
		
	String hq="from  Book where name=:n ";
	Query query=entityManager.createQuery(hq);
	
	query.setParameter("n",book.getName()); 
	int status =query.getFirstResult();
	
	System.out.println(status);
	return status;

	}
	
	
	public List<Book> BookView()
	{
		
		String hql ="from Book";
		
		List<Book> booksList1 =new ArrayList<Book>();
		
		booksList1 =entityManager.createQuery(hql).getResultList();
		for(Book Details:booksList1) {
			System.out.println("id="+Details.getId()+"name="+Details.getName());
		}
		return booksList1;
	}
	
	public void BookUpdate(int id) {
		
		String hq="update Book set name=:n where id=:i";
		Query query=entityManager.createQuery(hq);
		
		query.setParameter("i",id); 
		
		int status=query.executeUpdate(); 
		
		System.out.println(status);
		
	}

		/*public void BookUpdate() {
			
		List<Book> booksList2 =new ArrayList<Book>();
		String ql ="update Book set name=:n where id=:i";
		
		
		Query q=entityManager.createQuery(ql);  
		q.setParameter("n","Udit Kumar");  
		q.setParameter("i",2);  
		
		int status=q.executeUpdate(); 
		
		System.out.println(status);
		for(Book Details:booksList2) {
			System.out.println("id="+Details.getId()+"name="+Details.getName());
		}
		
		}*/
		
		/*public void BookDelete() {
			
			String hq="delete from Book where id=1";
			Query query=entityManager.createQuery(hq);
			query.executeUpdate();
		}
		*/
		
public void BookDelete(int id) {
			
			String hq="delete from Book where id=:i";
			Query query=entityManager.createQuery(hq);
			
			query.setParameter("i",id); 
			
			int status=query.executeUpdate(); 
			
			System.out.println(status);
			
		}
	
			
}

