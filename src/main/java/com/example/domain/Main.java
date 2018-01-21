package com.example.domain;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.domain.config.AppConfig;
import com.example.domain.config.HibernateConfig;
import com.example.domain.dao.RecordDAOImpl;
import com.example.domain.model.Record;
import com.example.domain.model.SheetNames;
import com.example.domain.service.ExcelReader;
import com.example.domain.service.RecordService;

public class Main {

	public static void main(String[] args) throws IOException {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		ExcelReader excelReader = new ExcelReader();

		List<Row> rows = excelReader.readExcelFile(SheetNames.JAVA_BASIC_QUESTIONS_PL.getValue());

		List<Record> records = excelReader.createRecords(rows);
		// for (Record recor : records) {
		// System.out.println(recor);
		// }

		RecordService service = applicationContext.getBean(RecordService.class);
		service.fillUpDatabase(records);
	}

}
