package br.com.logtech.domain.model.dto;

import org.hibernate.validator.constraints.br.CPF;

public class FuncionarioForm {

    private String nome;

    @CPF
    private String cpf;

    private String cargo;

    private String cnh;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
