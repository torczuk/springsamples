package com.torczuk.github;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class CarMonitoring {

    @AfterThrowing(
            pointcut = "execution(* com.torczuk.github.**.drive())",
            throwing = "ex")
    public void callAssistanceInCaseOfIssueDuringDrivingCar(IllegalStateException ex) {
        String message = ex.getMessage();
        System.out.println("Call assistance +65 ..." + message);
    }

    @Before("execution(* com.torczuk.github.Car.drive())")
    public void carDrivingLog() {
        System.out.println("Driving car at: " + LocalDateTime.now());
    }
}
