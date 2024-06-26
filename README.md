# web-quiz
Collaborative web tool for making and solving quizzes, for learning backend development and modern tech integration effectively.

### track - Java Backend Developer (Spring Boot) 396 topics  
**_Web Quiz Engine with Java_**  
 Challenging
~ 54 hours  

**Provided by**  
_JetBrains Academy_  

Bartłomiej Błaszczyk

## About  
In the Internet, you can often find sites where you need to answer some questions. It can be educational sites, sites with psychological tests, job search services, or just entertaining sites like web quests. The common thing for them is the ability to answer questions (or quizzes) and then see some results. In this project, you will create a complex web service and learn about REST API, an embedded database, security, and other technologies. If you would like to continue the project, you could develop a web or mobile client for this web service on your own. 

This project allows you to practice and strengthen your coding skills, helping you get ready for more advanced tasks ahead.

# API Backend Service README.md

## Objectives

1. **Register New User**: 
    - Create the `POST /api/register` endpoint. To register a new user, the client needs to send a JSON to this endpoint in the following format:

        ```json
        {
          "email": "<username>@<domain>.<extension>",
          "password": "<string, at least 5 characters long>"
        }
        ```

    - The service returns a `200 (OK)` status code if the registration has been completed successfully.
    - If the email is already taken by another user, the service will return a `400 (BAD REQUEST)` status code.
    - Additional restrictions to the format of user credentials:
        - The email must have a valid format (with @ and .).
        - The password must have at least five characters.
    - If any of them is not satisfied, the service must also return a `400 (BAD REQUEST)` status code.

2. **Delete Quiz**:
    - Create the `DELETE` request to `/api/quizzes/{id}` to allow a user to delete their quiz.
    - If the operation was successful, the service returns a `204 (NO CONTENT)` status code without any content.
    - If the specified quiz does not exist, the server returns `404 (NOT FOUND)`. If the specified user is not the author of this quiz, the response is the `403 (FORBIDDEN)` status code.

## Additional Ideas
If you would like your service to support more operations, add `PUT` or `PATCH` to update existing quizzes in a similar way as `DELETE`. Our tests will not verify these operations.

## Examples

1. **Registering a New User with a Valid Request Body**:

    **Request**: `POST /api/register`
    
    **Request body**:
    ```json
    {
      "email": "test@mail.org",
      "password": "strongpassword"
    }
    ```
    
    **Response**: `200 OK`

2. **Registering a New User with a Valid Request Body but the Email Address is Already Taken**:

    **Request**: `POST /api/register`
    
    **Request body**:
    ```json
    {
      "email": "test@mail.org",
      "password": "strongpassword"
    }
    ```
    
    **Response**: `400 BAD REQUEST`

3. **Registering a New User with an Invalid Email**:

    **Request**: `POST /api/register`
    
    **Request body**:
    ```json
    {
      "email": "test@mailorg",
      "password": "strongpassword"
    }
    ```
    
    **Response**: `400 BAD REQUEST`

4. **Registering a New User with a Too Short Password**:

    **Request**: `POST /api/register`
    
    **Request body**:
    ```json
    {
      "email": "test@mail.org",
      "password": "123"
    }
    ```
    
    **Response**: `400 BAD REQUEST`

5. **Requesting a List of Quizzes without Providing a Valid Authentication**:

    **Request**: `GET /api/quizzes`
    
    **Response**: `401 UNAUTHORIZED`

6. **Deleting a Quiz Created by the Same User, Providing a Valid Authentication: email=test@mail.org and password=strongpassword**:

    **Request**: `DELETE /api/quizzes/2`
    
    **Response**: `204 NO CONTENT`

7. **Deleting a Non-existing Quiz, Providing a Valid Authentication: email=test@mail.org and password=strongpassword**:

    **Request**: `DELETE /api/quizzes/20`
    
    **Response**: `404 NOT FOUND`

8. **Deleting a Quiz Created by Another User, Providing a Valid Authentication: email=test@mail.org and password=strongpassword**:

    **Request**: `DELETE /api/quizzes/5`
    
    **Response**: `403 FORBIDDEN`


Once you choose a project, we'll provide you with a study plan that includes all the necessary topics from your track to get it built. Here’s what awaits you:  
+ Create a basic API to accept answers for a single quiz.
+ Method "main"
+ Polymorphism
+ Array
+ Method overriding
+ Wrapping classes. Boxing
+ Grouping classes with packages
+ Inheritance
+ String
+ Types and variables
+ Introduction to Java
+ Initializing new instances. Constructor
+ Break and continue. Branching
+ Object class
+ Getters and setters
+ Conditional statement
+ Integer types and operations
+ Access modifiers
+ Comments
+ Characters
+ Type casting
+ Multiple conditions: switch
+ Overloading
+ Static members
+ The Set interface
+ The List interface
+ Hierarchy of exceptions
+ First glance at exceptions
+ Exception handling
+ Thread management
+ Shared data
+ Adding annotations
+ Thread synchronization
+ Boolean type and operations. True and false
+ Comparing values. Relational operators
+ For-loop
+ While and do-while loops
+ Objects and their properties
+ Iterating over arrays
+ Arrays as parameters
+ Naming variables
+ Reading user's input with Scanner
+ Defining classes
+ Instance methods
+ What is object-oriented programming
+ Multiple constructors
+ Declaring functionality with interfaces
+ Keyword "super"
+ Referencing subclass objects
+ Arithmetic operations
+ Basic literals: numbers, strings and characters
+ Writing first program
+ Basic terms: JVM, JRE, JDK
+ One-line condition with ternary operator
+ Data types and their sizes
+ Errors in programs
+ NullPointerException
+ ArrayList
+ Introduction to generic programming
+ Generics and Object
+ The Collections framework overview
+ Write, compile, and run
+ Printing data
+ What are collections
+ Build tools
+ JAR files
+ Abstract and concrete data structures
+ Custom threads
+ Threads as objects
+ Exceptions in threads
+ Collections and thread-safety
+ Increment and decrement
+ Primitive and reference types
+ Dependency management: repositories
+ Gradle: overview
+ Basic project with Gradle
+ Dynamic array
+ External resources
+ Getting started with Spring Boot
+ Basic project structure
+ HTTP: HyperText Transfer Protocol
+ Command line overview
+ Protected modifier
+ Frameworks
+ Fixed-size array
+ Constants. Final variables
+ Building apps using Gradle
+ Immutability
+ Spring and Spring Boot frameworks
+ Libraries
+ Synchronous, asynchronous, parallel
+ Processes and threads
+ Parameters and options
+ Functional decomposition
+ Calling methods
+ Declaring methods
+ Lambda expressions
+ Coding style conventions
+ YAML
+ Web development
+ Gradle build configuration
+ The Map interface
+ IntelliJ IDEA
+ Hash table
+ HTML basics
+ HTML page structure
+ HTTP URL
+ HTTP messages
+ JSON
+ Posting and deleting data via REST
+ Tags and Attributes
+ REST
+ Postman
+ Hashing: overview
+ Modulo division
+ Hash function
+ Getting data from REST
+ Introduction to Spring Web MVC
+ Introduction to software architecture
+ Thread-safe maps
+ MVC
+ Jackson
+ Customizing REST responses
+ Stage implementation
+ Add more endpoints to the API to deal with multiple quizzes.
+ What are bugs
+ Introduction to logging
+ Handling requests with bodies
+ Spring components
+ Unit testing
+ Exception handling in Spring Boot
+ Code organization. Design principles
+ Interfaces
+ Functional testing
+ Debugging techniques
+ Spring beans
+ @Bean vs @Component
+ IoC Container
+ Logging in Spring Boot
+ Scopes of beans
+ Bean lifecycle
+ Advanced exception handling in Spring Boot
+ Dependency injection
+ Coupling and cohesion
+ ApplicationContext
+ Stage implementation
+ Expand the API and allow users to publish new quizzes.
+ Regexps in Java
+ Sets, ranges, alternations
+ Shorthands
+ Quantifiers
+ Regexes in programs
+ Regular expression
+ Bean validation
+ Stage implementation
+ Migrate the quiz engine from in-memory storage to a relational database.
+ Functional interfaces
+ Method references
+ Standard functional interfaces
+ Concept of design patterns
+ Generic methods
+ XML
+ SQL: structured query language
+ Data and object mapping
+ Object-Relational Mapping (ORM)
+ What are databases
+ Introduction to JPA
+ JPA relationships
+ Optional
+ Default methods
+ Inner classes
+ Anonymous class
+ Relational Data Model
+ Application layers
+ Introduction to Spring Data
+ Intro to MySQL
+ Introduction to PostgreSQL
+ Relational databases with Spring Data
+ Entities
+ Cascade operations
+ Data Transfer Object in Spring
+ Intro to H2 database
+ Embeddable and ElementCollection
+ CRUD Repositories: Create and Read
+ CRUD Repositories: Update and Delete
+ Spring Stereotypes
+ Stage implementation
+ Introduce user registration and protect quizzes from unauthorized modification.
+ Abstract class
+ World Wide Web
+ Basic data types
+ Literals
+ Arithmetic expressions
+ Basic SELECT statement
+ The NULL value
+ SELECT FROM statement
+ Logic and comparison expressions
+ Basic INSERT statement
+ Basic DELETE statement
+ Basic CREATE statement
+ Special WHERE operators
+ Introduction to transactions
+ Understanding Transactions
+ Getting started with Spring Security
+ Authentication and Authorization
+ Web security, OWASP
+ Getting authenticated user details
+ Transaction management
+ Insecure Cryptographic Storage
+ Spring Security Crypto
+ Property expressions
+ Authentication
+ Authorization
+ Custom User Store
+ Stage implementation
+ Add paging and sorting to responses and track statistics for each user.
+ Iterator and Iterable
+ Stack
+ Stack
+ Queue
+ Deque
+ Results ordering
+ Limit and Offset
+ Pagination and sorting
+ Custom queries with @Query
+ Stage implementation
