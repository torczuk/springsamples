package com.torczuk.github;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Engine {

    public int hpPower() {
        return 140;
    }

    @PostConstruct
    public void init() {
        //tricky to test :(
        System.out.println("Engine has been created");
    }

    @PreDestroy
    public void destroy() {
        //tricky to test :(
        System.out.println("Engine is going to destroyed");
    }
}
