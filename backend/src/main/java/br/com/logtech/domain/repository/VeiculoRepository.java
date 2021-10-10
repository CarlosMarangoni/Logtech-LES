package br.com.logtech.domain.repository;

import br.com.logtech.domain.model.Produto;
import br.com.logtech.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {

    Optional<Veiculo> findByPlaca(String placa);
}
