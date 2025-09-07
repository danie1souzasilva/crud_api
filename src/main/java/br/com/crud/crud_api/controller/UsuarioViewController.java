package br.com.crud.crud_api.controller;

import br.com.crud.crud_api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios/view")
public class UsuarioViewController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {model.addAttribute("usuarios", usuarioService.listarUsuarios());return "usuarios";
    }
}
