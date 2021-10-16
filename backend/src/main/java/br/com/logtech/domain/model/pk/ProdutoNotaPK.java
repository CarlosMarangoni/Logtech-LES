package br.com.logtech.domain.model.pk;

import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdutoNotaPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @ManyToOne
    private NotaFiscal notaFiscal;

    @ManyToOne
    private Produto produto;

    public ProdutoNotaPK(NotaFiscal notaFiscal, Produto produto) {
        this.notaFiscal = notaFiscal;
        this.produto = produto;
    }

    public ProdutoNotaPK(Produto produto) {
        this.produto = produto;
    }

    public ProdutoNotaPK() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoNotaPK that = (ProdutoNotaPK) o;
        return produto.equals(that.produto) && notaFiscal.equals(that.notaFiscal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, notaFiscal);
    }
}
