package com.example.domain.dao;

import com.example.domain.model.Record;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RecordDAO {
    void update(Record record);

    void save(Record record);

    List getRecords();

    Record getRecord(long id);
}
