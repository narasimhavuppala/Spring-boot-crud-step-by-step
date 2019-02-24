# Spring-boot-crud-step-by-step
mvn spring-boot:run
# features

# Rest Endpoints 
    - HTTP Methods
	   - GET
	   		- Pathparam
	   		- RequestParam
	   - PUT
	   - POST
	   - DELETE
	 - HTTP Status codes
	 - Mediatypes
	 	- Produces
	 	- Consumes
	 	
# Swagger 
	- Add dependencies in pom.xml
	- Swagger API depedency
	- Swagger UI dependency
	- Add @ Bean for DocketAPI
	- open url :http://localhost:<<port>>/<<context-path>>/swagger-ui.html
# Datasource creation
	 - @ Bean for Data Source
	 - Embedded
	 - Connection Pooling
	 	- use for Hikari:  spring.datasource.type=com.zaxxer.hikari.HikariDataSource
#  Log level Details
	 - debug=false
	 - logging.file=application.log
	 - logging.level.org.springframework=INFO
	 - logging.level.org.org.hibernate=WARN
#   Actuator Endpoints
		
		- "http://localhost:8080/myapp/actuator"
		- By default Endpoints are disabled due to Secure data
		- management.endpoints.web.exposure.include: "*"
		- Shutdown endpoint needs to be enabled. This will not be covered in all(*)
# Spring Annotations
		- @Component
		- @RestController
		- @Controller(Deprecated)
		- @Service
		- @Repository
		- @SpringBootApplication
		- @Bean
		- @Autowired
		- @Query
		- @Transactional
# Dev tools
  			
	- HMR(Hot Module Replacement)
	- Ensures Restart of Project upon save
	- It does not detect the pom.xml changes
# YAML Usage
    - Spring profiles active
    - Server port
    - Conext path : Different Application name
    - usage of tab

# Reading Properties Files inside the progra
	- Environment env; //for Multiple Properties
	- @Value("property.name) for single property

# Bean Validation
    - use @ Valid wherever it needs to be validated
    - @NotNull
    - @Email
	- @Min
	- @Max
	- @Size
	- @Past/@Future
	- @Negative/@Positive
    - usage of tab
