### Description
Previous module manual handle exception handling. Spring boot allows to do it in better way

There are two ways to generic handle exceptions
First way is to create own exception and annotate them by `ResponseStatus`

```java
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource not Found")
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
```


Another more flexible way is introduce custom exception handler
```java
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleAccessDenied(Exception ex, WebRequest request) {
        String message = ex.getMessage();
        return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}

```
