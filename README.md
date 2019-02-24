# Spring-boot-crud-step-by-step
mvn spring-boot:run

# Rest Endpoints
- Add below Depndency
	
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
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
# Messaging Integration with ActiveMQ
- add below Dependency
	    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-activemq</artifactId>
		</dependency>
- Create a seperate configuration classes


		@Bean
		ActiveMQConnectionFactory getActiveMQ() {
			ActiveMQConnectionFactory obj = new ActiveMQConnectionFactory("username", "password", "");
			obj.setBrokerURL(brokerUrl);
			return obj;
		}

		@Bean
		JmsTemplate getJmsTemplate() {
			return new JmsTemplate(getActiveMQ());
		}
#  ORM Integration(hibenrate to Mysql/Oracle/Postgree/MS SQL/H2)
- Add below Dependency

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
- Create a model with below Annotations
	- @Entity
	- @Id
- Create a Repository
	
		@Repository
		public interface StudentRepository extends JpaRepository<Student, Integer> {
		//Code Generation Technique: DSL 
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
-   
		@Bean
    	public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
   		 }
-	open url :http://localhost:port/context-path/swagger-ui.html


# Datasource creation
- @ Bean for Programatic Data Source
- Embedded will be created if you add depedency
	
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
- Connection Pooling
- use for Hikari:  spring.datasource.type=com.zaxxer.hikari.HikariDataSource
- use the below config for Datasource

		spring:
		  datasource:
			url: jdbc:mysql://localhost:3306/mysql
			username: root
			password: root
			driver-class-name: com.mysql.cj.jdbc.Driver


#  Log level Details
- debug=false
- logging.file=application.log
- logging.level.org.springframework=INFO
- logging.level.org.org.hibernate=WARN


#   Actuator Endpoints
- Add below Dependency in the pom.xml
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>		
- By default all actuator endpoints can be seen :
		      "http://serveropaddress:port/context-path/actuator"
- By default Endpoints are disabled due to Secure data
- enable all endpoints by : management.endpoints.web.exposure.include: "*"
- Shutdown endpoint needs to be enabled. This will not be covered in all(*)



# Spring Annotations
- @Component
- @RestController
- @RequestMapping
- @Service
- @Repository
- @SpringBootApplication
- @Bean
- @Autowired
- @Query
- @Transactional
# Dev tools
- HMR(Hot Module Replacement)
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>
- Ensures Restart of Project upon save
- It does not detect the pom.xml changes
# YAML Usage
- Spring profiles active
- Server port
- Conext path : Different Application name
- usage of tab

# Reading Properties Files inside the program
- for Multiple Properties

		@Autowired
		Environment env; 
- for single property
			
		@Value("property.name)

# Bean Validation
- use @ Valid wherever it needs to be validated
- @NotNull
- @Email
- @Min
- @Max
- @Size
- @Past/@Future
- @Negative/@Positive
# Oracle Database conncecivtiy

- download JAR freom below:

	https://www.oracle.com/technetwork/apps-tech/jdbc-112010-090769.html

- Install to local repo:
	
	mvn install:install-file -Dfile=ojdbc6.jar  -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=12.1.0.1 -Dpackaging=jar
- Add pom dependency
		
		<dependency>
            <groupId>com.oracle</groupId>
            <artifactId>ojdbc6</artifactId>
            <version>12.1.0.1</version>
        </dependency>
- create a user and give privilages

		CREATE USER crud IDENTIFIED BY crud;

		GRANT CONNECT TO crud;

		GRANT CONNECT, RESOURCE, DBA TO crud;

		GRANT CREATE SESSION TO crud;


		GRANT UNLIMITED TABLESPACE TO crud;


- CREATE SEQUENCE student_seq
  MINVALUE 1
  MAXVALUE 9999999999
  START WITH 4
  INCREMENT BY 1;


