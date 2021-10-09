package br.com.logtech.domain.model;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("juridica")
public class PessoaJuridica extends Cliente{

    @CNPJ
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica() {
    }

    public PessoaJuridica(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }
}
