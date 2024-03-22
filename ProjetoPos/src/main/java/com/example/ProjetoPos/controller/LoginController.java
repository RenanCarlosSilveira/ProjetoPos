package com.example.ProjetoPos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@GetMapping("/login")
	public ModelAndView login(final Model model) {
		final ModelAndView mv = new ModelAndView("/pages/login");
		return mv;
	}
	
	@GetMapping("/login-error")
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Informações inválidas!");
		model.addAttribute("texto", "Dados incorretos, tente novamente!");
		model.addAttribute("subtexto", "");
		return "login";
	}
}