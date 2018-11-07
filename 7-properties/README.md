### Description

Properties are everywhere. Url to database, username, timeout to the external service,
number of working threads and many others application's properties should not be placed in compiled file

Spring uses convention `application-{profile-name}.[yml|properties]` when it comes to handle properties.
This file will be shared between your application and spring projects.
Guess how many different properties exist in spring boot 2.0.3 :)

[Answer](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

You can pass a property to your application in 17 ways :] [17 ways to pass property to project](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html)

you only need to remember that

```
 test >
    command line >
        servlet >
            System.Properties >
                OS properties >
                     application.properties >
                        defaults
```


### Questions

(Q): Why command line has so height priority?

(Q): how to pass command line args to spring boot?

(A):

`1.x`
```
mvnw spring-boot:run -Drun.arguments=--server.port=8081
```

`2.x`
```
mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

### Exercise
Fix `OverridePropertyTest`