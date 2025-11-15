package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/messages")
public class MessageResource {

    public static final String MESSAGE = "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";

    public static final String ERROR_ISNULL = "USUÁRIO E SENHA NÃO INFORMADOS";

    private static final String ERROR_15 = "USUÁRIO E SENHA INVÁLIDOS";

    private static final String LOGIN_OK =  "LOGIN EFETUADO COM SUCESSO !!!";

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return MESSAGE;
    }

    @GetMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password) {
        if(user.isBlank() ||  user.isEmpty() || password.isBlank() || password.isEmpty()) {
            return ERROR_ISNULL;
        }
        if(user.length() > 15 || password.length() > 15) {
            return ERROR_15;
        }else {
            return LOGIN_OK;
        }
    }

}