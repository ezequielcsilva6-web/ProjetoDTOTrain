package com.example.projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteWhatsappResponseDTO {
    private String nome;
    private String email;
    private String telefone;
}
