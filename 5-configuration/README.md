### Description

### Questions

Q: Is there any way to register into ApplicationContext object provided by 3rd party library

A: yes
```java
@Configuration
public class Config {

    @Bean
    public BeanType beanName() {
        ...
    }
}

```

