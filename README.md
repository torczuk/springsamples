### How did Spring change over 16 years?

First release 1st October 2002

Spring in 2003

```
Spring contains a lot of functionality and features, which are well-organized in seven modules shown in the diagram below. This section discusses each the of modules in turn.

Spring could potentially be a one-stop-shop for all your enterprise applications ...
```

![Alt text](img/spring-overview.gif?raw=true "Title")

[Reference]( https://docs.spring.io/spring/docs/1.2.2/reference/)


Spring in 2018

```
From configuration to security, web apps to big data – whatever the infrastructure needs of your application may be, there is a Spring Project to help you build it. Start small and use just what you need – Spring is modular by design.
```

Spring is a portfolio of projects that includes
* spring boot
* spring cloud
* spring for android
* ...

many [others](https://spring.io/docs/reference) and one of them is Spring Framework

```
The Spring Framework provides a comprehensive programming and configuration
model for modern Java-based enterprise applications - on any kind of deployment platform.
```

[Reference]( https://spring.io/projects/spring-framework)


### Criticism

http://samatkinson.com/why-i-hate-spring/

To many magics? Is it better to not use it, or maybe understand?

### Tips

##### 1. How to list all beans?
```java
Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
```

##### 2. Always autowire using constructor args and final fields
```java

private final Engine engine;

Car(Engine engine) {
}
```

##### 3. How to see all dependencies
```
./mvnw dependency:tree --projects module-name
```

##### 4. How to pass command line parameter to Spring Boot
`1.x` version
```
mvnw spring-boot:run -Drun.arguments=--server.port=8081
```

`2.x` version
```
mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

### If you would like to explore more

[Spring Magic](https://content.pivotal.io/springone-platform-2017/its-a-kind-of-magic-under-the-covers-of-spring-boot-brian-clozel-st%C3%A9phane-nicoll)

[Spring Guides](https://spring.io/guides)
