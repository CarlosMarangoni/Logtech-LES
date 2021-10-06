package br.com.logtech.domain.model;

import br.com.logtech.domain.model.enumeration.UnidadeMedida;

import javax.persistence.*;

@Entity
public class Estoque {

    @Id
    private Long id;

    @OneToOne
    private Produto produto;

    private Double quantidade;

    public Estoque() {
    }

    public Estoque(Long id, Produto produto, Double quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }
}
