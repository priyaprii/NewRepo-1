package com.myfirstproject.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="year_mst")
public class Year_Mst implements Serializable{
	private Long year_sno;
	private Long year;
	private int year_cd;
	private boolean year_sts;
	@GeneratedValue
	@Id
	public Long getYear_sno() {
		return year_sno;
	}
	public void setYear_sno(Long year_sno) {
		this.year_sno = year_sno;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public int getYear_cd() {
		return year_cd;
	}
	public void setYear_cd(int year_cd) {
		this.year_cd = year_cd;
	}
	public boolean isYear_sts() {
		return year_sts;
	}
	public void setYear_sts(boolean year_sts) {
		this.year_sts = year_sts;
	}
	@Override
	public String toString() {
		return "Year_Mst [year_sno=" + year_sno + ", year=" + year + ", year_cd=" + year_cd + ", year_sts=" + year_sts
				+ "]";
	}
}
