package br.com.logtech.api.controller;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Entrega;
import br.com.logtech.domain.model.Romaneio;
import br.com.logtech.domain.model.dto.CoordenadasDTO;
import br.com.logtech.domain.model.dto.EntregaOutput;
import br.com.logtech.domain.model.dto.RomaneioForm;
import br.com.logtech.domain.model.dto.RomaneioOutput;
import br.com.logtech.domain.repository.EntregaRepository;
import br.com.logtech.domain.repository.RomaneioRepository;
import br.com.logtech.domain.service.RomaneioService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Autowired
    private EntregaRepository entregaRepository;

    @GetMapping
    @Operation(summary = "Obter todos romaneios")
    public ResponseEntity<List<RomaneioOutput>> obterRomaneios(){
        List<Romaneio> romaneios = romaneioRepository.findAll();
        return ResponseEntity.ok(romaneios.stream().map(RomaneioOutput::toOutput).collect(Collectors.toList()));
    }

    @GetMapping("/{romaneioId}")
    @Operation(summary = "Obter um romaneio")
    public ResponseEntity<RomaneioOutput> obterRomaneio(@PathVariable Long romaneioId){
        Romaneio romaneio = romaneioRepository.findById(romaneioId).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        return ResponseEntity.ok(RomaneioOutput.toOutput(romaneio));
    }

    @PostMapping
    @Operation(summary = "Cadastrar romaneio")
    public ResponseEntity<RomaneioOutput> cadastrarRomaneio(@RequestBody RomaneioForm romaneioForm, UriComponentsBuilder uriComponentsBuilder){
        Romaneio romaneio = romaneioService.cadastrar(romaneioForm);
        UriComponents uriComponents = uriComponentsBuilder.path("/romaneios/{id}").buildAndExpand(romaneio.getId());
        var location = uriComponents.toUri();
        return ResponseEntity.created(location).body(RomaneioOutput.toOutput(romaneio));
    }

    @PostMapping("/{romaneioId}/notas/{notaId}")
    @Operation(summary = "Registrar entrega")
    public ResponseEntity<EntregaOutput> registrarEntrega(@PathVariable Long romaneioId, @PathVariable Long notaId){
        Entrega entrega = romaneioService.entregar(romaneioId,notaId);
        return ResponseEntity.ok(EntregaOutput.toOutput(entrega));
    }

    @GetMapping("/coordenadas/{romaneioId}")
    @Operation(summary = "Obter coordenadas de notas do romaneio")
    public ResponseEntity<List<CoordenadasDTO>> obterCoordenadas(@PathVariable Long romaneioId){
        List<CoordenadasDTO> coordenadas = entregaRepository.findCoordenadasByRomaneio(romaneioId);
        return ResponseEntity.ok().body(coordenadas);
    }


    @DeleteMapping("/{romaneioId}")
    @Operation(summary = "Excluir romaneio")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirNota(@PathVariable Long romaneioId){
        romaneioRepository.deleteById(romaneioId);
    }

}
