package com.digitalinnovation.PessoasAPI.entity;

import com.digitalinnovation.PessoasAPI.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity//Informa que a classe telefone é uma entidade no banco de dados
@Data //adiciona o getter e o setter automáticamente
@Builder// padrão de projeto
@AllArgsConstructor //Insere construtores
@NoArgsConstructor //Insere construtores
public class Telefone {

    @Id //Definir ID como principal key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Toda vez que inserir um dado automáticamente ele incrementa
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)//Ao informar esse dado na API, ele será obrigatório
    private PhoneType type;

    @Column(nullable = false)
    private String number;


}
