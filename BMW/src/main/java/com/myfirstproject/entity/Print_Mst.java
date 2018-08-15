package com.myfirstproject.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name="print_mst")
public class Print_Mst implements Serializable {
private Long pnt_sno;
private Long pnt_no;
private String pnt_prt_no;
private String pnt_prt_bar_cd;
private String pnt_bar_cd;
private String pnt_prt_des;
private String pnt_drwg_rvsn;
private String pnt_vn_cd;
private Date pnt_dt;
private String pnt_day;
private String pnt_day_cd;
private String pnt_loc_cd;
private String pnt_mnth;
private String pnt_mnth_cd;
private String pnt_yr;
private String pnt_yr_cd;
private String pnt_shft;
private String pnt_cmy_cd;
private String pnt_srz_no;
private String pnt_usr_id;
private String pnt_prt_lock;
private String dummydate;

@GeneratedValue
@Id
public Long getPnt_sno() {
	return pnt_sno;
}
public void setPnt_sno(Long pnt_sno) {
	this.pnt_sno = pnt_sno;
}

public String getPnt_prt_no() {
	return pnt_prt_no;
}
public void setPnt_prt_no(String pnt_prt_no) {
	this.pnt_prt_no = pnt_prt_no;
}
public String getPnt_prt_des() {
	return pnt_prt_des;
}
public void setPnt_prt_des(String pnt_prt_des) {
	this.pnt_prt_des = pnt_prt_des;
}
public String getPnt_drwg_rvsn() {
	return pnt_drwg_rvsn;
}
public void setPnt_drwg_rvsn(String pnt_drwg_rvsn) {
	this.pnt_drwg_rvsn = pnt_drwg_rvsn;
}
public String getPnt_vn_cd() {
	return pnt_vn_cd;
}
public void setPnt_vn_cd(String pnt_vn_cd) {
	this.pnt_vn_cd = pnt_vn_cd;
}


public Date getPnt_dt() {
	return pnt_dt;
}
public void setPnt_dt(Date pnt_dt) {
	this.pnt_dt = pnt_dt;
}
public String getPnt_day() {
	return pnt_day;
}
public void setPnt_day(String pnt_day) {
	this.pnt_day = pnt_day;
}
public String getPnt_day_cd() {
	return pnt_day_cd;
}
public void setPnt_day_cd(String pnt_day_cd) {
	this.pnt_day_cd = pnt_day_cd;
}
public String getPnt_mnth() {
	return pnt_mnth;
}
public void setPnt_mnth(String pnt_mnth) {
	this.pnt_mnth = pnt_mnth;
}
public String getPnt_mnth_cd() {
	return pnt_mnth_cd;
}
public void setPnt_mnth_cd(String pnt_mnth_cd) {
	this.pnt_mnth_cd = pnt_mnth_cd;
}
public String getPnt_yr() {
	return pnt_yr;
}
public void setPnt_yr(String pnt_yr) {
	this.pnt_yr = pnt_yr;
}
public String getPnt_yr_cd() {
	return pnt_yr_cd;
}
public void setPnt_yr_cd(String pnt_yr_cd) {
	this.pnt_yr_cd = pnt_yr_cd;
}
public String getPnt_shft() {
	return pnt_shft;
}
public void setPnt_shft(String pnt_shft) {
	this.pnt_shft = pnt_shft;
}
public String getPnt_cmy_cd() {
	return pnt_cmy_cd;
}
public void setPnt_cmy_cd(String pnt_cmy_cd) {
	this.pnt_cmy_cd = pnt_cmy_cd;
}
public String getPnt_srz_no() {
	return pnt_srz_no;
}
public void setPnt_srz_no(String pnt_srz_no) {
	this.pnt_srz_no = pnt_srz_no;
}
public String getPnt_loc_cd() {
	return pnt_loc_cd;
}
public void setPnt_loc_cd(String pnt_loc_cd) {
	this.pnt_loc_cd = pnt_loc_cd;
}
public String getPnt_prt_bar_cd() {
	return pnt_prt_bar_cd;
}
public void setPnt_prt_bar_cd(String pnt_prt_bar_cd) {
	this.pnt_prt_bar_cd = pnt_prt_bar_cd;
}
public String getPnt_bar_cd() {
	return pnt_bar_cd;
}
public void setPnt_bar_cd(String pnt_bar_cd) {
	this.pnt_bar_cd = pnt_bar_cd;
}

public Long getPnt_no() {
	return pnt_no;
}
public void setPnt_no(Long pnt_no) {
	this.pnt_no = pnt_no;
}
public String getPnt_usr_id() {
	return pnt_usr_id;
}
public void setPnt_usr_id(String pnt_usr_id) {
	this.pnt_usr_id = pnt_usr_id;
}
public String getPnt_prt_lock() {
	return pnt_prt_lock;
}
public void setPnt_prt_lock(String pnt_prt_lock) {
	this.pnt_prt_lock = pnt_prt_lock;
}
@Transient
public String getDummydate() {
	return dummydate;
}
public void setDummydate(String dummydate) {
	this.dummydate = dummydate;
}
@Override
public String toString() {
	return "Print_Mst [pnt_sno=" + pnt_sno + ", pnt_no=" + pnt_no + ", pnt_prt_no=" + pnt_prt_no + ", pnt_prt_bar_cd="
			+ pnt_prt_bar_cd + ", pnt_bar_cd=" + pnt_bar_cd + ", pnt_prt_des=" + pnt_prt_des + ", pnt_drwg_rvsn="
			+ pnt_drwg_rvsn + ", pnt_vn_cd=" + pnt_vn_cd + ", pnt_dt=" + pnt_dt + ", pnt_day=" + pnt_day
			+ ", pnt_day_cd=" + pnt_day_cd + ", pnt_loc_cd=" + pnt_loc_cd + ", pnt_mnth=" + pnt_mnth + ", pnt_mnth_cd="
			+ pnt_mnth_cd + ", pnt_yr=" + pnt_yr + ", pnt_yr_cd=" + pnt_yr_cd + ", pnt_shft=" + pnt_shft
			+ ", pnt_cmy_cd=" + pnt_cmy_cd + ", pnt_srz_no=" + pnt_srz_no + ", pnt_usr_id=" + pnt_usr_id
			+ ", pnt_prt_lock=" + pnt_prt_lock + ", dummydate=" + dummydate + "]";
}

}	
