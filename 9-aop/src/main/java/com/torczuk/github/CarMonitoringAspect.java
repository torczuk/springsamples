package com.torczuk.github;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class CarMonitoringAspect {


    @Before("execution(* com.torczuk.github.Car.drive())")
    public void beforeDriving(JoinPoint joinPoint) {
        System.out.println("Before Driving car at: " + LocalDateTime.now());
    }

    @After("execution(* com.torczuk.github.Car.drive())")
    public void afterAnyDriving(JoinPoint joinPoint) {
        System.out.println("After any driving car at: " + LocalDateTime.now());
    }

    @Around("execution(* com.torczuk.github.Car.drive())")
    public void duringDriving(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("During driving car at: " + LocalDateTime.now());
        proceedingJoinPoint.proceed();
    }

    @AfterThrowing(
            pointcut = "execution(* com.torczuk.github.*.drive())",
            throwing = "ex")
    public void onlyInCaseOfEmergency(IllegalStateException ex) {
        String message = ex.getMessage();
        System.out.println("Call assistance +65 ..." + message);
    }

    @AfterReturning(value = "execution(* com.torczuk.github.Car.*())",
            returning = "result")
    public void afterAccessingToCar(JoinPoint joinPoint, Object result) {
        System.out.println("After getting value: " + result);
    }

//    @Before("execution(public * *(..))")
//    public void anyPublicMethod(JoinPoint joinPoint) {
//        System.out.println("Running method: " + joinPoint.getSignature().getName() + " in " + joinPoint.getTarget().getClass());
//    }
}
