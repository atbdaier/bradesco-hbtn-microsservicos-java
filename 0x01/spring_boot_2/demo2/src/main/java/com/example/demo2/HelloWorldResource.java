package com.example.demo2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/messages")
public class HelloWorldResource {

    private static final String MESSAGE = "PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!";

    @GetMapping("/home")
    public String home() {
        return MESSAGE;
    }
}