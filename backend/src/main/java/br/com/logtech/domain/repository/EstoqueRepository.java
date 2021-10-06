package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.Estoque;
import br.com.logtech.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque,Long> {
}
