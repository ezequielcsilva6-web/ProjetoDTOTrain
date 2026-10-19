package com.example.projetinho.repository.cliente_fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FornecedorRepository<FornecedorEntity>
        extends JpaRepository<FornecedorEntity, Long> {

    <FornecedorEntity> Optional<FornecedorEntity> findByEmail(String email);
}