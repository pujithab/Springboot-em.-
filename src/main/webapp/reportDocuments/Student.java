package com.example.demo.model;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student  implements Comparator<Student> {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private String branch;
	private String address;
	private String jdate;
	private String files;
	private String mno;
	
	public Student(int id, String firstname, String lastname, String branch, String address, String jdate, String files, String mno) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.branch = branch;
		this.address = address;
		this.jdate = jdate;
		this.files = files;
		this.mno= mno;
	}
	
	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getFiles() {
		return files;
	}
	public void setFiles(String files) {
		this.files = files;
	}
	public String getJdate() {
		return jdate;
	}
	public void setJdate(String jdate) {
		this.jdate = jdate;
	}
	public Student() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", branch=" + branch
				+ ", address=" + address + ", jdate=" + jdate + ", files=" + files + ", mno=" + mno + "]";
	}


	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}*/
	/*@Override
	public int compareTo(Student o) {
		  String fruitName1 = this.firstname;
	      String fruitName2 = o.getFirstname();
	      return -fruitName2.compareTo(fruitName1);

	}*/
	/*@Override
	public int compareTo(Student p) 
	{
	return -firstname.compareTo(p.firstname);
	}
	*/
	
	/*@Override
	public int compareTo(Student  o) {
		// TODO Auto-generated method stub
	if(id>o.id)
			return 1;
		else if(id>o.id)
		return -1;
		else
		return 0;
	}*/
	@Override
	public int compare(Student o1, Student o2) {
		String s1=o1.getFirstname();
		String s2 =o2.getFirstname();
		
		return  s1.compareToIgnoreCase(s2);
	}
	
	
}
