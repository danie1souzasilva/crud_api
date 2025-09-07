package br.com.crud.crud_api.service;

import br.com.crud.crud_api.Usuario;
import br.com.crud.crud_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public List<Usuario> listarUsuarios(){return usuarioRepository.findAll();}

    public Optional<Usuario> buscarPorId(Long id){return usuarioRepository.findById(id);}

    public Usuario salvar(Usuario usuario) {return usuarioRepository.save(usuario); }

    public void deletar(Long id){usuarioRepository.deleteById(id);}
    }
