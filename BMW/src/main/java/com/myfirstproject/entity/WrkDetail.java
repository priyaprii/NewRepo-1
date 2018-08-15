
package com.myfirstproject.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class WrkDetail extends Employee{
private Long wrktime;
private String salary;

public Long getWrktime() {
	return wrktime;
}

public void setWrktime(Long wrktime) {
	this.wrktime = wrktime;
}

public String getSalary() {
	return salary;
}

public void setSalary(String salary) {
	this.salary = salary;
}

@Override
public String toString() {
	return "EmpDetail [wrktime=" + wrktime + ", salary=" + salary + "]";
}

}
