package com.digitalinnovation.PessoasAPI.controller;


import com.digitalinnovation.PessoasAPI.repository.repositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pessoas")
public class controllerPessoas {

   private repositorioPessoa repositorioPessoa;

   @Autowired
   public controllerPessoas(repositorioPessoa repositorioPessoa){
       this.repositorioPessoa = repositorioPessoa;
   }

    @PostMapping
    public String getBook(){
        return "Api test";
    }

}
