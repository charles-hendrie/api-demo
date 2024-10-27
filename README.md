# api-demo

A Java / Spring Boot service to retrieve GitHub user information.

## How To Run

- Clone the repo
- Build the service 

```
$ ./gradlew clean build
```

- Run the service

```
$ ./gradlew bootRun
```

- Make a GET request to the endpoint to retrieve the user's data

```
localhost:8080/api/github/users/[username]
```

## Design

Implemented a stack separating the handling of the request into levels of concern.

1. Controller (communication)
2. Service (business logic)
3. Delegate (data retrieval)

## Todos

1. Add exception / error handling
2. Additional logging
