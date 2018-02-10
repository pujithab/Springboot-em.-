package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;
import com.example.demo.model.Employee;

@Repository
@Transactional
public class EmployeeDao {

	@PersistenceContext
    private EntityManager entityManager;
	
	
	public void saveEmployee(Employee emp ) {
		entityManager.persist(emp);

	}
	public List<Employee>  Employeeview()
	{
		List<Employee> empList =new ArrayList<Employee>();
		String hql= "from Employee";
		empList =entityManager.createQuery(hql).getResultList();
		for(Employee Details: empList) {
			System.out.println("id="+Details.getId() +"\nname="+Details.getName() +"\nfname="+Details.getFname());
		}
		return empList;
	}
	
	public void EmployeeUpdate() {
		
		List<Employee> empList2 =new ArrayList<Employee>();
		String ql ="update Employee set name=:n where id=:i";
		
		
		Query q=entityManager.createQuery(ql);  
		q.setParameter("n","Udit Kumar");  
		q.setParameter("i",1);  
		
		int status=q.executeUpdate(); 
		
		System.out.println(status);
		for(Employee Details:empList2) {
			System.out.println("id="+Details.getId() +"\nname="+Details.getName() +"\nfname="+Details.getFname());
		}
		
		}
	
	public void EmployeeDelete() {
		
		String hq="delete from Employee where id=1";
		Query query=entityManager.createQuery(hq);
		query.executeUpdate();
		int status=query.executeUpdate(); 
		
		System.out.println(status);
	}
	
	
public void EmployeeDelete(int id) {
		
		String hq="delete from Employee where id=:i";
		Query query=entityManager.createQuery(hq);
		
		query.setParameter("i",id); 
		
		int status=query.executeUpdate(); 
		
		System.out.println(status);
		
	}
	
}
