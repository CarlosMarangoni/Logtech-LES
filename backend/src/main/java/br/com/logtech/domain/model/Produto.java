package br.com.logtech.domain.model;

import br.com.logtech.domain.model.dto.ProdutoForm;
import br.com.logtech.domain.model.enumeration.UnidadeMedida;

import javax.persistence.*;
import java.util.Locale;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Double peso;

    private Double volume;

    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;

    public static Produto toModel(ProdutoForm produtoForm) {
        return new Produto(produtoForm.getDescricao(),
                produtoForm.getPeso(),
                produtoForm.getVolume(),
                UnidadeMedida.valueOf(produtoForm.getUnidadeMedida().toUpperCase(Locale.ROOT)));
    }

    public Produto(){

    }

    public Produto(String descricao, Double peso, Double volume,UnidadeMedida unidadeMedida) {
        this.descricao = descricao;
        this.peso = peso;
        this.volume = volume;
        this.unidadeMedida = unidadeMedida;
    }

    public static Produto of(Long idProduto) {
        Produto produto = new Produto();
        produto.setId(idProduto);
        return produto;
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

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
}
