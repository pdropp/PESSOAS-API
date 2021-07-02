package com.digitalinnovation.PessoasAPI.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoas")
public class controllerPessoas {

    @GetMapping
    public String getBook(){
        return "Api test";
    }

}
