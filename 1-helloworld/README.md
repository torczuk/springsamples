Run the example and take a look at the log

Two important things here `@SpringBootApplication` and `@Component`


Go back after `2-how-does-it-work`

Modify the `Application` code
```java
Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
```

Take a look at the methods
```java
DefaultListableBeanFactory.registerBeanDefinition(..)
DefaultListableBeanFactory.getBean(..)
ClassPathScanningCandidateComponentProvider.registerDefaultFilters(..)
```