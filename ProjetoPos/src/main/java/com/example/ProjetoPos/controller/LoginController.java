package com.example.ProjetoPos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ProjetoPos.manager.UsuarioManager;

@Controller
@RequestMapping("/entrar")
public class LoginController {

	@Autowired
	UsuarioManager usuarioManager;

	@GetMapping("/logar")
	public ModelAndView logar(final Model model) {
		final ModelAndView mv = new ModelAndView("/pages/login");
		return mv;
	}

	@PostMapping("/auth")
	public ModelAndView auth(@RequestParam("username") String username, @RequestParam("password") String password) {
		try {
			if (usuarioManager.autenticarUsuario(username, password) == true) {
				final ModelAndView mv = new ModelAndView("/pages/home");
				return mv;
			} else {
				final ModelAndView mv = new ModelAndView("/pages/login");
				return mv;
			}
		} catch (final Exception e) {
			final ModelAndView mv = new ModelAndView("/pages/login");
			return mv;
		}
	}

}