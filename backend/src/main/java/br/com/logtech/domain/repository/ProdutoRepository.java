package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Optional<Produto> findByDescricao(String descricao);
}
