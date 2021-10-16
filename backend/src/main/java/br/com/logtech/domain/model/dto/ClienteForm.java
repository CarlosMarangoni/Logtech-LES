package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Cliente;
import br.com.logtech.domain.model.PessoaFisica;
import br.com.logtech.domain.model.PessoaJuridica;

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

    public ClienteForm(String nome, String documento) {
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


    public static ClienteForm toForm(Cliente cliente){
        if(cliente instanceof PessoaFisica){
            return new ClienteForm(cliente.getNome(),
                    ((PessoaFisica) cliente).getCpf());
        }else
            if (cliente instanceof PessoaJuridica){
                return new ClienteForm(cliente.getNome(),
                        ((PessoaJuridica) cliente).getCnpj());
            }
            throw new RuntimeException("Erro na criação de cliente form");
    }

}
