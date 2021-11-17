package br.com.logtech.api.controller;

import br.com.logtech.domain.exception.PageNotFoundException;
import br.com.logtech.domain.model.Usuario;
import br.com.logtech.domain.model.dto.UsuarioForm;
import br.com.logtech.domain.model.dto.UsuarioOutput;
import br.com.logtech.domain.repository.UsuarioRepository;
import br.com.logtech.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioOutput> getUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new PageNotFoundException("Página não encontrada."));
        return ResponseEntity.ok().body(UsuarioOutput.toOutput(usuario));

    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> addUsuario(@Valid @RequestBody UsuarioForm usuarioForm, UriComponentsBuilder uriComponentsBuilder){
        Usuario createdUsuario = usuarioService.save(usuarioForm);
        UriComponents uriComponents = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(createdUsuario.getId());
        var location = uriComponents.toUri();
        return ResponseEntity.created(location).body(createdUsuario);

    }
}
