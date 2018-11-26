### Description

#### Aspect Oriented Programming
```
In computing, aspect-oriented programming (AOP) is a programming paradigm
that aims to increase modularity by allowing the separation of cross-cutting concerns.
```
Source wiki

Is it clear? No? as I thought. Lets take a look at example. What is wrong here?
Does it follow OpenClose principle, how many Actors does the Car have?

```java

class Car {

    private final MetricRepository metrics;

    public void drive() {
        long start = currentTimeMillis();
        try {
            engine.start();
            lights.switchOf();
            suspense.releaseBreak();
            // ...
        } finally {
            long end = currentTimeMillis();
            metrics.put("drive-time", end - start);
        }
    }
}

```

Can we keep separate domain from infrastructure?

```java

class Car {

    public void drive() {
        engine.start();
        lights.switchOf();
        suspense.releaseBreak();
        //..
    }
}

@Aspect // aspect
class MonitoringAspect {
    private final MetricRepository metrics;

    @Around( // type of advice
        "execution(* com.torczuk.github.Car.drive())") // point cut
        public Object aroundDriving(
            ProceedingJoinPoint pjp) { // join point
            long start = ...
            Object proceed = pjp.proceed();
            long end = ...
        }
}

```

Logging, Transaction management, Security are falling in the same category
Two additional definitions

#### Aspect
```
An aspect of a program is a feature linked to many other parts of the program,
but which is not related to the program's primary function.
```
Source [wiki](https://en.wikipedia.org/wiki/Aspect_(computer_programming))

Keyword - feature

### Concern
```
(...)is particular set of behaviors.
(...) Edsger W. Dijkstra coined the term "separation of concerns" to describe the mentality behind this modularization, which allows the programmer to reduce the complexity of the system being designed.
Two different concerns that intermingle in the same section of code are called "highly coupled".
Sometimes the chosen module divisions do not allow for one concern to be completely separated from another, resulting in cross-cutting concerns.
```
Source [wiki](https://en.wikipedia.org/wiki/Concern_(computer_science))

#### Cross-cutting concern
```
Cross-cutting concerns are parts of a program that rely on or must affect many other parts of the system.
They form the basis for the development of aspects.
Such cross-cutting concerns do not fit cleanly into object-oriented programming or procedural programming
```
Source [wiki](https://en.wikipedia.org/wiki/Cross-cutting_concern)

### Cons of using AOP

* Testing
* Good luck if you put business logic there :)

### More reading
https://docs.spring.io/spring/docs/5.1.2.RELEASE/spring-framework-reference/core.html#aop


### Exercise

I want to log all invocation of public methods :)

```
@Before("execution(public * *(..))")
```