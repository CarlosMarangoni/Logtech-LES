package br.com.logtech.domain.model;

import br.com.logtech.domain.exception.EntradaInvalidaException;
import br.com.logtech.domain.model.dto.ProdutoNotaForm;
import br.com.logtech.domain.model.pk.ProdutoNotaPK;
import br.com.logtech.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class ProdutoNota {

    @EmbeddedId
    private ProdutoNotaPK produtoNotaPK = new ProdutoNotaPK();

    private Integer quantidade;

    private BigDecimal valorUnitario;

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

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public ProdutoNota toModel(ProdutoNotaForm produtoNotaForm) {
        ProdutoNota produtoNota = new ProdutoNota();
        produtoNota.setQuantidade(produtoNotaForm.getQuantidade());
        produtoNota.setValorUnitario(produtoNotaForm.getValorUnitario());

        return produtoNota;

    }
}

