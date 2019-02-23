package com.university.crud.springbootcrudrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.university.crud.springbootcrudrest.model.Student;

@Component
public class StudentJmsSender {
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void pushStudentSave(Student obj) {
		ObjectMapper mapper=new ObjectMapper();
		try {
			String studentObjJson=mapper.writeValueAsString(obj);
			this.jmsTemplate.convertAndSend("testQueue", studentObjJson);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
