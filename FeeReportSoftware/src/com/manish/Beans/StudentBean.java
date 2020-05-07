package com.manish.Beans;

import java.sql.Date;

public class StudentBean {
private int rollno;
private String name,email,sex,course;
private int fee,paid,due;
private String address,contact;
private Date doj;

public StudentBean() {}

public StudentBean(String name, String email, String sex, String course, int fee, int paid, int due, String address,
		String contact, Date doj) {
	super();
	this.name = name;
	this.email = email;
	this.sex = sex;
	this.course = course;
	this.fee = fee;
	this.paid = paid;
	this.due = due;
	this.address = address;
	this.contact = contact;
	this.doj=doj;
}

public StudentBean(int rollno, String name, String email, String sex, String course, int fee, int paid, int due,
		String address, String contact, Date doj) {
	super();
	this.rollno = rollno;
	this.name = name;
	this.email = email;
	this.sex = sex;
	this.course = course;
	this.fee = fee;
	this.paid = paid;
	this.due = due;
	this.address = address;
	this.contact = contact;
	this.doj=doj;
}

public Date getDoj() {
	return doj;
}

public void setDoj(Date doj) {
	this.doj = doj;
}

public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}
public int getPaid() {
	return paid;
}
public void setPaid(int paid) {
	this.paid = paid;
}
public int getDue() {
	return due;
}
public void setDue(int due) {
	this.due = due;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}

}
