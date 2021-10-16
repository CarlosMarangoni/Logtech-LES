package br.com.logtech.domain.model;

import br.com.logtech.domain.exception.EntradaInvalidaException;
import br.com.logtech.domain.model.dto.ProdutoNotaForm;
import br.com.logtech.domain.model.pk.ProdutoNotaPK;
import br.com.logtech.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProdutoNota {

    @EmbeddedId
    private ProdutoNotaPK produtoNotaPK = new ProdutoNotaPK();

    private Integer quantidade;

    public ProdutoNota() {
    }

    public ProdutoNota(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoNota(ProdutoNotaPK produtoNotaPK, Integer quantidade) {
        this.produtoNotaPK = produtoNotaPK;
        this.quantidade = quantidade;
    }

    public ProdutoNotaPK getProdutoNotaPK() {
        return produtoNotaPK;
    }

    public void setProdutoNotaPK(ProdutoNotaPK produtoNotaPK) {
        this.produtoNotaPK = produtoNotaPK;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoNota toModel(ProdutoNotaForm produtoNotaForm) {
        ProdutoNota produtoNota = new ProdutoNota();
        produtoNota.setQuantidade(produtoNotaForm.getQuantidade());

        return produtoNota;

    }
}

