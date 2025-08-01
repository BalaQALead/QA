# API Test Automation (Java) — REST Assured + TestNG

This repository contains automated API tests for the public API **JSONPlaceholder**: https://jsonplaceholder.typicode.com/guide/

It covers:
- **GET** `/posts` — validates 200, schema, and response time < 2s
- **POST** `/posts` — creates a post and captures the `id`
- **PUT** `/posts/{id}` — updates the created post
- **PATCH** `/posts/{id}` — partial update
- **DELETE** `/posts/{id}` — deletes the created post
- **Negative tests** — invalid endpoint, invalid content-type
- **Performance check** — ensured via `time(lessThan(2000))`

> Note: JSONPlaceholder is a fake API; create/update/delete calls echo back data and may not persist. Tests are written accordingly.

## Tech Stack
- Java 11+
- Maven
- REST Assured 5.x
- TestNG
- JSON Schema Validator

## Project Structure
```
src/
└── test
    ├── java
    │   └── com/example/api
    │       ├── BaseTest.java
    │       └── JsonPlaceholderTests.java
    └── resources
        └── schemas
            └── posts.schema.json
```

## Setup
1. Install Java 11+ and Maven.
2. Clone this project (or unzip the provided archive).
3. From the project root, run:
   ```bash
   mvn -q -version
   mvn clean test
   ```

## How to run
Default base URL and performance threshold are configured in `pom.xml` and can be overridden:
```bash
mvn clean test -DbaseUrl=https://jsonplaceholder.typicode.com -DperfThresholdMs=2000
```

## Reports
- TestNG & Surefire reports under `target/surefire-reports` (HTML & text).
- Console output logs request method and response status.

## Extending
- Add more endpoints (e.g., `/users`, `/comments`).
- Add JSON schemas under `src/test/resources/schemas` and validate with `matchesJsonSchemaInClasspath(...)`.
- Switch to `reqres.in` by changing `-DbaseUrl=https://reqres.in/api` and updating paths/body as needed.

---

**Authoring Note**: This project was scaffolded to satisfy the assignment shown in the screenshots: CRUD ops, negative testing, response-time check, and optional JSON schema validation.
