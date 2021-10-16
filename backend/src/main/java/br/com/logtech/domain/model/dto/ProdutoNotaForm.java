package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.ProdutoNota;

public class ProdutoNotaForm {

    private Long idProduto;

    private Integer quantidade;

    public ProdutoNotaForm() {
    }

    public ProdutoNotaForm(Long idProduto, Integer quantidade) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public static ProdutoNotaForm toForm(ProdutoNota produtoNota){
        return new ProdutoNotaForm(produtoNota.getProdutoNotaPK().getProduto().getId(),
                produtoNota.getQuantidade());
    }
}
