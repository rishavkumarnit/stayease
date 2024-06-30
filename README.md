# STAYEASE



## Introduction

This is a RESTful API service using Spring Boot to streamline the room booking process for a hotel management aggregator application. It uses MySQL, Spring Security and JWT authentication.



## Features

- CRUD operations in RDBMS table
- Hotel management
- Person management
- Booking management
- Authentication and Authorization
- Basic testing through Mockito and MVC


## Installation



### 1. Add repository
```
git clone [repository]
```


### 2. Add dependencies
```
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.security:spring-security-config'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.session:spring-session-core'
	implementation 'com.fasterxml.jackson.core:jackson-databind'
	implementation 'io.jsonwebtoken:jjwt-api:0.11.5'
	runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.11.5'
	runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.11.5'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'com.mysql:mysql-connector-j'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
```

### 3. Configuration 
```
spring.application.name=stayease
spring.datasource.url=jdbc:mysql://localhost:3306/stayease
spring.datasource.username=<userid>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=update
```


### 4. Run softwares
```
- Java 21
- MySQL
- Gradle
``` 


### 5. Execute
```
./gradlew test
./gradlew build
./gradlew bootrun
```


**The server will start and be accessible at http://localhost:8080**


To know more Navigate : [Postman API Documentation](https://www.postman.com/technical-cosmonaut-13105159/workspace/my-workspace/collection/36174974-4b6f09d9-0d43-40f8-97e8-2615f5435328?action=share&creator=36174974)
___
