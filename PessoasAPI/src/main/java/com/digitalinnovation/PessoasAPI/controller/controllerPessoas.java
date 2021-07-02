package com.digitalinnovation.PessoasAPI.controller;


import com.digitalinnovation.PessoasAPI.entity.Pessoa;
import com.digitalinnovation.PessoasAPI.repository.repositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoas")
public class controllerPessoas {

   private repositorioPessoa repositorioPessoa;

   @Autowired
   public controllerPessoas(repositorioPessoa repositorioPessoa){
       this.repositorioPessoa = repositorioPessoa;
   }

    @PostMapping
    public MessageResponseDTO createPessoa(@RequestBody  Pessoa pessoa){
       Pessoa pessoaSalva =  repositorioPessoa.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com id " + pessoaSalva.getId())
                .build();
    }

}
