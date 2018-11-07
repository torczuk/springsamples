### Description

What @Autowire is?

How does autowire work? [Answer](https://docs.spring.io/spring/docs/5.1.2.RELEASE/spring-framework-reference/core.html#beans-factory-autowire)

### Exercise
1. Create new context in the `Application`. Get `Bike` bean from 2nd contexts
2. Add ```@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)``` to the Bike
3. What will happen in case of

```java
    @Autowire
    private Engine engine;

    public Car() {
        System.out.println("by no-args constructor");
    }

    @Autowired
    public void setEngine(Engine engine) {
        System.out.println("by setter");
        this.engine = engine;
    }
```


```java
    //no autowire
    private Engine engine;

    public Car() {
        System.out.println("by no-args constructor");
    }

    @Autowired
    public void setEngine(Engine engine) {
        System.out.println("by setter");
        this.engine = engine;
    }
```

```java
    //no autowire, changed name
    private Engine changedEngine;

    public Car() {
        System.out.println("by no-args constructor");
    }

    @Autowired
    public void setEngine(Engine engine) {
        System.out.println("by setter");
        this.changedEngine = engine;
    }
```

```java
    //no autowire, changed name
    private Engine changedEngine;

    public Car() {
        System.out.println("by no-args constructor");
    }

    //no autowire
    public void setEngine(Engine engine) {
        System.out.println("by setter");
        this.changedEngine = engine;
    }
```

### Questions

(Q): Is it possible to inject Singleton into Prototype?

(Q): Is it possible to inject Prototype into Singleton? (we will cover this after `9-aop`)