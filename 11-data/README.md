### Description

Spring Boot allows to provide own way to build schema using `schema.sql`
You can populate the data using `data.sql`

Vast majority of projects is using flywaydb :)
Sample configuration you can find in module *18-transactions*

```
jpa:
    hibernate:
      ddl-auto: none
    database-platform: org.hibernate.dialect.H2Dialect
```