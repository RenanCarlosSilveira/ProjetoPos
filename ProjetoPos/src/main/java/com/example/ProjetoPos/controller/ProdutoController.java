package com.example.ProjetoPos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
	public class ProdutoController {

		@GetMapping("/produtoList")
		public String produtoList(Model model) {
			model.addAttribute("appName", "PEI");
			return "/pages/produtoList.html";
		}

		@GetMapping("/produtoForm")
		public String produtoForm(Model model) {
	        model.addAttribute("appName", "PEI");
			return "/pages/produtoList.html";
	    }
	}
