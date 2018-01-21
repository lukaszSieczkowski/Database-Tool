package com.example.domain.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	protected Long id;
	@Column(name = "question")
	protected String question;
	@Column(name = "correct_answer")
	protected String correctAnswer;
	@Column(name = "first_incorrect_answer")
	protected String firstIncorrectAnswer;
	@Column(name = "second_incorrect_answer")
	protected String secondIncorrectAnswer;
	@Column(name = "third_incorrect_answer")
	protected String thirdIncorrectAnswer;
}
