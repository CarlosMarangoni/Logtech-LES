package br.com.logtech.api.controller;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Cliente;
import br.com.logtech.domain.model.dto.ClienteForm;
import br.com.logtech.domain.repository.ClienteRepository;
import br.com.logtech.domain.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Obter todos clientes")
    public ResponseEntity<List<Cliente>> obterClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{clienteId}")
    @Operation(summary = "Obter um cliente")
    public ResponseEntity<Cliente> obterCliente(@PathVariable Long clienteId){
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        return ResponseEntity.ok((cliente));
    }

    @PostMapping
    @Operation(summary = "Cadastrar cliente")
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody ClienteForm clienteForm, UriComponentsBuilder uriComponentsBuilder){
        Cliente cliente = clienteService.cadastrar(clienteForm);

        UriComponents uriComponents = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId());
        var location = uriComponents.toUri();
        return ResponseEntity.created(location).body((cliente));
    }

    @DeleteMapping("/{clienteId}")
    @Operation(summary = "Excluir cliente")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCliente(@PathVariable Long clienteId){
        clienteService.excluir(clienteId);
    }
    
}
