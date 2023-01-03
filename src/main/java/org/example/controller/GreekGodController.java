package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreekGodController {

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World";
    }
}
