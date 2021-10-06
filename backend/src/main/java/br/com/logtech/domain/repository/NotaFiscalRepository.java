package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal,Long> {
}
