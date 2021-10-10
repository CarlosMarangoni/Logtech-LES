package br.com.logtech.api.controller;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Veiculo;
import br.com.logtech.domain.model.dto.VeiculoForm;
import br.com.logtech.domain.repository.VeiculoRepository;
import br.com.logtech.domain.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> obterVeiculos(){
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return ResponseEntity.ok(veiculos);
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<Veiculo> obterVeiculo(@PathVariable Long veiculoId){
        Veiculo veiculo = veiculoRepository.findById(veiculoId).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        return ResponseEntity.ok((veiculo));
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@Valid @RequestBody VeiculoForm veiculoForm, UriComponentsBuilder uriComponentsBuilder){
        Veiculo veiculo = veiculoService.cadastrar(veiculoForm);
        UriComponents uriComponents = uriComponentsBuilder.path("/veiculos/{id}").buildAndExpand(veiculo.getId());
        var location = uriComponents.toUri();
        return ResponseEntity.created(location).body((veiculo));
    }

    @DeleteMapping("/{veiculoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirVeiculo(@PathVariable Long veiculoId){
        veiculoService.excluir(veiculoId);
    }
}
