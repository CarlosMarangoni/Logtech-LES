package br.com.logtech.domain.service;

import br.com.logtech.domain.exception.JaExisteException;
import br.com.logtech.domain.model.Estoque;
import br.com.logtech.domain.model.Produto;
import br.com.logtech.domain.model.dto.ProdutoForm;
import br.com.logtech.domain.repository.EstoqueRepository;
import br.com.logtech.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Produto cadastrar(ProdutoForm produtoForm) {
        if(produtoRepository.findByDescricao(produtoForm.getDescricao()).isPresent()){
            throw new JaExisteException("Produto já existe");
        }
        Produto produto = Produto.toModel(produtoForm);
        produtoRepository.save(produto);
        Estoque estoque = new Estoque(produto.getId(), produto, 0.0);
        estoqueRepository.save(estoque);

        return produto;
    }
}
