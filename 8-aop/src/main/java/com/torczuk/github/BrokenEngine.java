package com.torczuk.github;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BrokenEngine {

    public BrokenEngine() {
    }

    public void start() {
        throw new IllegalStateException("I am broken !!!");
    }
}
