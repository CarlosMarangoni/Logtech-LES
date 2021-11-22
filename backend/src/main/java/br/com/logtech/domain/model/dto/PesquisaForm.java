package br.com.logtech.domain.model.dto;

public class PesquisaForm {

    private Integer notaEntregador;

    private Integer notaAtendimento;

    private Integer notaTempoEntrega;

    private String observacaoPesquisa;

    public PesquisaForm() {
    }

    public Integer getNotaEntregador() {
        return notaEntregador;
    }

    public void setNotaEntregador(Integer notaEntregador) {
        this.notaEntregador = notaEntregador;
    }

    public Integer getNotaAtendimento() {
        return notaAtendimento;
    }

    public void setNotaAtendimento(Integer notaAtendimento) {
        this.notaAtendimento = notaAtendimento;
    }

    public Integer getNotaTempoEntrega() {
        return notaTempoEntrega;
    }

    public void setNotaTempoEntrega(Integer notaTempoEntrega) {
        this.notaTempoEntrega = notaTempoEntrega;
    }

    public String getObservacaoPesquisa() {
        return observacaoPesquisa;
    }

    public void setObservacaoPesquisa(String observacaoPesquisa) {
        this.observacaoPesquisa = observacaoPesquisa;
    }
}
