package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Produto;
import br.com.logtech.domain.model.enumeration.UnidadeMedida;

public class ProdutoForm {

    private String descricao;

    private Double peso;

    private Double volume;

    private String unidadeMedida;

    public ProdutoForm(String descricao, Double peso, Double volume,String unidadeMedida) {
        this.descricao = descricao;
        this.peso = peso;
        this.volume = volume;
        this.unidadeMedida = unidadeMedida;
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

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public static ProdutoForm toForm(Produto produto){
        return new ProdutoForm(produto.getDescricao(),
                produto.getPeso(),
                produto.getVolume(),
                produto.getUnidadeMedida().name());
    }
}
