package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Cliente;
import br.com.logtech.domain.model.Endereco;
import br.com.logtech.domain.model.NotaFiscal;
import br.com.logtech.domain.model.ProdutoNota;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class NotaFiscalOutput {

    private String numero;

    private Endereco endereco;

    private OffsetDateTime dtEmissao;

    private OffsetDateTime dtVencimento;

    private Cliente cliente;

    private String formaPagamento;

    private String moeda;

    private BigDecimal valor;

    private List<ProdutoNotaOutput> produtos;

    private Integer notaEntregador;

    private Integer notaTempo;

    private Integer notaAtendimento;

    private String observacaoPesquisa;

    public NotaFiscalOutput(String numero, Endereco endereco, OffsetDateTime dtEmissao,
                            OffsetDateTime dtVencimento, Cliente cliente, String formaPagamento, String moeda,
                            BigDecimal valor, List<ProdutoNotaOutput> produtos, Integer notaEntregador, Integer notaTempo,
                            Integer notaAtendimento, String observacaoPesquisa) {
        this.numero = numero;
        this.endereco = endereco;
        this.dtEmissao = dtEmissao;
        this.dtVencimento = dtVencimento;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.moeda = moeda;
        this.valor = valor;
        this.produtos = produtos;
        this.notaEntregador = notaEntregador;
        this.notaTempo = notaTempo;
        this.notaAtendimento = notaAtendimento;
        this.observacaoPesquisa = observacaoPesquisa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public OffsetDateTime getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(OffsetDateTime dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public OffsetDateTime getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(OffsetDateTime dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<ProdutoNotaOutput> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoNotaOutput> produtos) {
        this.produtos = produtos;
    }

    public Integer getNotaEntregador() {
        return notaEntregador;
    }

    public void setNotaEntregador(Integer notaEntregador) {
        this.notaEntregador = notaEntregador;
    }

    public Integer getNotaTempo() {
        return notaTempo;
    }

    public void setNotaTempo(Integer notaTempo) {
        this.notaTempo = notaTempo;
    }

    public Integer getNotaAtendimento() {
        return notaAtendimento;
    }

    public void setNotaAtendimento(Integer notaAtendimento) {
        this.notaAtendimento = notaAtendimento;
    }

    public String getObservacaoPesquisa() {
        return observacaoPesquisa;
    }

    public void setObservacaoPesquisa(String observacaoPesquisa) {
        this.observacaoPesquisa = observacaoPesquisa;
    }

    public static NotaFiscalOutput toOutput(NotaFiscal notaFiscal){
        return new NotaFiscalOutput(notaFiscal.getNumero(),
                notaFiscal.getEndereco(),
                notaFiscal.getDtEmissao(),
                notaFiscal.getDtVencimento(),
                notaFiscal.getCliente(),
                notaFiscal.getFormaPagamento().name(),
                notaFiscal.getMoeda().name(),
                notaFiscal.getValorTotal(),
                notaFiscal.getProdutos().stream().map(ProdutoNotaOutput::toOutput).collect(Collectors.toList()),
                notaFiscal.getNotaEntregador(),
                notaFiscal.getNotaTempoDeEntrega(),
                notaFiscal.getNotaAtendimento(),
                notaFiscal.getObservacaoPesquisa());
    }
}
