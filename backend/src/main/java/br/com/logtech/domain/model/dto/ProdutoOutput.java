package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Estoque;
import br.com.logtech.domain.model.Produto;
import br.com.logtech.domain.model.enumeration.UnidadeMedida;

public class ProdutoOutput {

    private String descricao;

    private Double peso;

    private Double volume;

    private Double quantidadeEstoque;

    private UnidadeMedida unidadeMedida;

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

    public ProdutoOutput(String descricao, Double peso, Double volume, Double quantidadeEstoque, UnidadeMedida unidadeMedida) {
        this.descricao = descricao;
        this.peso = peso;
        this.volume = volume;
        this.quantidadeEstoque = quantidadeEstoque;
        this.unidadeMedida = unidadeMedida;
    }

    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public static ProdutoOutput toOutput(Estoque produto){
        return new ProdutoOutput(produto.getProduto().getDescricao(),
                produto.getProduto().getPeso(),
                produto.getProduto().getVolume(),
                produto.getQuantidade(),
                produto.getProduto().getUnidadeMedida());
    }
}
