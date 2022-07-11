package com.university.crud.springbootcrudrest.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.university.crud.springbootcrudrest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class StudentJmsSender {
	@Autowired
	JmsTemplate jmsTemplate;

	public void pushStudentSave(Student obj) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String studentObjJson = mapper.writeValueAsString(obj);
			this.jmsTemplate.convertAndSend("testQueue", studentObjJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

	public void pushStringMessage(String message) {
		this.jmsTemplate.convertAndSend("testQueue", message);

	}

}
