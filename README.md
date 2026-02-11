# camunda-SE-coding-challenge
Camunda coding assessment Senior SE


This project calls the ReqRes endpoint `https://reqres.in/api/users?page=1`, maps the JSON `data[]` array into `UserDTO` objects, and prints `firstName lastName` for each user.

## Prerequisites
- Java 17+
- Maven 3.8+

Check versions:
```bash
java -version
mvn -version
```

## Run from the project root 
(1) to set API key (required) 
```bash
export REQRES_API_KEY="YOUR_KEY_VALUE"
```
(2) compile and run the application
```bash
mvn -q clean compile exec:java
```

## Expected output
Example:
```nginx
George Bluth
Janet Weaver
Emma Wong
Eve Holt
Charles Morris
Tracey Ramos
```

