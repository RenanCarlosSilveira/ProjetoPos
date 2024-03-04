package com.example.ProjetoPos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

	@GetMapping("/usuarioForm")
	public String usuarioForm(final Model model) {
		model.addAttribute("appName", "PEI");
		return "/pages/usuarioForm.html";
	}

		@GetMapping("/usuarioList")
	public String usuarioList(final Model model) {
		model.addAttribute("appName", "PEI");
		return "/pages/usuarioList.html";
	}
}
