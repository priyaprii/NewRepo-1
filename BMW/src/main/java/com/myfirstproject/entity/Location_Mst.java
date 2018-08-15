package com.myfirstproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loc_mst")
public class Location_Mst {
private Long loc_sno;
private String loc_nm;
private String loc_cd;
private boolean loc_sts;
@GeneratedValue
@Id
public Long getLoc_sno() {
	return loc_sno;
}
public void setLoc_sno(Long loc_sno) {
	this.loc_sno = loc_sno;
}
public String getLoc_nm() {
	return loc_nm;
}
public void setLoc_nm(String loc_nm) {
	this.loc_nm = loc_nm;
}
public String getLoc_cd() {
	return loc_cd;
}
public void setLoc_cd(String loc_cd) {
	this.loc_cd = loc_cd;
}
public boolean isLoc_sts() {
	return loc_sts;
}
public void setLoc_sts(boolean loc_sts) {
	this.loc_sts = loc_sts;
}
@Override
public String toString() {
	return "Location_Mst [loc_sno=" + loc_sno + ", loc_nm=" + loc_nm + ", loc_cd=" + loc_cd + ", loc_sts=" + loc_sts
			+ "]";
}
}
