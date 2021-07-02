package com.digitalinnovation.PessoasAPI.controller;


import com.digitalinnovation.PessoasAPI.dto.MessageResponseDTO;
import com.digitalinnovation.PessoasAPI.entity.Pessoa;
import com.digitalinnovation.PessoasAPI.repository.repositorioPessoa;
import com.digitalinnovation.PessoasAPI.service.pessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pessoas")
public class controllerPessoas {

    private pessoaService pessoaService;

    @Autowired
    public controllerPessoas (pessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPessoa(@RequestBody  Pessoa pessoa){
        return pessoaService.createPessoa(pessoa);
    }

}
