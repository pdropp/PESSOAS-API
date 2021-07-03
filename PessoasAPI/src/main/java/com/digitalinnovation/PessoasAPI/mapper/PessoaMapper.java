package com.digitalinnovation.PessoasAPI.mapper;


import com.digitalinnovation.PessoasAPI.dto.request.PessoaDTO;
import com.digitalinnovation.PessoasAPI.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);


    @Mapping(target = "dateBirth", source = "dateBirth", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO pessoaDTO);

    PessoaDTO toDTO(Pessoa pessoa);
}
