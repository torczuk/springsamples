package com.torczuk.github;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class BrokenEngine {

    public BrokenEngine() {
        throw new IllegalStateException("I am broken !!!");
    }

    public void start() {

    }
}
