package br.com.logtech.domain.model;

import br.com.logtech.domain.model.dto.NotaFiscalForm;
import br.com.logtech.domain.model.dto.ProdutoForm;
import br.com.logtech.domain.model.enumeration.FormaPagamento;
import br.com.logtech.domain.model.enumeration.Moeda;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    private String endereco;

    @CreationTimestamp
    private OffsetDateTime dtEmissao;

    private OffsetDateTime dtVencimento;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @Enumerated(EnumType.STRING)
    private Moeda moeda;

    private BigDecimal valorTotal;

    private Boolean entregue;

    private Integer notaEntregador;

    @OneToMany
    private List<Estoque> produtos;

    private Integer notaTempoDeEntrega;

    private Integer notaAtendimento;

    private String observacaoPesquisa;

    public NotaFiscal(){

    };

    public NotaFiscal(String numero, String endereco, OffsetDateTime dtVencimento, Cliente cliente,
                      FormaPagamento formaPagamento, Moeda moeda, Boolean entregue, Integer notaEntregador,
                      Integer notaTempoDeEntrega, Integer notaAtendimento, String observacaoPesquisa) {
        this.numero = numero;
        this.endereco = endereco;
        this.dtVencimento = dtVencimento;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.moeda = moeda;
        this.entregue = false;
        this.notaEntregador = notaEntregador;
        this.notaTempoDeEntrega = notaTempoDeEntrega;
        this.notaAtendimento = notaAtendimento;
        this.observacaoPesquisa = observacaoPesquisa;
    }

    public static NotaFiscal toModel(NotaFiscalForm notaFiscalForm) {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public BigDecimal getPrice() {
        return valorTotal;
    }

    public void setPrice(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public Integer getNotaEntregador() {
        return notaEntregador;
    }

    public void setNotaEntregador(Integer notaEntregador) {
        this.notaEntregador = notaEntregador;
    }

    public Integer getNotaTempoDeEntrega() {
        return notaTempoDeEntrega;
    }

    public void setNotaTempoDeEntrega(Integer notaTempoDeEntrega) {
        this.notaTempoDeEntrega = notaTempoDeEntrega;
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
}
