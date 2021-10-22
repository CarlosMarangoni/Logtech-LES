package br.com.logtech.domain.model;

import br.com.logtech.domain.model.dto.FuncionarioForm;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @CPF
    private String cpf;

    private String cargo;

    private String cnh;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String cargo, String cnh) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.cnh = cnh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public static Funcionario toModel(FuncionarioForm funcionarioForm) {
        return new Funcionario(funcionarioForm.getNome(),
                funcionarioForm.getCpf(),
                funcionarioForm.getCargo(),
                funcionarioForm.getCnh());
    }
}
