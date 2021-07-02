package com.digitalinnovation.PessoasAPI.service;

import com.digitalinnovation.PessoasAPI.dto.MessageResponseDTO;
import com.digitalinnovation.PessoasAPI.entity.Pessoa;
import com.digitalinnovation.PessoasAPI.repository.repositorioPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class pessoaService {

    private repositorioPessoa repositorioPessoa;

    @Autowired
    public void controllerPessoas(repositorioPessoa repositorioPessoa) {
        this.repositorioPessoa = repositorioPessoa;
    }

    @PostMapping
    public MessageResponseDTO createPessoa(Pessoa pessoa) {
        Pessoa pessoaSalva = repositorioPessoa.save(pessoa);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com id " + pessoaSalva.getId())
                .build();
    }
}
