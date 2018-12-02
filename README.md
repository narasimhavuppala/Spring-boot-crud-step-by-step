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
	- Add @ Bean for DocketAPI
	- open url :http://localhost:<<port>>/<<context-path>>/swagger-ui.html
# Datasource creation
	 - @ Bean for Data Source
	 - Embedded
#  Log level Details
	 - debug=false
	 - logging.file=application.log
	 - logging.level.org.springframework=INFO
	 - logging.level.org.org.hibernate=WARN
#   Actuator Endpoints
		
		- "http://localhost:8080/myapp/actuator"
		- "http://localhost:8080/myapp/actuator/health"
		- "http://localhost:8080/myapp/actuator/info"
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
  			