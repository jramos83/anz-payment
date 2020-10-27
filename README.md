# Payment Platform
Coding challenge that retrieves accounts and transactions

## Design Decisions
- Storage is a relational in memory database - h2
- Persistence layer is Spring Data JPA
- The application is built as a Restful API using Spring Boot (Spring MVC)
- Architecture is divided into 3 layers: controllers, services and repositories
- The APIs are documented through Swagger UI which can be accessed via the URL http://localhost:8080/swagger-ui.html
- API testing is done using Rest Assured, Unit testing is done using JUnit

### Assumptions
- The Opening Available Balance for an account is the balance at the beginning of the day
- Authentication and authorization is out of scope

### Prerequisites
- Java 11

### Running
The application can be run by executing the Spring Boot Jar