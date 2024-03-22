package com.example.ProjetoPos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProjetoPos.manager.UsuarioManager;
import com.example.ProjetoPos.model.Usuario;

@Controller
@RequestMapping("/registros")
public class RegistroController {

	@Autowired
	UsuarioManager usuariomanager;

	@GetMapping("/registro")
	public String login(@ModelAttribute Usuario usuario, Model model) {
		model.addAttribute("usuario", usuario);
		return "/pages/registro";
	}


	@PostMapping("/salvar")
	public String salvar(@ModelAttribute Usuario usuario, ModelMap model, BindingResult result) {
		model.addAttribute("usuario", usuario);
		try {
			usuariomanager.salvarUsuario(usuario);
			model.addAttribute("alerta", " ");
			model.addAttribute("titulo", "Usuário Cadastrado!");
			model.addAttribute("texto", " ");
			model.addAttribute("subtexto", "Seu acesso está diponível, retorne à página de login.");
			return "registro";
		} catch (final Exception e) {
			model.addAttribute("alerta", "erro");
			model.addAttribute("titulo", "Usuario existente!");
			model.addAttribute("texto", "Digite informações diferentes!");
			model.addAttribute("subtexto", "");
			return "registro";
		}
	}

}