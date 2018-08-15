package com.myfirstproject.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class StudentDetail implements Serializable{
private Long stddtlid;
private String stdyear;
private String stdaddress;
private Student stdforBi;
@ManyToOne
public Student getStdforBi() {
	return stdforBi;
}
public void setStdforBi(Student stdforBi) {
	this.stdforBi = stdforBi;
}
@Id
@GeneratedValue
public Long getStddtlid() {
	return stddtlid;
}
public void setStddtlid(Long stddtlid) {
	this.stddtlid = stddtlid;
}
public String getStdyear() {
	return stdyear;
}
public void setStdyear(String stdyear) {
	this.stdyear = stdyear;
}
public String getStdaddress() {
	return stdaddress;
}
public void setStdaddress(String stdaddress) {
	this.stdaddress = stdaddress;
}
@Override
public String toString() {
	return "StudentDetail [stddtlid=" + stddtlid + ", stdyear=" + stdyear + ", stdaddress=" + stdaddress
			+ ", stdforBi=" + stdforBi + "]";
}

}
