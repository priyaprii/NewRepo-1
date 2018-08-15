package com.myfirstproject.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="cmy_mst")
public class Cmy_Mst implements Serializable{
	private Long cmy_sno;
	private String cmy_cd;
	private String cmy_nm;
	private boolean cmy_sts;
	@GeneratedValue
	@Id
	public Long getCmy_sno() {
		return cmy_sno;
	}
	public void setCmy_sno(Long cmy_sno) {
		this.cmy_sno = cmy_sno;
	}
	public String getCmy_cd() {
		return cmy_cd;
	}
	public void setCmy_cd(String cmy_cd) {
		this.cmy_cd = cmy_cd;
	}
	public String getCmy_nm() {
		return cmy_nm;
	}
	public void setCmy_nm(String cmy_nm) {
		this.cmy_nm = cmy_nm;
	}
	public boolean isCmy_sts() {
		return cmy_sts;
	}
	public void setCmy_sts(boolean cmy_sts) {
		this.cmy_sts = cmy_sts;
	}
	@Override
	public String toString() {
		return "Cmy_Mst [cmy_sno=" + cmy_sno + ", cmy_cd=" + cmy_cd + ", cmy_nm=" + cmy_nm + ", cmy_sts=" + cmy_sts
				+ "]";
	}
}
