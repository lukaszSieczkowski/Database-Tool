package com.example.domain.service;

import com.example.domain.dao.RecordDAO;
import com.example.domain.model.Record;
import com.example.domain.model.SheetNames;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RecordService {
    @Autowired
    ExcelReader excelReader;
    @Autowired
    RecordDAO recordDAO;

    public void fillUpDatabase() throws IOException {
        int excelRecordsNumber = excelReader.getExcelRecordsNumber(SheetNames.JAVA_BASIC_QUESTIONS_PL.getValue());
        System.out.println(excelRecordsNumber);
        for (int i = 1; i < excelRecordsNumber; i++) {
            Row row = excelReader.readExcelRow(SheetNames.JAVA_BASIC_QUESTIONS_PL.getValue(), i);
            Record record = excelReader.createRecord(row);

            try {
                recordDAO.save(record);
                System.out.println("Saving record: " + record.toString());

            } catch (DataIntegrityViolationException e) {
                recordDAO.update(record);
                System.out.println("Updating record: " + record.toString());
            }

        }
    }

}




