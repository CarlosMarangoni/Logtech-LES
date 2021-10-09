package br.com.logtech.domain.service;

import br.com.logtech.domain.model.Cliente;
import br.com.logtech.domain.model.dto.ClienteForm;
import br.com.logtech.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(ClienteForm clienteForm) {
        Cliente cliente = Cliente.toModel(clienteForm);
        clienteRepository.save(cliente);
        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
