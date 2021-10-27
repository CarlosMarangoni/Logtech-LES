package br.com.logtech.api.controller;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Funcionario;
import br.com.logtech.domain.model.dto.FuncionarioForm;
import br.com.logtech.domain.repository.FuncionarioRepository;
import br.com.logtech.domain.service.FuncionarioService;
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
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    @Operation(summary = "Obter todos funcionarios")
    public ResponseEntity<List<Funcionario>> obterFuncionarios(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{funcionarioId}")
    @Operation(summary = "Obter um funcionario")
    public ResponseEntity<Funcionario> obterFuncionario(@PathVariable Long funcionarioId){
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        return ResponseEntity.ok((funcionario));
    }

    @PostMapping
    @Operation(summary = "Cadastrar funcionario")
    public ResponseEntity<Funcionario> cadastrarFuncionario(@Valid @RequestBody FuncionarioForm funcionarioForm, UriComponentsBuilder uriComponentsBuilder){
        Funcionario funcionario = funcionarioService.cadastrar(funcionarioForm);
        UriComponents uriComponents = uriComponentsBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId());
        var location = uriComponents.toUri();
        return ResponseEntity.created(location).body((funcionario));
    }

    @PutMapping("{funcionarioId}/liberar")
    @Operation(summary = "Liberar motorista que está ocupado após entregar todas as notas do Romaneio")
    public void liberarMotorista(@PathVariable Long funcionarioId){
        funcionarioService.liberar(funcionarioId);
    }

    @DeleteMapping("/{funcionarioId}")
    @Operation(summary = "Excluir funcionario")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirFuncionario(@PathVariable Long funcionarioId){
        funcionarioService.excluir(funcionarioId);
    }
    
}
