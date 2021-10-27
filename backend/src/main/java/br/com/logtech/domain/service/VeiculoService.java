package br.com.logtech.domain.service;

import br.com.logtech.domain.exception.JaExisteException;
import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Veiculo;
import br.com.logtech.domain.model.dto.VeiculoForm;
import br.com.logtech.domain.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository  veiculoRepository;

    public Veiculo cadastrar(VeiculoForm veiculoForm) {
        if(veiculoRepository.findByPlaca(veiculoForm.getPlaca()).isPresent()){
            throw new JaExisteException("Veículo já existe");
        }
        Veiculo veiculo = Veiculo.toModel(veiculoForm);
        return veiculoRepository.save(veiculo);
    }

    public void excluir(Long veiculoId) {
        veiculoRepository.deleteById(veiculoId);
    }

    public void liberar(Long veiculoId) {
        Veiculo veiculo = veiculoRepository.findById(veiculoId).orElseThrow(() -> new PageNotFoundException("Pagina nao encontrada."));
        veiculo.setDisponivel(Boolean.TRUE);
        veiculoRepository.save(veiculo);
    }
}
