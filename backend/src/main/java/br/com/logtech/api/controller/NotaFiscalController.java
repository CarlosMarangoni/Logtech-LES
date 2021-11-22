package br.com.logtech.api.controller;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Cliente;
import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.dto.NotaFiscalForm;
import br.com.logtech.domain.model.dto.NotaFiscalOutput;
import br.com.logtech.domain.model.dto.PesquisaForm;
import br.com.logtech.domain.repository.ClienteRepository;
import br.com.logtech.domain.repository.NotaFiscalRepository;
import br.com.logtech.domain.service.NotaFiscalService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    @Operation(summary = "Obter todas notas fiscais")
    public ResponseEntity<List<NotaFiscalOutput>> obterNotaFiscal(){
        List<NotaFiscal> notasFiscais = notaFiscalRepository.findAll();
        return ResponseEntity.ok(notasFiscais.stream().map(n -> NotaFiscalOutput.toOutput(n)).collect(Collectors.toList()));
    }

    @GetMapping("/{notaFiscalId}")
    @Operation(summary = "Obter uma nota fiscal")
    public ResponseEntity<NotaFiscalOutput> obterNotaFiscal(@PathVariable Long notaFiscalId){
        NotaFiscal notaFiscal = notaFiscalRepository.findById(notaFiscalId).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        return ResponseEntity.ok(NotaFiscalOutput.toOutput(notaFiscal));
    }

    @PostMapping
    @Operation(summary = "Cadastrar nota fiscal")
    public ResponseEntity<NotaFiscalOutput> cadastrarNotaFiscal(@RequestBody NotaFiscalForm notaFiscalForm, UriComponentsBuilder uriComponentsBuilder){
        NotaFiscal notaFiscal = notaFiscalService.cadastrar(notaFiscalForm);
        UriComponents uriComponents = uriComponentsBuilder.path("/notas/{id}").buildAndExpand(notaFiscal.getId());
        var location = uriComponents.toUri();
        return ResponseEntity.created(location).body(NotaFiscalOutput.toOutput(notaFiscal));
    }

    @PostMapping("/{numeroNotaFiscal}/{clienteId}")
    @Operation(summary = "Cadastrar nota fiscal")
    public ResponseEntity<NotaFiscalOutput> pesquisaSatisfacao(@RequestBody PesquisaForm pesquisaForm,
                                                               @PathVariable String numeroNotaFiscal,
                                                               @PathVariable Long clienteId){
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        NotaFiscal notaFiscal = notaFiscalRepository.findByNumeroNotaAndCliente(numeroNotaFiscal,cliente).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        notaFiscal.setNotaTempoDeEntrega(pesquisaForm.getNotaTempoEntrega());
        notaFiscal.setNotaEntregador(pesquisaForm.getNotaEntregador());
        notaFiscal.setNotaAtendimento(pesquisaForm.getNotaAtendimento());
        notaFiscal.setObservacaoPesquisa(pesquisaForm.getObservacaoPesquisa());
        notaFiscalRepository.save(notaFiscal);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{notaFiscalId}")
    @Operation(summary = "Excluir nota fiscal")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirNota(@PathVariable Long notaFiscalId){
        notaFiscalRepository.deleteById(notaFiscalId);
    }

}
