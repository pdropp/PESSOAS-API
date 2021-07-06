package com.digitalinnovation.PessoasAPI.repository;

import com.digitalinnovation.PessoasAPI.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositorioPessoa extends JpaRepository<Pessoa, Long> {
}
