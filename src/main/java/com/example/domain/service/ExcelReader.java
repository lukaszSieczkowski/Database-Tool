package com.example.domain.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.example.domain.model.JavaBasicQuestion;
import com.example.domain.model.Record;

@Service
public class ExcelReader {
	public List<Row> readExcelFile(String sheetName) throws IOException {
		String excelFilePath = "D:\\£ukasz\\JAVA\\MOJE PROJEKTY\\Java Quiz\\Excel Data\\JavaQuizQuestions.xlsx";
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

	public List<Record> createRecords(List<Row> rows) {
		List<Record> records = new ArrayList<Record>();
		for (int i = 0; i < rows.size(); i++) {
			Long id = (long) rows.get(i).getCell(0).getNumericCellValue();
			String question = rows.get(i).getCell(1).getStringCellValue();
			String correctAswer = rows.get(i).getCell(2).getStringCellValue();
			String firstIncorrectAnswer = rows.get(i).getCell(3).getStringCellValue();
			String secondIncorrectAnswer = rows.get(i).getCell(4).getStringCellValue();
			String thirdIncorrectAnswer = rows.get(i).getCell(5).getStringCellValue();
			Record record = new JavaBasicQuestion();

			//record.setId(id);
			record.setQuestion(question);
			record.setCorrectAnswer(correctAswer);
			record.setFirstIncorrectAnswer(firstIncorrectAnswer);
			record.setSecondIncorrectAnswer(secondIncorrectAnswer);
			record.setThirdIncorrectAnswer(thirdIncorrectAnswer);
			records.add(record);
		}
		return records;
	}

}
