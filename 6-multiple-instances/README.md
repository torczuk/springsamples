### Description

Sometime there is a need to have multiple bean of the same type, e.g.
I want to have `fast` and `slow` Car

How do to this? Open `Config` class


### Exercise

1. Create `Race` bean. What the problem do you see here?. Write the test for race between `mercedes` and `seat`
where `mercedes` should be *fast* and `seat` *slow* :)

```java
@Component
public class Race {

    private Car firstCar;
    private Car secondCar;

    @Autowired
    public Race(Car firstCar, Car secondCar) {
        this.firstCar = firstCar;
        this.secondCar = secondCar;
    }

    public Car winner() {
        return firstCar.maxSpeed() > secondCar.maxSpeed() ? firstCar : secondCar;
    }
}
```

Hint: `org.springframework.beans.factory.annotation.Qualifier`


2. Take a look at the tests and configuration. Guess which test will pass

3. How to fix ByTypeTest? Let's say I would like to have *default* bean

Hint : `org.springframework.context.annotation.Primary`

3. Copy `5a-configuration` module. Introduce new Bean `Suspension`
```java
class Suspension {

    private CarWheel frontLeft;
    private CarWheel frontRight;
    private CarWheel backLeft;
    private CarWheel backRight;
    ...
}

```

implement it in a way to satisfy below test
```java
    @Autowired
    private Suspension suspension;

    @Test
    public void shouldAutowireSuspension() {
        assertThat(suspension).isNotNull();
        assertThat(suspension.getWheelTypes())
                .contains("frontLeft", "frontRight", "backLeft", "backRight");
    }
```