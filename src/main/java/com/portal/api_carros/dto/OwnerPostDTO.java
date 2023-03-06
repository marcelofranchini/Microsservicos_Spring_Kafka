package com.portal.api_carros.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // cria todos os gets e sets
@Builder // permite usar o dto sem todos os atributos
@NoArgsConstructor // // criar um construtor sem argums
@AllArgsConstructor // cria o construtor com todos os argus
@JsonInclude // converte o json para o dto em body
public class OwnerPostDTO {

    // public OwnerPostDTO(String name) { construtor para inst.
    //    this.name = name;
    // }

    //lombok permite acessar atributos privados da classe sem get e set
    // public String getName() {
    //     return name;
    // }

    // public void setName(String name) {
    //    this.name = name;
    // }

    private String name;
    private String type;
    private String contactNumber;


}
