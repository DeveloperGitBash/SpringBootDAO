package com.boot.spring.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long sudentId;
	
	String studentName;
	
	public Student() {
		
	}

	public long getSudentId() {
		return sudentId;
	}

	public void setSudentId(long sudentId) {
		this.sudentId = sudentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	

}
