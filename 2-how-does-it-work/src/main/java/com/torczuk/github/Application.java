package com.torczuk.github;


import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Map<Class, Object> context = new HashMap<>();

        Class<HelloWorld> helloWorldClass = HelloWorld.class;

        if (helloWorldClass.isAnnotationPresent(Component.class)) {
            HelloWorld helloWorld = helloWorldClass.newInstance();
            context.put(helloWorldClass, helloWorld);
        }

        HelloWorld bean = (HelloWorld) context.get(helloWorldClass);
        System.out.println(bean.whatLanguageDoYouSpeak());
    }

}
