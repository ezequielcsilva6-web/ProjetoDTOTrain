package com.example.projetinho.repository.cliente_fornecedor;

import com.example.projetinho.entity.cliente_fornecedor.ClienteEntity;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByEmail(String email);
}