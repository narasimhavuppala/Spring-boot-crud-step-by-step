# Spring-boot-crud-step-by-step
mvn spring-boot:run

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
# Messaging Integration
    - add below Dependency
	    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-activemq</artifactId>
		</dependency>
	-   Create a seperate configuration classes
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

		@Bean
		public Queue queue() {
			return new ActiveMQQueue("testqueue");
		} 	
# Swagger 
	-   Add dependencies in pom.xml
	-	Swagger API depedency & Swagger UI dependency		
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>

		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.9.2</version>
		</dependency>

	-   Add @ Bean for DocketAPI
	-   @Bean
    	public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
   		 }
	-   open url :http://localhost:<<port>>/<<context-path>>/swagger-ui.html
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
		
		- By default all actuator endpoints can be seen :
		      "http://localhost:8080/myapp/actuator"
		- By default Endpoints are disabled due to Secure data
		- enable all endpoints by : management.endpoints.web.exposure.include: "*"
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

