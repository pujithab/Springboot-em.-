package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
@Transactional
public class StudentDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	public int RecordExistsOrNot(Student student ) {
		String hq="from  Student where firstname=:f and lastname=:l and branch=:b and address=:a";
		Query query=sessionFactory.getCurrentSession().createQuery(hq);
		query.setParameter("f",student.getFirstname());
		query.setParameter("l",student.getLastname());
		query.setParameter("b",student.getBranch());
		query.setParameter("a",student.getAddress());
		List list =query.list();
		if(list.size()>0)
		{
			return 0;
		}
		else
		
		return 1;
	}
	
public List<Student> StudentView(){
	String hql="from Student";
	List<Student> studList =new ArrayList<Student>();
	studList =sessionFactory.getCurrentSession().createQuery(hql).list();
	for(Student Details:studList) {
		System.out.println("id="+Details.getId()+"firstname="+Details.getFirstname()+"lastname="+Details.getLastname());
	}
	return studList;
}


  public void SaveOrUpdate(Student student)
  {
	  sessionFactory.getCurrentSession().saveOrUpdate(student);
	  
  }
  
  public Student getStudentById(int id) {
		/*String hq="from Book where id=:i";
		Query query=entityManager.createQuery(hq);
		query.setParameter("i",id1);
		Object  b=  query.getSingleResult();
		return b;*/
		Student ud =sessionFactory.getCurrentSession().load(Student.class,id);
		return ud;
	}

  public int StudentDelete(int id) {
		String hq="delete from Student where id=:i";
		Query query=sessionFactory.getCurrentSession().createQuery(hq);
		query.setParameter("i",id); 
		int status=query.executeUpdate(); 
		System.out.println(status);
		return status;
	}

  
  

}
	
	


