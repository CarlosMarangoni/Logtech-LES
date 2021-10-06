package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Produto;

public class ProdutoOutput {

    private String descricao;

    private Double peso;

    private Double volume;

    public ProdutoOutput(String descricao, Double peso, Double volume) {
        this.descricao = descricao;
        this.peso = peso;
        this.volume = volume;
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

    public static ProdutoOutput toOutput(Produto produto){
        return new ProdutoOutput(produto.getDescricao(),
                produto.getPeso(),
                produto.getVolume());
    }
}
