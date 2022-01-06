FROM openjdk:8-alpine
RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app

COPY target/spring-boot-crud-rest-0.0.1-SNAPSHOT.jar $PROJECT_HOME/spring-boot-crud-rest-0.0.1-SNAPSHOT.jar

WORKDIR $PROJECT_HOME

CMD ["java" ,"-jar","./spring-boot-crud-rest-0.0.1-SNAPSHOT.jar"]


## docker build -t narasimhavuppala/spring-boot-mongo .