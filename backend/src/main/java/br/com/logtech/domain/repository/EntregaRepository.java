package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.Entrega;
import br.com.logtech.domain.model.Romaneio;
import br.com.logtech.domain.model.pk.EntregaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntregaRepository extends JpaRepository <Entrega, EntregaPK> {

//    @Query("SELECT e FROM Entrega e WHERE e.entregaPK.romaneio = :id")
    List<Entrega> findAllByEntregaPK_Romaneio(Romaneio romaneio);
}
