package com.torczuk.github;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        HelloWorld bean = ctx.getBean(HelloWorld.class);
        System.out.println(bean.whatLanguageDoYouSpeak());
    }
}
