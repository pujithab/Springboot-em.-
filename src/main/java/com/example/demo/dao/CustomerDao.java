package com.example.demo.dao;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;


@Repository
@Transactional
public class CustomerDao {
	@PersistenceContext
    private EntityManager entityManager;
	public void saveCustomer(Customer customer ) {
		entityManager.persist(customer);
	}
	
	public Set<Customer> CustomerView()
	{
	List <Customer>custlist=new ArrayList();
	String hql="from Customer";
	custlist= entityManager.createQuery(hql).getResultList();
	
	Set <Customer>custset=new LinkedHashSet(custlist);
	
	for(Customer Details:custlist) {
		System.out.println("id =  "+Details.getId()+" firstname=  "+ Details.getFirstname()+" lastname=  "+ Details.getLastname() +" address=  "+ Details.getAddress()+" mobileno ="+ Details.getMno());
	}
	return custset;
	}
	}
	
	
