package com.example.domain.model;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

import lombok.Data;

@Data
@Entity
public abstract class Record {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  
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
