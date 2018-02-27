package com.example.domain.service;

import com.example.domain.model.JavaBasicQuestion;
import com.example.domain.model.Record;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelReader {
    public List<Row> readExcelFile(String sheetName) throws IOException {
        String excelFilePath = "F:\\Łukasz\\JAVA\\MOJE PROJEKTY\\Java Quiz\\Excel Data\\JavaQuizQuestions.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        List<Row> rows = new ArrayList<Row>();
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int counter = 0;
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            int value = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
            counter++;
            if (value == 0) {
                break;
            }
        }
        for (int i = 1; i < counter; i++) {
            Row row = sheet.getRow(i);
            rows.add(row);
        }

        workbook.close();
        inputStream.close();
        return rows;
    }

    public int getExcelRecordsNumber(String sheetName) throws IOException {
        String excelFilePath = "F:\\Łukasz\\JAVA\\MOJE PROJEKTY\\Java Quiz\\Excel Data\\JavaQuizQuestions.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int excelRecordNumber = sheet.getPhysicalNumberOfRows();

        return excelRecordNumber;
    }


    public Row readExcelRow(String sheetName, int rowNumber) throws IOException {
        String excelFilePath = "F:\\Łukasz\\JAVA\\MOJE PROJEKTY\\Java Quiz\\Excel Data\\JavaQuizQuestions.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNumber);
        workbook.close();
        inputStream.close();
        return row;
    }

    public List<Record> createRecords(List<Row> rows) {
        List<Record> records = new ArrayList<Record>();
        for (int i = 0; i < rows.size(); i++) {
            Long id = (long) rows.get(i).getCell(0).getNumericCellValue();
            Cell question = rows.get(i).getCell(1);
            question.setCellType(CellType.STRING);
            Cell correctAswer = rows.get(i).getCell(2);
            correctAswer.setCellType(CellType.STRING);
            Cell firstIncorrectAnswer = rows.get(i).getCell(3);
            firstIncorrectAnswer.setCellType(CellType.STRING);
            Cell secondIncorrectAnswer = rows.get(i).getCell(4);
            secondIncorrectAnswer.setCellType(CellType.STRING);
            Cell thirdIncorrectAnswer = rows.get(i).getCell(5);
            thirdIncorrectAnswer.setCellType(CellType.STRING);
            Record record = new JavaBasicQuestion();

            record.setId(id);
            record.setQuestion(question.getStringCellValue());
            record.setCorrectAnswer(correctAswer.getStringCellValue());
            record.setFirstIncorrectAnswer(firstIncorrectAnswer.getStringCellValue());
            record.setSecondIncorrectAnswer(secondIncorrectAnswer.getStringCellValue());
            record.setThirdIncorrectAnswer(thirdIncorrectAnswer.getStringCellValue());
            records.add(record);
        }
        return records;
    }

    public Record createRecord(Row row) {


        Long id = (long) row.getCell(0).getNumericCellValue();
        Cell question = row.getCell(1);
        question.setCellType(CellType.STRING);
        Cell correctAswer = row.getCell(2);
        correctAswer.setCellType(CellType.STRING);
        Cell firstIncorrectAnswer = row.getCell(3);
        firstIncorrectAnswer.setCellType(CellType.STRING);
        Cell secondIncorrectAnswer = row.getCell(4);
        secondIncorrectAnswer.setCellType(CellType.STRING);
        Cell thirdIncorrectAnswer = row.getCell(5);
        thirdIncorrectAnswer.setCellType(CellType.STRING);
        Record record = new JavaBasicQuestion();

        record.setId(id);
        record.setQuestion(question.getStringCellValue());
        record.setCorrectAnswer(correctAswer.getStringCellValue());
        record.setFirstIncorrectAnswer(firstIncorrectAnswer.getStringCellValue());
        record.setSecondIncorrectAnswer(secondIncorrectAnswer.getStringCellValue());
        record.setThirdIncorrectAnswer(thirdIncorrectAnswer.getStringCellValue());


        return record;
    }

}
