package com.example.projetinho.repository.produto_categoria;

import com.example.projetinho.entity.pedido_categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsByNome(String nome);
    Categoria findByNome(String nome);

}
