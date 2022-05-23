# Getting Started

### Summary of design

- for each endpoint, added a related object and repository
- used JPA to access Postgress database, spring properties are provided for connection details
- added small test case for object (integration)
- added small cache for generaly available (applied only on one repository, can be extended)
- added api doc ui accessible from http://localhost:9091/api-docs-ui.html, can be tested
- for search operation; used raw query to select all the mappings of professor-course, then a converter used to create response.

### Proposed next steps/improvements

- an authentication mechanism required, for example token based
- cache to be improved and applied to all endpoints, so db access reduced to minimum
- cache must have an expiration criteria
- instead of local cache, a more widely used one can be useful, such as redis 
- DB models objects and response objects must be separated
- must be added full lifecycle unit tests and integration tests
- DB relations must be reorganized, personally I would not pick JPA, instead raw DB models and access.
- for each request an security and validation must be implemented, for example request data validation.
- for multiple access to same course a limit must be defined like how many students can get etc..


### application properties 

- used postgres 14 on mac and intellj for development
- created project raw from spring inintialzr and used the following dependencies
  - org.postgresql
  - lombok
  - org.springdoc.springdoc-openapi-ui
  - spring-boot-starter-data-jpa
  - spring-boot-starter-web
  - spring-boot-starter-test

_spring.jpa.hibernate.show-sql=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=admin
server.port=9091
local.server.port=9091
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/api-docs-ui.html

### Build & Run
- mvn clean
- mvn clean install
- Starting Point of the applicatioin is com.example.assigment.AssigmentApplication#main
- for existing postman test please see:src/main/resources/test.postman_collection.json