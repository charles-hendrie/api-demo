# api-demo

A Java / Spring Boot service to retrieve GitHub user information.

## How To Run

To run the service locally, perform the follow steps...

- Clone the repo

```
https://github.com/charles-hendrie/api-demo
```

- Build the service 

```
$ ./gradlew clean build
```

- Run the service

```
$ ./gradlew bootRun
```

- Execute a GET request to retrieve a user's data

```
localhost:8080/api/github/users/[username]
```

## Design

Implemented a stack separating the handling of the request into levels of concern.

1. Controller (communication)
2. Service (business logic)
3. Delegate (data retrieval)

## Notes

To start, only a final catch has been implemented in the controller to capture any errors in the processing of a user with a 404 Not Found returned.

## Todos

1. Add exception / error handling
2. Add logging
