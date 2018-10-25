package com.jitendramore.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping(value = "/welcome")
    public String welcomeMsg() {
        return "Welcome to Sprint boot App";


    }

}

@RestController
class myControllar1 {
    @RequestMapping(value = "/jitendra", method = RequestMethod.GET)
    public String JitendraMsg() {
        return "Welcome Jitendra More, You have been onboard. Thank You";

    }
    @RequestMapping("getUser")
    public String getUsername(@RequestParam(value = "myName") String name) {
        return "Welcome to Expedia String" + name;
    }
}


