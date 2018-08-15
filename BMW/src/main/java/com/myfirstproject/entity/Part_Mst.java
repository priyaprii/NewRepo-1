package com.myfirstproject.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "part_mst")
public class Part_Mst implements Serializable {
	private Long part_sno;
	private String part_no;
	private String part_desc;
	private String part_revson;
	private String part_vndr_cd;
	private String part_bar_cd;
	private boolean part_lock;
	private boolean part_sts;
	private Date part_dt;
	@GeneratedValue
	@Id
	public Long getPart_sno() {
		return part_sno;
	}
	public void setPart_sno(Long part_sno) {
		this.part_sno = part_sno;
	}
	public String getPart_no() {
		return part_no;
	}
	public void setPart_no(String part_no) {
		this.part_no = part_no;
	}
	public String getPart_desc() {
		return part_desc;
	}
	public void setPart_desc(String part_desc) {
		this.part_desc = part_desc;
	}
	public String getPart_revson() {
		return part_revson;
	}
	public void setPart_revson(String part_revson) {
		this.part_revson = part_revson;
	}
	public String getPart_vndr_cd() {
		return part_vndr_cd;
	}
	public void setPart_vndr_cd(String part_vndr_cd) {
		this.part_vndr_cd = part_vndr_cd;
	}
	public String getPart_bar_cd() {
		return part_bar_cd;
	}
	public void setPart_bar_cd(String part_bar_cd) {
		this.part_bar_cd = part_bar_cd;
	}
	
	public boolean isPart_lock() {
		return part_lock;
	}
	public void setPart_lock(boolean part_lock) {
		this.part_lock = part_lock;
	}
	public boolean isPart_sts() {
		return part_sts;
	}
	public void setPart_sts(boolean part_sts) {
		this.part_sts = part_sts;
	}
	public Date getPart_dt() {
		return part_dt;
	}
	public void setPart_dt(Date part_dt) {
		this.part_dt = part_dt;
	}
	@Override
	public String toString() {
		return "Part_Mst [part_sno=" + part_sno + ", part_no=" + part_no + ", part_desc=" + part_desc
				+ ", part_revson=" + part_revson + ", part_vndr_cd=" + part_vndr_cd + ", part_bar_cd=" + part_bar_cd
				+ ", part_lock=" + part_lock + ", part_sts=" + part_sts + ", part_dt=" + part_dt + "]";
	}

}
