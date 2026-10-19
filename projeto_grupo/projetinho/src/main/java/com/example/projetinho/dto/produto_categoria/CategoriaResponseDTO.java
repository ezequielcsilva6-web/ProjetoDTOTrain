package com.example.projetinho.dto.produto_categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
}