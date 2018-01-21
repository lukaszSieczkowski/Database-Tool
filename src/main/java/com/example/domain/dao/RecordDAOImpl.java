package com.example.domain.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.secure.spi.JaccIntegrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.JavaBasicQuestion;
import com.example.domain.model.Record;

@Repository
@Transactional
public class RecordDAOImpl implements RecordDAO{
	@Autowired
	SessionFactory sessionFactory;

	public void save(Record record) {
		sessionFactory.getCurrentSession().persist(record);
		
	}

	public void update(Record record) {
		sessionFactory.getCurrentSession().update(record);
		
	}
}
