package com.example.ProjetoPos.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.ProjetoPos.manager.ProdutoManager;
import com.example.ProjetoPos.model.Area;
import com.example.ProjetoPos.model.Produto;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired private ProdutoManager produtoManager;

	@GetMapping("/produtoList")
	public ModelAndView produtoList() throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList.html");
		final List<Produto> produtoList = this.produtoManager.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}

	@GetMapping("/produtoForm")
	public String produtoForm(final Model model) throws Exception {
		final Produto produto = new Produto("PROD1", new BigDecimal(1), Area.AUTO, 10l);
		this.produtoManager.saveProduto(produto);
		return "/pages/produtoForm.html";
	}

	@GetMapping("/produtoDelete")
	public ModelAndView produtoForm(final Long id) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList.html");
		final Produto produto = this.produtoManager.findProdutoById(id);
		if (produto != null) {
			this.produtoManager.deleteProduto(produto);
		}
		final List<Produto> produtoList = this.produtoManager.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}

	@GetMapping("/produtoBusca")
	public ModelAndView produtoBusca(final String termo) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList.html");
		final Produto produto = this.produtoManager.findProdutoById(1l);
		if (produto != null) {
			this.produtoManager.deleteProduto(produto);
		}
		final List<Produto> produtoList = this.produtoManager.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}
}
