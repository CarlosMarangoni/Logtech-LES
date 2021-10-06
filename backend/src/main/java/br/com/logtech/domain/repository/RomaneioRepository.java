package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.Produto;
import br.com.logtech.domain.model.Romaneio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RomaneioRepository extends JpaRepository<Romaneio,Long> {
}
