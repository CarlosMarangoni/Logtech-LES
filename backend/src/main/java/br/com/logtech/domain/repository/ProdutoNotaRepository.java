package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.ProdutoNota;
import br.com.logtech.domain.model.pk.ProdutoNotaPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoNotaRepository extends JpaRepository<ProdutoNota, ProdutoNotaPK> {

    List<ProdutoNota> findAllByProdutoNotaPK_NotaFiscal(NotaFiscal notaFiscal);
}
