package com.digitalinnovation.PessoasAPI.service.execption;

import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class pessoaNaoExiste extends Exception {
    public pessoaNaoExiste(Long id) {
        super("O id " + id + " não está no banco de dados");
    }
}
