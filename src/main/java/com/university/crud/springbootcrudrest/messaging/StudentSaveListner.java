package com.university.crud.springbootcrudrest.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class StudentSaveListner {

	@JmsListener(destination = "testQueue")
	public void consume(String message) {
		System.out.println("Received Message: " + message);
	}

}
