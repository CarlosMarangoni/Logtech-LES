package br.com.logtech.domain.service;

import br.com.logtech.domain.model.Usuario;
import br.com.logtech.domain.model.dto.UsuarioForm;
import br.com.logtech.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(UsuarioForm usuarioForm) {
        Usuario usuario = new Usuario(usuarioForm.getNome(),usuarioForm.getEmail(),usuarioForm.getSenha());
        return usuarioRepository.save(usuario);

    }
}
