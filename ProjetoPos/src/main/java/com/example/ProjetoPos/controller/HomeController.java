package com.example.ProjetoPos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping("/homeForm")
	public ModelAndView novo(final Model model) {
		final ModelAndView mv = new ModelAndView("/pages/home.html");
		mv.addObject("PAR1", "AQUI");
		return mv;
	}
}
