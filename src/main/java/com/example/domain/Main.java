package com.example.domain;

import com.example.domain.config.HibernateConfig;
import com.example.domain.service.RecordService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

class Main {

    public static void main(String[] args) throws IOException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateConfig.class);
        RecordService service = applicationContext.getBean(RecordService.class);
        service.fillUpDatabase();
    }
}