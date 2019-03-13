package com.pack.model;
import java.util.*;
import java.util.Date;

public class Employee {
	private int id;
	private String name;
	private float sal;
	private Date dob;
	private String designation;
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
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Employee(int id, String name, float sal, Date dob, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.dob = dob;
		this.designation = designation;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, float sal, String designation) {
		super();
		this.id = id;
		this.sal = sal;
		this.designation = designation;
	}
	

}
