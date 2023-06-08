package com.boot.spring.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long deptId;
	@Column(name="deptName")
	String depNane;
	@Column(name="hodName")
	String hodName;
	@Column(name="hodContact")
	String hodContact;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_dep_id", referencedColumnName = "deptId")
	private List<Student> students;

	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDepNane() {
		return depNane;
	}

	public void setDepNane(String depNane) {
		this.depNane = depNane;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

	public String getHodContact() {
		return hodContact;
	}

	public void setHodContact(String hodContact) {
		this.hodContact = hodContact;
	}

	
	
}
