package br.com.logtech.domain.model;

import javax.persistence.Entity;


public class Motorista extends Funcionario{

    private String cnh;

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
