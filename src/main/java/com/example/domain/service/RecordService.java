package com.example.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.dao.RecordDAO;
import com.example.domain.model.Record;

@Service
public class RecordService {
	@Autowired
	ExcelReader excelReader;
	@Autowired
	RecordDAO recordDAO;
	
	public void fillUpDatabase(List<Record> records) {
		for(Record record: records) {
		System.out.println(record.toString());
			recordDAO.save(record);
		}
	}

}
