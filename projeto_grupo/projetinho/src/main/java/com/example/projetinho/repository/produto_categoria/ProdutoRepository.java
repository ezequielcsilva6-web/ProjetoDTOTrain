package com.example.projetinho.repository.produto_categoria;

import com.example.projetinho.entity.pedido_categoria.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByQuantidade(int quantidade);
    Produto findByQuantidade(int quantidade);
    boolean existsByPreco(BigDecimal preco);
    Produto findByPreco(BigDecimal preco);
}
