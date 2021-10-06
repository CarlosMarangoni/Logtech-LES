package br.com.logtech.domain.service;

import br.com.logtech.domain.model.Produto;
import br.com.logtech.domain.model.dto.ProdutoForm;
import br.com.logtech.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrar(ProdutoForm produtoForm) {
        Produto produto = Produto.toModel(produtoForm);
        produtoRepository.save(produto);
    }
}
