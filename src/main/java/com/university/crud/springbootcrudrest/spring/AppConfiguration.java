package com.university.crud.springbootcrudrest.spring;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class AppConfiguration {

	@Bean
	public DataSource getDatasource() {
		// DataSourceBuilder.create().build();
		// DataSourceBuilder.create().driverClassName("").username("").password("").url("").build();
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.H2);
		
		EmbeddedDatabase db = builder.build();

		return db;

	}

}
