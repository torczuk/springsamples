### Description

### Questions

Q: Is there any way to be notified about bean lifecycle, or when properties has been set?

A: yes
```java
javax.annotation.PostConstruct
javax.annotation.PreDestroy
```


### Exercise

1. Modify `Car.init` method and check if car is fast. What has happened?

2. Is it any way to handle this without `InitializingBean.afterPropertiesSet` ?

3. What is the output on the log with and without default constructor?