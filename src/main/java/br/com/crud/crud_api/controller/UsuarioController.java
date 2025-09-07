package br.com.crud.crud_api.controller;

import br.com.crud.crud_api.Usuario;
import br.com.crud.crud_api.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {this.usuarioService = usuarioService;}

    @GetMapping
    public List<Usuario> listarUsuarios(){return usuarioService.listarUsuarios();}

    @GetMapping("/id")
    public ResponseEntity <Usuario> buscarPorId(@PathVariable Long id){return usuarioService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario){return usuarioService.salvar(usuario);}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){return usuarioService.buscarPorId(id).map(u -> {usuarioService.deletar(id); return ResponseEntity.noContent().<Void>build();
    }).orElse(ResponseEntity.notFound().build());}

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario)
    {return usuarioService.buscarPorId(id).map(u -> {usuario.setId(id); return ResponseEntity.ok(usuarioService.salvar(usuario));
    }).orElse(ResponseEntity.notFound().build());}
}
