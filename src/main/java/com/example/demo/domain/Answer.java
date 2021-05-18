package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  private String text;
  private boolean isCorrrect;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public boolean isCorrrect() {
	return isCorrrect;
}
public void setCorrrect(boolean isCorrrect) {
	this.isCorrrect = isCorrrect;
}
}
