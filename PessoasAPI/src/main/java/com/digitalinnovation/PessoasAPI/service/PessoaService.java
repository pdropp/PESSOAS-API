package com.digitalinnovation.PessoasAPI.service;

import com.digitalinnovation.PessoasAPI.dto.MessageResponseDTO;
import com.digitalinnovation.PessoasAPI.dto.request.PessoaDTO;
import com.digitalinnovation.PessoasAPI.entity.Pessoa;
import com.digitalinnovation.PessoasAPI.mapper.PessoaMapper;
import com.digitalinnovation.PessoasAPI.repository.repositorioPessoa;
import com.digitalinnovation.PessoasAPI.service.execption.pessoaNaoExiste;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private repositorioPessoa repositorioPessoa;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public  PessoaService(repositorioPessoa repositorioPessoa) {
        this.repositorioPessoa = repositorioPessoa;
    }

    //METODO POST --------------

    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoaSeraSalva = pessoaMapper.toModel(pessoaDTO);

        Pessoa salvoPessoa = repositorioPessoa.save(pessoaSeraSalva);
        return criarMessageResponse(salvoPessoa.getId(), "Pessoa criada com id ");
    }

    //METODO GET --------------

    public List<PessoaDTO> listAll(){
        List<Pessoa> todasPessoas = repositorioPessoa.findAll();
        return todasPessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO findById(Long id) throws pessoaNaoExiste {
        //Melhor forma de fazer a consulta
       /*Pessoa pessoa =  repositorioPessoa.findById(id)
                .orElseThrow(() -> new pessoaNaoExiste(id));*/

       //Segunda forma
       /*  Optional<Pessoa> pessoaOpcinal = repositorioPessoa.findById(id);
        if(pessoaOpcinal.isEmpty()){
            throw new pessoaNaoExiste(id);
        }*/

        Pessoa pessoa = verificarExistencia(id);

        return pessoaMapper.toDTO(pessoa);
    }


    //DELETE --------------
    public void delete(Long id) throws pessoaNaoExiste {
        verificarExistencia(id);
        repositorioPessoa.deleteById(id);
    }


    //PUT --------------
    public MessageResponseDTO atualizarId(Long id, PessoaDTO pessoaDTO) throws pessoaNaoExiste {
        verificarExistencia(id);

        Pessoa atualizarPessoa = pessoaMapper.toModel(pessoaDTO);

        Pessoa salvoPessoa = repositorioPessoa.save(atualizarPessoa);
        return criarMessageResponse(salvoPessoa.getId(), "Id atualizado com sucesso ");
    }

    private MessageResponseDTO criarMessageResponse(Long id, String mensagem) {
        return MessageResponseDTO
                .builder()
                .message(mensagem + id)
                .build();
    }

    //VERIFICAR SE O ID ESTÁ NO BD
    private Pessoa verificarExistencia(Long id) throws pessoaNaoExiste {
        return repositorioPessoa.findById(id)
                .orElseThrow(() -> new pessoaNaoExiste(id));
    }

}
