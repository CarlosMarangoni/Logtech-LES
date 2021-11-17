package br.com.logtech.domain.model.dto;

import br.com.logtech.domain.model.Usuario;

public class UsuarioOutput {

    private String email;

    private String nome;

    public UsuarioOutput(String email,String nome) {
        this.email = email;
        this.nome = nome;
    }

    public static UsuarioOutput toOutput(Usuario usuario) {
        return new UsuarioOutput(usuario.getEmail(),usuario.getNome());
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String email) {
        this.email = email;
    }
}
