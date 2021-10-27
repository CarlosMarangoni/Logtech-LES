package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.Romaneio;
import br.com.logtech.domain.model.dto.CoordenadasDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RomaneioRepository extends JpaRepository<Romaneio,Long> {


}
