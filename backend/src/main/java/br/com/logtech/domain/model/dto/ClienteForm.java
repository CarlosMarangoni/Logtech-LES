package br.com.logtech.domain.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteForm {

    @NotNull
    private String tipoPessoa;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String documento;

    public ClienteForm() {
    }

    public ClienteForm(String tipoPessoa, String nome,String documento) {
        this.tipoPessoa = tipoPessoa;
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

}
