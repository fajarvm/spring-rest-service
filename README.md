# RESTful Web Service

This is a simple demo of a RESTful web service with Spring Boot, Java Persistence API (JPA) and Hibernate.

### Requirements ###
Software required to run, install and test this project:
* Java 1.8
* MySQL version 5 (or above)
* (Optional) [Postman]([https://www.getpostman.com/]) version 7.0 (or above)

### Configuration ###
Modify the properties in the configuration file according to your environment.
Configuration file: `src/main/resources/application.properties`
```bash
spring.datasource.username=root <--- Change these to your MySQL username and password
spring.datasource.password=root
```

### Running the server ###
To install, execute this command on the repository root directory:
```bash
mvn clean install
```
Note: make sure your MySQL instance is running.
And then, to run the server:
```bash
mvn spring-boot:run
```
Upon start-up, the server creates a database called `localhost_db`, a table `products` and inserts some test entries into the table.

### Testing the API ###
The Swagger UI REST API docs is included into this project and can be accessed via http://localhost:8080/api/ (it should redirect user to the [Swagger UI API Docs](http://localhost:8080/api/swagger-ui.html) page)

Available endpoints are:

Endpoint | Method | Description
--- | --- | ---
 /products/ | GET | List all products.
 /products/ | POST | Add a product to the list. Requires a JSON body message.*
 /products/{id} | GET | Get a product with the given ID.
 /products/{id} | PUT | Update a product with the given ID. Requires a JSON body message.*

*Example of JSON body message: 
```json 
{ 
    "name": "Keyboard", 
    "currentPrice": 25.50
}
```
The message can also have only one of the properties.

### Postman collection ###
The REST API can also be tested using Postman. Start the Postman application and import the collection file provided here: `tools/postman_collection.json`. 
The collection named 'RESTful Web Service' will be visible to the left and the available endpoints are listed underneath. 
