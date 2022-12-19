# WW Challenge
This is a challenge I did. The task was to create an application that provides a RESTful API using Spring, Hibernate and MySQL. The data model was given as a UML diagram. The endpoints were defined in the task as well. It was emphasized that performance was of outmost importance.

## Setup
1. Install Java 17 as well as MySql 8
1. Import the DB (contains the schema + some test data):
    ```
    CREATE DATABASE IF NOT EXISTS wwChallenge;
    mysql -u root -p wwChallenge < setup/db_dump.sql
    ```
1. Create the event from part 3 of the task
    ```
    mysql -u root -p wwChallenge < setup/create_part_3_event.sql
    ```
1. Create a DB user (Note: No, I don't normally put passwords Git repos)
    ```
    CREATE USER 'wwUser'@'localhost' IDENTIFIED BY '2[Qmi%kD7t{I6XxAXzfcp]8TKHbh';
    GRANT SELECT ON wwChallenge.* TO 'wwUser'@'localhost';
    flush privileges;
    ```

1. Run the application from your IDE or with Maven
    ```
    ./mvnw spring-boot:run
    ```

## Routes
The following REST routes are available via GET requests:

 **/persons/{personId}/house**: returns housing information about a person

 **/children/{childId}/info**: returns the parent and the favorite meal of a child

 **/children/2/color**: returns the hair color if the child is a girl or the bicycle color if the child is a boy

 **/persons/children**: returns a summary of how many people have how many children

## Design Considerations

### Reactive Application
I considered writing a reactive application because performance was a high priority in this challenge and reactive applications have the potential to be more performant. Spring provides Spring Webflux which integrates with Project Reactor. Hibernate fairly recently (end of 2021) released Hibernate Reactive which enables reactive database access. However, Spring Webflux does not integrate with Hibernate Reactive. The two can be used together but it seems to be rather complicated. All in all, this is not a stack I would use in an enterprise setting. This is why I decided to go for the standard Spring Web and Hibernate ORM.

### Cache
Both Spring and Hibernate offer a cache feature. Spring can cache results of the service layer which is useful when the application does heavy computation. However, this is not the case here. I decided to make use of Hibernate's second level and query result caches instead.

### Stateless Services
The services of the app are stateless. This theoretically enables multiple instances of the app to run at once behind a load balancer. However, the caching mechanism settings would need to be adjusted accordingly.

### Inheritance Mapping
Son and daughter are subclasses of Child. I decided to use the (default) Single Table strategy for mapping them because they have only one extra field each. This strategy does not require accessing multiple tables when reading data, which is a performance benefit.

## Architecture
I implemented a pretty standard web service architecture. The database is the storage layer. On top of that, there is a data access layer in the form of Spring Data repositories. The services form the business logic layer. Their methods are exposed via the RESTful API by a layer of controllers.

## What would I have done differently?
It is clear that the given task was crafted to include a variety of different aspects that are relevant in a real-world scenario, like different relation types. It is not meant to resemble a useful application. Because of that, some aspects are not implemented in the way I'd normally do it and I would like to point them out:
- Children can have more than one parent
- House could probably be a weak entity and contained in the Person table
- If available, I would save the date of birth instead of the age