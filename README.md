# SIMPLE BOOK LIBRARY APPLICATION

This backend service is in charge of managing books in the library.

## How to Run

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You can run it using the ```java -jar``` command.

* Clone this repository
* Create Mysql database

    - run `com/nnamdi/library/data/db.sql`

* Make sure you are using JDK 1.8 and Gradle 5.x
* Change mysql username and password as per your installation
    + open `src/main/resources/application.properties`
    + change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation
* You can build the project and run the tests by running ```gradle clean build```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar build/libs/library-0.0.1-SNAPSHOT.jar
```


Once the application runs you should see something like this

```
2017-08-29 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8090 (http)
2017-08-29 17:31:23.097  INFO 19387 --- [           main] com.khoubyari.example.Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```

## About the Service

The service is just a simple REST service for managing books in a library. It uses a mysql database to store the data. You can also use other relational database like PostgreSQL. If your database connection properties work, you can call some REST endpoints defined in ```package com.nnamdi.library.controller``` on **port 9000**. (see below)

More interestingly, you can start calling some operational endpoints (see full list below) like ```/api/v1/book``` and ```/api/v1/category``` (these are available on **port 9000**)

You can use this sample service to understand the conventions and configurations that allow you to create a DB-backend RESTful service.


Here are some endpoints you can call:

### Add a book

```
POST 'http://localhost:9000/api/v1/book'

```

### Get list of books

```
GET 'http://localhost:9000/api/v1/books'

```

### Edit Book

```
PUT 'http://localhost:9000/api/v1/book/{id}'



```
### Assign Book to a Category

```
PUT 'http://localhost:9000/api/v1/category/book/{id}'



```

### Delete Book

```
DELETE 'http://localhost:9000/api/v1/book/{id}'



```

### Get favorite books

```
GET 'http://localhost:9000/api/v1/favorite/books'

```

### Add a category

```
POST 'http://localhost:9000/api/v1/category'
```

### Get list of categories

```
GET 'http://localhost:9000/api/v1/category'
```

### Edit Category

```
PUT 'http://localhost:9000/api/v1/category/{id}'
```

### Delete Category

```
DELETE 'http://localhost:9000/api/v1/category/{id}'
```
## Code Snippets

### Add a book
```
curl --location --request POST 'http://localhost:9000/api/v1/book' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Alice In the Wonderland",
    "pages": 209,
    "authors": [
        {
            "firstName": "Sanchez",
            "lastName": "Grey"
        }
    ],
    "description": "Alice is wondering where to go",
    "edition": "1st Edition",
    "publisher": "Lampstack",
    "ratings": 5
   
}'

RESPONSE: HTTP 201 (Created)
{
    "createdAt": "2021-12-12T19:55:19.010+00:00",
    "updatedAt": "2021-12-12T19:55:19.010+00:00",
    "bookId": 1,
    "title": "ALICE IN THE WONDERLAND",
    "pages": 209,
    "description": "Alice is wondering where to go",
    "edition": "1st Edition",
    "publisher": "Lampstack",
    "ratings": 5,
    "category": null,
    "authors": [
        {
            "createdAt": "2021-12-12T19:55:19.078+00:00",
            "updatedAt": "2021-12-12T19:55:19.078+00:00",
            "authorId": 1,
            "firstName": "Sanchez",
            "lastName": "Grey"
        }
    ]
}
```



### Get list of all books

```
curl --location --request GET 'http://localhost:9000/api/v1/books' \
--header 'Content-Type: application/json' \


RESPONSE: HTTP 200 
[
    {
        "createdAt": "2021-12-12T19:55:19.000+00:00",
        "updatedAt": "2021-12-12T19:55:19.000+00:00",
        "bookId": 1,
        "title": "ALICE IN THE WONDERLAND",
        "pages": 209,
        "description": "Alice is wondering where to go",
        "edition": "1st Edition",
        "publisher": "Lampstack",
        "ratings": 5,
        "category": [],
        "authors": [
            {
                "createdAt": "2021-12-12T19:55:19.000+00:00",
                "updatedAt": "2021-12-12T19:55:19.000+00:00",
                "authorId": 1,
                "firstName": "Sanchez",
                "lastName": "Grey"
            }
        ]
    }
]
```

### Edit a book
```
curl --location --request GET 'http://localhost:9000/api/v1/books' \
--header 'Content-Type: application/json' \
--data-raw '{
    
    "edition": "2nd Edition",
    "publisher": "Longman Dictionary"
   
}'

RESPONSE: HTTP 201 (Created)
{
    "createdAt": "2021-12-12T19:55:19.000+00:00",
    "updatedAt": "2021-12-12T20:34:01.434+00:00",
    "bookId": 1,
    "title": "ALICE IN THE WONDERLAND",
    "pages": 209,
    "description": "Alice is wondering where to go",
    "edition": "2nd Edition",
    "publisher": "Longman Dictionary",
    "ratings": 5,
    "category": [],
    "authors": [
        {
            "createdAt": "2021-12-12T19:55:19.000+00:00",
            "updatedAt": "2021-12-12T19:55:19.000+00:00",
            "authorId": 1,
            "firstName": "Sanchez",
            "lastName": "Grey"
        }
    ]
}
```



### Assign Book to a category

```
curl --location --request PUT 'http://localhost:9000/api/v1/category/book/1' \
--header 'Content-Type: application/json' \
--data-raw '{
    
  "category" : [
      {
          "categoryId": 2
      }
  ]
   
}'


RESPONSE: HTTP 200 
{
    "createdAt": "2021-12-12T19:55:19.000+00:00",
    "updatedAt": "2021-12-13T08:02:08.717+00:00",
    "bookId": 1,
    "title": "ALICE IN THE WONDERLAND",
    "pages": 209,
    "description": "Alice is wondering where to go",
    "edition": "2nd Edition",
    "publisher": "Longman Dictionary",
    "ratings": 5,
    "category": [
        {
            "createdAt": "2021-12-12T20:38:39.000+00:00",
            "updatedAt": "2021-12-13T07:35:16.000+00:00",
            "categoryId": 2,
            "name": "RELIGION"
        }
    ],
    "authors": [
        {
            "createdAt": "2021-12-12T19:55:19.000+00:00",
            "updatedAt": "2021-12-12T19:55:19.000+00:00",
            "authorId": 1,
            "firstName": "Sanchez",
            "lastName": "Grey"
        }
    ]
}
```

### Delete Book

```
curl --location --request DELETE 'http://localhost:9000/api/v1/book/2' \
--data-raw ''


RESPONSE: HTTP 200 
{
    "createdAt": "2021-12-13T08:06:03.000+00:00",
    "updatedAt": "2021-12-13T08:06:03.000+00:00",
    "bookId": 2,
    "title": "JAVA MADE SIMPLE",
    "pages": 1009,
    "description": "Introduction to Java",
    "edition": "1st Edition",
    "publisher": "Lampstack",
    "ratings": 5,
    "category": [],
    "authors": [
        {
            "createdAt": "2021-12-13T08:06:03.000+00:00",
            "updatedAt": "2021-12-13T08:06:03.000+00:00",
            "authorId": 2,
            "firstName": "Bode",
            "lastName": "Jane"
        }
    ]
}
```


### Favorite Book

```
curl --location --request GET 'http://localhost:9000/api/v1/favorite/books' \
--data-raw ''

RESPONSE: HTTP 200 
[
    {
        "createdAt": "2021-12-12T19:55:19.000+00:00",
        "updatedAt": "2021-12-13T08:02:09.000+00:00",
        "bookId": 1,
        "title": "ALICE IN THE WONDERLAND",
        "pages": 209,
        "description": "Alice is wondering where to go",
        "edition": "2nd Edition",
        "publisher": "Longman Dictionary",
        "ratings": 5,
        "category": [
            {
                "createdAt": "2021-12-12T20:38:39.000+00:00",
                "updatedAt": "2021-12-13T07:35:16.000+00:00",
                "categoryId": 2,
                "name": "RELIGION"
            }
        ],
        "authors": [
            {
                "createdAt": "2021-12-12T19:55:19.000+00:00",
                "updatedAt": "2021-12-12T19:55:19.000+00:00",
                "authorId": 1,
                "firstName": "Sanchez",
                "lastName": "Grey"
            }
        ]
    },
    {
        "createdAt": "2021-12-13T08:11:28.000+00:00",
        "updatedAt": "2021-12-13T08:11:28.000+00:00",
        "bookId": 3,
        "title": "JAVA MADE SIMPLE",
        "pages": 1009,
        "description": "Introduction to Java",
        "edition": "1st Edition",
        "publisher": "Lampstack",
        "ratings": 5,
        "category": [],
        "authors": [
            {
                "createdAt": "2021-12-13T08:11:28.000+00:00",
                "updatedAt": "2021-12-13T08:11:28.000+00:00",
                "authorId": 3,
                "firstName": "Bode",
                "lastName": "Jane"
            }
        ]
    }
]
```

### Add a category
```
curl --location --request POST 'http://localhost:9000/api/v1/category' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Motivational"  
}'

RESPONSE: HTTP 201 (Created)
{
    "createdAt": "2021-12-12T20:41:25.041+00:00",
    "updatedAt": "2021-12-12T20:41:25.041+00:00",
    "categoryId": 4,
    "name": "MOTIVATIONAL",
    "books": []
}
```

### Get Category

```
curl --location --request GET 'http://localhost:9000/api/v1/category' \
--data-raw ''


RESPONSE: HTTP 200 
[
    {
        "createdAt": "2021-12-12T20:38:39.000+00:00",
        "updatedAt": "2021-12-13T07:35:16.000+00:00",
        "categoryId": 2,
        "name": "RELIGION",
        "books": [
            {
                "createdAt": "2021-12-12T19:55:19.000+00:00",
                "updatedAt": "2021-12-13T07:33:21.000+00:00",
                "bookId": 1,
                "title": "ALICE IN THE WONDERLAND",
                "pages": 209,
                "description": "Alice is wondering where to go",
                "edition": "2nd Edition",
                "publisher": "Longman Dictionary",
                "ratings": 5,
                "authors": [
                    {
                        "createdAt": "2021-12-12T19:55:19.000+00:00",
                        "updatedAt": "2021-12-12T19:55:19.000+00:00",
                        "authorId": 1,
                        "firstName": "Sanchez",
                        "lastName": "Grey"
                    }
                ]
            }
        ]
    },
    {
        "createdAt": "2021-12-12T20:41:08.000+00:00",
        "updatedAt": "2021-12-12T20:41:08.000+00:00",
        "categoryId": 3,
        "name": "CHILDREN",
        "books": []
    },
    {
        "createdAt": "2021-12-12T20:41:25.000+00:00",
        "updatedAt": "2021-12-13T07:42:14.000+00:00",
        "categoryId": 4,
        "name": "MOTIVATIONAL",
        "books": [
            {
                "createdAt": "2021-12-12T19:55:19.000+00:00",
                "updatedAt": "2021-12-13T07:33:21.000+00:00",
                "bookId": 1,
                "title": "ALICE IN THE WONDERLAND",
                "pages": 209,
                "description": "Alice is wondering where to go",
                "edition": "2nd Edition",
                "publisher": "Longman Dictionary",
                "ratings": 5,
                "authors": [
                    {
                        "createdAt": "2021-12-12T19:55:19.000+00:00",
                        "updatedAt": "2021-12-12T19:55:19.000+00:00",
                        "authorId": 1,
                        "firstName": "Sanchez",
                        "lastName": "Grey"
                    }
                ]
            }
        ]
    }
]
```

### Update Category

```
curl --location --request PUT 'http://localhost:9000/api/v1/category/4' \
--header 'Content-Type: application/json' \
--data-raw '{
    
    "name": "Motivational"
   
}'


RESPONSE: HTTP 200 
{
    "createdAt": "2021-12-12T20:41:25.000+00:00",
    "updatedAt": "2021-12-13T07:42:14.366+00:00",
    "categoryId": 4,
    "name": "MOTIVATIONAL",
    "books": [
        {
            "createdAt": "2021-12-12T19:55:19.000+00:00",
            "updatedAt": "2021-12-13T07:33:21.000+00:00",
            "bookId": 1,
            "title": "ALICE IN THE WONDERLAND",
            "pages": 209,
            "description": "Alice is wondering where to go",
            "edition": "2nd Edition",
            "publisher": "Longman Dictionary",
            "ratings": 5,
            "authors": [
                {
                    "createdAt": "2021-12-12T19:55:19.000+00:00",
                    "updatedAt": "2021-12-12T19:55:19.000+00:00",
                    "authorId": 1,
                    "firstName": "Sanchez",
                    "lastName": "Grey"
                }
            ]
        }
    ]
}
```

### Delete Category

```
curl --location --request DELETE 'http://localhost:9000/api/v1/category/3' \
--data-raw ''


RESPONSE: HTTP 200 
{
    "createdAt": "2021-12-12T20:41:08.000+00:00",
    "updatedAt": "2021-12-12T20:41:08.000+00:00",
    "categoryId": 3,
    "name": "CHILDREN",
    "books": []
}
```


# About Spring Boot

Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). It provides many of the usual Spring facilities that can be configured easily usually without any XML. In addition to easy set up of Spring Controllers, Spring Data, etc. Spring Boot comes with the Actuator module that gives the application the following endpoints helpful in monitoring and operating the service:



# Area of Improvement

**1. Writing Test for the endpoints** 

**2. Creating a Swagger Documentation for the endpoints**

**2. Improved error handling and Response messages**


### Questions and Comments: nwabuokeinnamdi19@gmail.com

