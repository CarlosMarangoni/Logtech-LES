package br.com.logtech.domain.service;

import br.com.logtech.domain.exception.EntradaInvalidaException;
import br.com.logtech.domain.model.Cliente;
import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.Produto;
import br.com.logtech.domain.model.ProdutoNota;
import br.com.logtech.domain.model.dto.NotaFiscalForm;
import br.com.logtech.domain.model.dto.ProdutoForm;
import br.com.logtech.domain.model.enumeration.FormaPagamento;
import br.com.logtech.domain.model.enumeration.Moeda;
import br.com.logtech.domain.model.pk.ProdutoNotaPK;
import br.com.logtech.domain.repository.ClienteRepository;
import br.com.logtech.domain.repository.NotaFiscalRepository;
import br.com.logtech.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public NotaFiscal cadastrar(NotaFiscalForm notaFiscalForm) {
        notaFiscalForm.getProdutos().forEach(p ->{
            Produto produto = produtoRepository.findById(p.getIdProduto())
                    .orElseThrow(() -> new EntradaInvalidaException("Produto de código " + p.getIdProduto() + " não encontrado."));
        });

        NotaFiscal notaFiscal = toModel(notaFiscalForm);
        notaFiscal.setCliente(clienteRepository.findById(notaFiscal.getCliente().getId()).orElseThrow(() -> new EntradaInvalidaException("Cliente de código " + notaFiscal.getCliente().getId() + " não encontrado.")));
        notaFiscal.getProdutos().forEach(p -> {
            p.getProdutoNotaPK().setNotaFiscal(notaFiscal);
            p.getProdutoNotaPK().setProduto(produtoRepository.findById(p.getProdutoNotaPK().getProduto().getId()).get());
        });
        return notaFiscalRepository.save(notaFiscal);
    }

    public NotaFiscal toModel(NotaFiscalForm notaFiscalForm) {
        return new NotaFiscal(
                notaFiscalForm.getNumero(),
                notaFiscalForm.getEndereco(),
                notaFiscalForm.getDtVencimento(),
                Cliente.of(notaFiscalForm.getClienteId()),
                FormaPagamento.valueOf(notaFiscalForm.getFormaPagamento()),
                Moeda.valueOf(notaFiscalForm.getMoeda()),
                notaFiscalForm.getValor(),
                notaFiscalForm.getProdutos().stream().map(p -> {
                    return new ProdutoNota(new ProdutoNotaPK(Produto.of(p.getIdProduto())),p.getQuantidade());
                }).collect(Collectors.toList()));

    }
}
