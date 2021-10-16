package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.ProdutoNota;

public class ProdutoNotaOutput {

    private String nome;

    private Integer quantidade;

    public ProdutoNotaOutput() {
    }

    public ProdutoNotaOutput(String nome, Integer quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public static ProdutoNotaOutput toOutput(ProdutoNota produtoNota){
        return new ProdutoNotaOutput(produtoNota.getProdutoNotaPK().getProduto().getDescricao(),
                produtoNota.getQuantidade());
    }
}
