package com.example.ProjetoPos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ProjetoPos.manager.ProdutoManager;
import com.example.ProjetoPos.model.Produto;

@Controller
@RequestMapping("/market")
public class MarketController {

	@Autowired private ProdutoManager produtoManager;

	@GetMapping("/marketList")
	public ModelAndView marketList(final Model model) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/marketList");
		final List<Produto> produtoList = produtoManager.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}
}
