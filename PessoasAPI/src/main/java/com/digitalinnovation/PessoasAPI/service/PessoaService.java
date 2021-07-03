package com.digitalinnovation.PessoasAPI.service;

import com.digitalinnovation.PessoasAPI.dto.MessageResponseDTO;
import com.digitalinnovation.PessoasAPI.dto.request.PessoaDTO;
import com.digitalinnovation.PessoasAPI.entity.Pessoa;
import com.digitalinnovation.PessoasAPI.mapper.PessoaMapper;
import com.digitalinnovation.PessoasAPI.repository.repositorioPessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    private repositorioPessoa repositorioPessoa;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public  PessoaService(repositorioPessoa repositorioPessoa) {
        this.repositorioPessoa = repositorioPessoa;
    }

    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoaSeraSalva = pessoaMapper.toModel(pessoaDTO);

        Pessoa salvoPessoa = repositorioPessoa.save(pessoaSeraSalva);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com id " + salvoPessoa.getId())
                .build();
    }
}
