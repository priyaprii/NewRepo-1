package com.myfirstproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="month_mst")
public class Month_Mst {
private Long month_sno;
private String month_nm;
private String month_cd;
private boolean month_sts;
@GeneratedValue
@Id
public Long getMonth_sno() {
	return month_sno;
}
public void setMonth_sno(Long month_sno) {
	this.month_sno = month_sno;
}
public String getMonth_nm() {
	return month_nm;
}
public void setMonth_nm(String month_nm) {
	this.month_nm = month_nm;
}
public String getMonth_cd() {
	return month_cd;
}
public void setMonth_cd(String month_cd) {
	this.month_cd = month_cd;
}
public boolean isMonth_sts() {
	return month_sts;
}
public void setMonth_sts(boolean month_sts) {
	this.month_sts = month_sts;
}
@Override
public String toString() {
	return "Month_Mst [month_sno=" + month_sno + ", month_nm=" + month_nm + ", month_cd=" + month_cd + ", month_sts="
			+ month_sts + "]";
}
}
