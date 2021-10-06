package br.com.logtech.domain.model.enumeration;

public enum FormaPagamento {

    CREDITO("Credito"),
    DINHEIRO("Dinheiro"),
    DEBITO("Debito");

    private String nome;

    FormaPagamento(String nome) {
        this.nome = nome;
    }
}
