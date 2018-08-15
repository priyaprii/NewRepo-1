package com.myfirstproject.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name="day_mst")
public class Day_Mst implements Serializable {
private Long day_sno;
private String day_cd;
private boolean day_sts;
@GeneratedValue
@Id
public Long getDay_sno() {
	return day_sno;
}
public void setDay_sno(Long day_sno) {
	this.day_sno = day_sno;
}
public String getDay_cd() {
	return day_cd;
}
public void setDay_cd(String day_cd) {
	this.day_cd = day_cd;
}

public boolean isDay_sts() {
	return day_sts;
}
public void setDay_sts(boolean day_sts) {
	this.day_sts = day_sts;
}
@Override
public String toString() {
	return "Day_Mst [day_sno=" + day_sno + ", day_cd=" + day_cd + ", day_sts=" + day_sts + "]";
}
}
