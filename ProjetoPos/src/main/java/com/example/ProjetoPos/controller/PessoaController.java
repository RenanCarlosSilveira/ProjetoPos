package com.example.ProjetoPos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PessoaController {

	@GetMapping("/pessoaForm")
	public String pessoaForm(final Model model) {
		model.addAttribute("appName", "PEI");
		return "/pages/pessoaForm.html";
	}

	@GetMapping("/pessoaList")
	public String pessoaList(final Model model) {
		model.addAttribute("appName", "PEI");
		return "/pages/pessoaList.html";
	}
}

