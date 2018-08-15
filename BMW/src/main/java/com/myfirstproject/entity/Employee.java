package com.myfirstproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Employee {
private Long empid;
private String empname;

@Id
@GeneratedValue

public Long getEmpid() {
	return empid;
}
public void setEmpid(Long empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", empname=" + empname + "]";
}

}
