package br.com.logtech.domain.service;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Funcionario;
import br.com.logtech.domain.model.dto.FuncionarioForm;
import br.com.logtech.domain.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;



    public Funcionario cadastrar(FuncionarioForm funcionarioForm) {
        Funcionario funcionario = Funcionario.toModel(funcionarioForm);
        return funcionarioRepository.save(funcionario);
    }

    public void liberar(Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(() -> new PageNotFoundException("Pagina nao encontrada"));
        funcionario.setDisponivel(Boolean.TRUE);
        funcionarioRepository.save(funcionario);
    }

    public void excluir(Long funcionarioId) {
        funcionarioRepository.deleteById(funcionarioId);
    }
}
