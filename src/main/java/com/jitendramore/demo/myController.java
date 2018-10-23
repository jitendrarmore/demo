package com.jitendramore.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class myController {
    @RequestMapping(value = "/welcome")
    public String WelcomeMsg() {
        return "Welcome to Sprint boot App";


    }

    @RestController
    public class myControllar1 {
        @RequestMapping(value = "/jitendra", method = RequestMethod.GET)
        public String JitendraMsg() {
            return "Welcome Jitendra More, You have been onboard. Thank You";

        }
    }

    @RequestMapping("getUser")
    public String getUsername(@RequestParam(value = "myName") String name) {
        return "Welcome to Expedia String" + name;
    }

}/*
@SpringBootApplication
@Configuration
@PropertySource("classpath:application.properties")
class myApp {
    public static void myApp() {

    }
*/


