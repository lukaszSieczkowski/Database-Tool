package com.example.domain.dao;

import com.example.domain.model.JavaBasicQuestion;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.model.Record;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RecordDAOImpl implements RecordDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void save(Record record) {
        sessionFactory.getCurrentSession().persist(record);
    }

    public List getRecords() {
        Query query = sessionFactory.getCurrentSession().createQuery("from JavaBasicQuestion");
        List<Record> recordList = query.getResultList();
        return recordList;
    }

    public Record getRecord(long id) {
        Record record = sessionFactory.getCurrentSession().get(JavaBasicQuestion.class, id);
        return record;
    }

    public void update(Record record) {
        sessionFactory.getCurrentSession().update(record);
    }
}
