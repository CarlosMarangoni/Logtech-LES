package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.ProdutoNota;

import java.math.BigDecimal;

public class ProdutoNotaForm {

    private Long idProduto;

    private Integer quantidade;

    private BigDecimal valorUnitario;

    public ProdutoNotaForm() {
    }

    public ProdutoNotaForm(Long idProduto, Integer quantidade,BigDecimal valorUnitario) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
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

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public static ProdutoNotaForm toForm(ProdutoNota produtoNota){
        return new ProdutoNotaForm(produtoNota.getProdutoNotaPK().getProduto().getId(),
                produtoNota.getQuantidade(),
                produtoNota.getValorUnitario());
    }
}
