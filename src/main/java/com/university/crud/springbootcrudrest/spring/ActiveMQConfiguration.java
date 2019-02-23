package com.university.crud.springbootcrudrest.spring;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMQConfiguration {

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Bean
	ActiveMQConnectionFactory getActiveMQ() {
		ActiveMQConnectionFactory obj = new ActiveMQConnectionFactory("guest", "guest", "");
		obj.setBrokerURL(brokerUrl);
		return obj;

	}

	@Bean
	JmsTemplate getJmsTemplate() {
		return new JmsTemplate(getActiveMQ());
	}

}
