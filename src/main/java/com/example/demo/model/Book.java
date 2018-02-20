package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String name;
		private String author;
		private String quantity;
		private String mobileno;
		private String date;
		private String files;
		

		public Book(int id, String name, String author, String quantity, String files, String mobileno, String date) {
			super();
			this.id = id;
			this.name = name;
			this.author = author;
			this.quantity = quantity;
			this.mobileno= mobileno;
			this.date=date;
			this.files=files;
		}
		public Book() {
			
		}
		
		
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getMobileno() {
			return mobileno;
		}
		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}
		public String getFiles() {
			return files;
		}
		public void setFiles(String files) {
			this.files = files;
		}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getQuantity() {
			return quantity;
		}

		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "Book [id=" + id + ", name=" + name + ", author=" + author + ", quantity=" + quantity + ", mobileno="
					+ mobileno + ", date=" + date + ", files=" + files + "]";
		}
		
		

		

		
		
			
			
			
		

		

	}


