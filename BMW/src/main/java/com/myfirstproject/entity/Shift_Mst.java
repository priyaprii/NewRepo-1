package com.myfirstproject.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name="shift_mst")
public class Shift_Mst implements Serializable{
private Long 	shift_sno;
private String  shift_nm;
private boolean Shift_sts;
@Id
@GeneratedValue
public Long getShift_sno() {
	return shift_sno;
}
public void setShift_sno(Long shift_sno) {
	this.shift_sno = shift_sno;
}

public String getShift_nm() {
	return shift_nm;
}
public void setShift_nm(String shift_nm) {
	this.shift_nm = shift_nm;
}
public boolean isShift_sts() {
	return Shift_sts;
}
public void setShift_sts(boolean shift_sts) {
	Shift_sts = shift_sts;
}
@Override
public String toString() {
	return "Shift_Mst [shift_sno=" + shift_sno + ", shift_nm=" + shift_nm + ", Shift_sts=" + Shift_sts + "]";
}

}
