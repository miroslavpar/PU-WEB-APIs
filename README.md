# TV Show API

## Overview

This is a RESTful API built with Spring Boot for managing TV shows, seasons, episodes, and actors. It provides basic CRUD operations for each entity.

## Features

- Manage TV shows: Create, Read, Update, Delete (CRUD) operations.
- Manage seasons associated with shows.
- Manage episodes associated with seasons.
- Manage actors associated with shows and episodes.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (or your choice of database)
- Maven
- Swagger for API documentation

## Getting Started

### Prerequisites

- JDK 11 or higher
- Maven

### Clone the Repository

```bash
git clone https://github.com/yourusername/PU-WEB-APIs.git
cd PU-WEB-APIs
```

### Documentation
When you start the service it can be accessible on localhost and on port 8080
The respective documentation can be found under:
- /swagger-ui.html

For completeness i'm adding it here as well :

#### API Endpoints
##### Shows
- **GET /shows** - Retrieve all shows
- **POST /shows** - Create a new show
- **GET /shows/{id}** - Retrieve a show by ID
- **PUT /shows/{id}** - Update a show by ID
- **DELETE /shows/{id}** - Delete a show by ID

##### Seasons
- **GET /seasons** - Retrieve all seasons
- **POST /seasons** - Create a new seasons
- **GET /seasons/{id}** - Retrieve a seasons by ID
- **PUT /seasons/{id}** - Update a seasons by ID
- **DELETE /seasons/{id}** - Delete a seasons by ID

##### Episodes
- **GET /episodes** - Retrieve all episodes
- **POST /episodes** - Create a new episodes
- **GET /episodes/{id}** - Retrieve a episodes by ID
- **PUT /episodes/{id}** - Update a episodes by ID
- **DELETE /episodes/{id}** - Delete a episodes by ID

##### Actors
- **GET /actors** - Retrieve all actors
- **POST /actors** - Create a new actors
- **GET /actors/{id}** - Retrieve a actors by ID
- **PUT /actors/{id}** - Update a actors by ID
- **DELETE /actors/{id}** - Delete a actors by ID

##### Example CRUD requests
````
- curl -X POST localhost:8080/actors -H "Content-Type: application/json" -d '{"name": "Brad Pitt","shows": []}'
- curl -X GET localhost:8080/actors -H "Content-Type: application/json"
- curl -X PUT localhost:8080/actors/1 -H "Content-Type: application/json" -d '{"name": "CHANGED"}
- curl -X DELETE localhost:8080/actors/1 -H "Content-Type: application/json"
````

For the other rest endpoints it's similar with some adjustments in the body request
