package br.com.logtech.api.controller;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.dto.NotaFiscalForm;
import br.com.logtech.domain.model.dto.NotaFiscalOutput;
import br.com.logtech.domain.repository.NotaFiscalRepository;
import br.com.logtech.domain.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notas")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private NotaFiscalService notaFiscalService;

    @GetMapping
    public ResponseEntity<List<NotaFiscalOutput>> obterNotaFiscal(){
        List<NotaFiscal> notasFiscais = notaFiscalRepository.findAll();
        return ResponseEntity.ok(notasFiscais.stream().map(n -> NotaFiscalOutput.toOutput(n)).collect(Collectors.toList()));
    }

    @GetMapping("/{notaFiscalId}")
    public ResponseEntity<NotaFiscalOutput> obterNotaFiscal(@PathVariable Long notaFiscalId){
        NotaFiscal notaFiscal = notaFiscalRepository.findById(notaFiscalId).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        return ResponseEntity.ok(NotaFiscalOutput.toOutput(notaFiscal));
    }

    @PostMapping
    public ResponseEntity<NotaFiscalOutput> cadastrarNotaFiscal(@RequestBody NotaFiscalForm notaFiscalForm, UriComponentsBuilder uriComponentsBuilder){
        NotaFiscal notaFiscal = notaFiscalService.cadastrar(notaFiscalForm);
        UriComponents uriComponents = uriComponentsBuilder.path("/notas/{id}").buildAndExpand(notaFiscal.getId());
        var location = uriComponents.toUri();
        return ResponseEntity.created(location).body(NotaFiscalOutput.toOutput(notaFiscal));
    }

    @DeleteMapping("/{notaFiscalId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirNota(@PathVariable Long notaFiscalId){
        notaFiscalRepository.deleteById(notaFiscalId);
    }

}
