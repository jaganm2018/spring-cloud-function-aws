### How to replicate the issue

1. Run `./mvnw spring-boot:run`. This should start the app as a spring boot app and the functions will be available as a REST endpoint

2. Test the save function without function routing

```
curl -XPOST 'http://localhost:8080/save' \
-H 'Content-Type: application/json' \
-d '[
    {
    "id": "isddsddwqdcZC",
    "name": "save",
    "data": "blah blah"
    }
]'
```

This should return the response as below and HTTP 200

```
{
    "status": "SUCCESS",
    "ids": [
        "isddsddwqdcZC"
    ]
}
```

3. Test the function router

```
curl -X POST 'http://localhost:8080/functionRouter' \
-H'spring.cloud.function.definition: save' \
-H'Content-Type: application/json' \
-d'[
    {
    "id": "isddsddwqdcZC",
    "name": "save",
    "data": "blah blah"
    }
]'
```

This request will throw an exception and you can see the stack trace as reported in https://github.com/spring-cloud/spring-cloud-function/issues/686

