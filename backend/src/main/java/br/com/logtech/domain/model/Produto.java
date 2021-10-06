package br.com.logtech.domain.model;

import br.com.logtech.domain.model.dto.ProdutoForm;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double peso;

    private Double volume;

    public static Produto toModel(ProdutoForm produtoForm) {
        return new Produto(produtoForm.getDescricao(),
                produtoForm.getPeso(),
                produtoForm.getVolume());
    }

    public Produto(String descricao, Double peso, Double volume) {
        this.descricao = descricao;
        this.peso = peso;
        this.volume = volume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }
}
