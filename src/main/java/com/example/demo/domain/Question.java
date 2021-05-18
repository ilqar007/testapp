package com.example.demo.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.domain.enums.DifficultiyDegree;
import com.example.demo.domain.enums.QuestionStatus;


@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String text;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Answer.class)
	private Set<Answer> answers;
	private DifficultiyDegree difficultiyDegree;
	private QuestionStatus status;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	public DifficultiyDegree getDifficultiyDegree() {
		return difficultiyDegree;
	}
	public void setDifficultiyDegree(DifficultiyDegree difficultiyDegree) {
		this.difficultiyDegree = difficultiyDegree;
	}
	public QuestionStatus getStatus() {
		return status;
	}
	public void setStatus(QuestionStatus status) {
		this.status = status;
	}
}
