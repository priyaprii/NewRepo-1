package com.myfirstproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AdminDetail extends Employee{
private Long experience;
private String position;

public Long getExperience() {
	return experience;
}
public void setExperience(Long experience) {
	this.experience = experience;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

@Override
public String toString() {
	return "AdminDetail [experience=" + experience + ", position=" + position + "]";
}

}
