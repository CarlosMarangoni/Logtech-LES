package br.com.logtech.api.controller;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Entrega;
import br.com.logtech.domain.model.Romaneio;
import br.com.logtech.domain.model.dto.EntregaOutput;
import br.com.logtech.domain.model.dto.RomaneioForm;
import br.com.logtech.domain.model.dto.RomaneioOutput;
import br.com.logtech.domain.repository.RomaneioRepository;
import br.com.logtech.domain.service.RomaneioService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/romaneios")
public class RomaneioController {

    @Autowired
    private RomaneioRepository romaneioRepository;

    @Autowired
    private RomaneioService romaneioService;

    @GetMapping
    public ResponseEntity<List<RomaneioOutput>> obterRomaneios(){
        List<Romaneio> romaneios = romaneioRepository.findAll();
        return ResponseEntity.ok(romaneios.stream().map(RomaneioOutput::toOutput).collect(Collectors.toList()));
    }

    @GetMapping("/{romaneioId}")
    public ResponseEntity<RomaneioOutput> obterRomaneio(@PathVariable Long romaneioId){
        Romaneio romaneio = romaneioRepository.findById(romaneioId).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        return ResponseEntity.ok(RomaneioOutput.toOutput(romaneio));
    }

    @PostMapping
    public ResponseEntity<RomaneioOutput> cadastrarRomaneio(@RequestBody RomaneioForm romaneioForm, UriComponentsBuilder uriComponentsBuilder){
        Romaneio romaneio = romaneioService.cadastrar(romaneioForm);
        UriComponents uriComponents = uriComponentsBuilder.path("/romaneios/{id}").buildAndExpand(romaneio.getId());
        var location = uriComponents.toUri();
        return ResponseEntity.created(location).body(RomaneioOutput.toOutput(romaneio));
    }

    @PostMapping("/{romaneioId}/{notaId}")
    public ResponseEntity<EntregaOutput> registrarEntrega(@PathVariable Long romaneioId, @PathVariable Long notaId){
        Entrega entrega = romaneioService.entregar(romaneioId,notaId);
        return ResponseEntity.ok(EntregaOutput.toOutput(entrega));
    }

    @DeleteMapping("/{romaneioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirNota(@PathVariable Long romaneioId){
        romaneioRepository.deleteById(romaneioId);
    }

}
