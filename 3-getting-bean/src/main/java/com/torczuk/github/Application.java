package com.torczuk.github;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        Bike byClass = ctx.getBean(Bike.class);
        Bike byName = (Bike) ctx.getBean("bike");
        Vehicle byInterface = ctx.getBean(Vehicle.class);

        System.out.println("Are bikes the same? :" + (byClass == byName));
        byInterface.drive();
    }
}
