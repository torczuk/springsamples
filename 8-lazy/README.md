### Description

`Lazy` bean is like a Schrödinger's cat. You do now if it works until you invoke method on it

What are the pros and cons

### Questions
(Q): Does lazy bean appear when listing all beans?

(Hint): `AbstractFactoryBean:317`

(Q): What do you think about this?
```
@Lazy
@Configuration {

    Car car() {}
    Engine engine() {}
    ...
}
```

### Tip

Always prefer eager bean initialization, unless you have a good reason