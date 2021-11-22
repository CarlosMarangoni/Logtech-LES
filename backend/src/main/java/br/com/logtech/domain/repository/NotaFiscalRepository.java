package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.Cliente;
import br.com.logtech.domain.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal,Long> {

    Optional<NotaFiscal> findByNumeroNotaAndCliente(String numero, Cliente cliente);

}
