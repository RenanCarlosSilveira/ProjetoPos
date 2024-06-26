package com.example.ProjetoPos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@GetMapping("/usuarioForm")
	public String usuarioForm(final Model model) {
		return "/pages/usuarioForm";
	}

	@GetMapping("/usuarioList")
	public String usuarioList(final Model model) {
		return "/pages/usuarioList";
	}
}
