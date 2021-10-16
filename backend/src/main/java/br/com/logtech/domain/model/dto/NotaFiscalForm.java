package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.ProdutoNota;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public class NotaFiscalForm {

    private String numero;

    private String endereco;

    private OffsetDateTime dtVencimento;

    private Long clienteId;

    private String formaPagamento;

    private String moeda;

    private List<ProdutoNotaForm> produtos;

    private BigDecimal valor;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public OffsetDateTime getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(OffsetDateTime dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public List<ProdutoNotaForm> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoNotaForm> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
