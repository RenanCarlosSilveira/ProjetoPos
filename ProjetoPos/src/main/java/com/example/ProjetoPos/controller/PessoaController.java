package com.example.ProjetoPos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@GetMapping("/pessoaForm")
	public String pessoaForm(final Model model) {
		return "/pages/pessoaForm";
	}

	@GetMapping("/pessoaList")
	public String pessoaList(final Model model) {
		return "/pages/pessoaList";
	}
}

