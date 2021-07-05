package com.digitalinnovation.PessoasAPI.controller;


import com.digitalinnovation.PessoasAPI.dto.MessageResponseDTO;
import com.digitalinnovation.PessoasAPI.dto.request.PessoaDTO;
import com.digitalinnovation.PessoasAPI.service.PessoaService;
import com.digitalinnovation.PessoasAPI.service.execption.pessoaNaoExiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class ControllerPessoas {

    private PessoaService pessoaService;

    @Autowired
    public ControllerPessoas (PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
        return pessoaService.createPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listAll(){
        return pessoaService.listAll();
    }


    @GetMapping("/{id}")
    public PessoaDTO findById(@PathVariable Long id) throws pessoaNaoExiste {
        return pessoaService.findById(id);
    }
}
