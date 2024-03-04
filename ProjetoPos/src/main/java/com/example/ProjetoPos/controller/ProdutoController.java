package com.example.ProjetoPos.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.ProjetoPos.manager.ProdutoManager;
import com.example.ProjetoPos.model.Area;
import com.example.ProjetoPos.model.Produto;

@Controller
public class ProdutoController {

	@Autowired private ProdutoManager produtoManager;

	@GetMapping("/produtoList")
	public String produtoList(final Model model) throws Exception {
		model.addAttribute("appName", "PEI");
		final List<Produto> produtoList = this.produtoManager.findAll();
		model.addAttribute("produtoList", produtoList);
		return "/pages/produtoList.html";
	}

	@GetMapping("/produtoForm")
	public String produtoForm(final Model model) throws Exception {
		model.addAttribute("appName", "PEI");
		final Produto produto = new Produto("PROD1", new BigDecimal(1), Area.AUTO, 10l);
		this.produtoManager.saveProduto(produto);
		return "/pages/produtoForm.html";
	}
}
