# REST-API-SpringBoot

This project provides a REST API for a medical clinic. The clinic has patients,providers and treatments as the main entities. Since it was built with SOA in mind, the code is easily extendable with new types of treatments, visits and more detail if needed.

### Prerequisites

```
Maven 3.x
Java JDK 11.x
```

### How To Run
This application is packaged as a jar which has Tomcat 8 embedded, the service uses H2 in-memory database. No Tomcat or Database installation is necessary.

* Clone this repository 
* Make sure you are using JDK 11.08 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean install```
* Once successfully built, you can run the service by the following command:
```
        java -jar clinic-web/target/clinic-web-0.0.1-SNAPSHOT.jar
```
* Once the application runs you should see something like this:
```
2020-06-12 15:14:43.806  INFO 15660 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-06-12 15:14:43.851  INFO 15660 --- [  restartedMain] clinic.ClinicApplication                 : Started ClinicApplication in 3.576 seconds (JVM running for 4.418)
```
*Note: 

## Built With

* Spring Boot 2
* Spring Framework 5
* Spring Data JPA (Hibernate)
* Spring Web
* H2 Database 
  ** NOTE: the POM.xml for clinic-data already contains MySQL,MongoDB plugins. To use them just set appropriate application properties.

## Future Work
Add Spring HATEOAS to make the service more Restful
