### Description

Run the code. Is bean Singleton? yes, but ...

What if I need to create bean every time?

Are there any other scopes? [yes](https://docs.spring.io/spring/docs/5.1.2.RELEASE/spring-framework-reference/core.html#beans-factory-scopes)

### Exercise
1. Create new context in the `Application`. Get `Bike` bean from two contexts
2. Add ```@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)``` to the Bike



