package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.Entrega;
import br.com.logtech.domain.model.ProdutoNota;
import br.com.logtech.domain.model.Romaneio;
import br.com.logtech.domain.model.dto.CoordenadasDTO;
import br.com.logtech.domain.model.pk.EntregaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntregaRepository extends JpaRepository <Entrega, EntregaPK> {

    List<Entrega> findAllByEntregaPK_Romaneio(Romaneio romaneio);

    @Query("SELECT new br.com.logtech.domain.model.dto.CoordenadasDTO(e.latitude,e.longitude) FROM Entrega AS e WHERE e.entregaPK.romaneio.id = :id")
    List<CoordenadasDTO> findCoordenadasByRomaneio(Long id);
}
