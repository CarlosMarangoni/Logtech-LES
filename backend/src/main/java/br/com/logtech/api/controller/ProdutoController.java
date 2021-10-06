package br.com.logtech.api.controller;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Produto;
import br.com.logtech.domain.model.dto.ProdutoForm;
import br.com.logtech.domain.model.dto.ProdutoOutput;
import br.com.logtech.domain.repository.ProdutoRepository;
import br.com.logtech.domain.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoOutput>> obterProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok(produtos.stream().map(p -> ProdutoOutput.toOutput(p)).collect(Collectors.toList()));
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoOutput> obterProduto(@PathVariable Long produtoId){
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        return ResponseEntity.ok(ProdutoOutput.toOutput(produto));
    }

    @PostMapping
    public ResponseEntity<ProdutoOutput> cadastrarProduto(@RequestBody ProdutoForm produtoForm, UriComponentsBuilder uriComponentsBuilder){
        Produto produto = produtoService.cadastrar(produtoForm);
        UriComponents uriComponents = uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.getId());
        var location = uriComponents.toUri();
        return ResponseEntity.created(location).body(ProdutoOutput.toOutput(produto));
    }

    @DeleteMapping("/{produtoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirProduto(@PathVariable Long produtoId){
       produtoRepository.deleteById(produtoId);
    }

}
