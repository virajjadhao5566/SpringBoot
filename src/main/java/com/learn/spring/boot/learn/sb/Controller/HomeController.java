package com.learn.spring.boot.learn.sb.Controller;

import com.learn.spring.boot.learn.sb.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController
public class HomeController {
//    To map the route
//    @RequestMapping("/",Request.method = "GET") can be also used
    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/user")
//    Function to return a user
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("Viraj");
        user.setEmail("virajjadhao85@gmail.com");
        return user;
    }
//    PathVariables : To fetch variables from URL
    @GetMapping("/{name}")
    public String pathVariables(@PathVariable String name){
        return "Hello my name is " + name;
    }
}
