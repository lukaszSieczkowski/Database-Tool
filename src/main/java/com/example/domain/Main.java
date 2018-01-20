package com.example.domain;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
	    ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.domain.config");

	}

}
