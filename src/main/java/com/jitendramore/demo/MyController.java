package com.jitendramore.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {
    @RequestMapping(value = "/welcome")
    public String welcomeMsg() {
        return "Welcome to Sprint boot App";


    }

}

@RestController
@RequestMapping("/Expedia/v1")
class myControllar1 {
    @RequestMapping(value = "/jitendra", method = RequestMethod.GET)
    public String JitendraMsg() {
        return "Welcome Jitendra More, You have been onboard. Thank You";

    }
    @RequestMapping("Users")
    public List getUsername() {
        Map user = new HashMap<>();
        user.put("Name", "Jitendra More");
        user.put("Address", "Mumbai Haryana");
        user.put("Mobile", "9833550438");
        user.put("Company", "Expedia");

        List Users = new ArrayList();
        Users.add(user);

        return Users;
    }
}


