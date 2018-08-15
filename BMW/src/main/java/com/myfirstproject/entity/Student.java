package com.myfirstproject.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Student implements Serializable{
	private Long sid;
	private String name;
	private String college;
	private List<StudentDetail> sudentid;
	@Id
	@GeneratedValue
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	@OneToMany(targetEntity=StudentDetail.class,cascade=CascadeType.ALL,mappedBy="stdforBi")
	public List<StudentDetail> getSudentid() {
		return sudentid;
	}
	public void setSudentid(List<StudentDetail> sudentid) {
		this.sudentid = sudentid;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", college=" + college + ", sudentid=" + sudentid + "]";
	}

}
