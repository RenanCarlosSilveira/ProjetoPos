package com.example.ProjetoPos.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ProjetoPos.manager.ProdutoManager;
import com.example.ProjetoPos.model.Produto;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoManager produtoManager;

	@GetMapping("/produtoList")
	public ModelAndView produtoList() throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList.html");
		final List<Produto> produtoList = produtoManager.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}

	@GetMapping("/produtoForm")
	public ModelAndView produtoForm(final Long id) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoForm.html");
		if (id != null) {
			final Produto produto = produtoManager.findProdutoById(id);
			if (produto.getImagem() != null) {
				mav.addObject("pic",
						Base64.getEncoder().encodeToString(produto.getImagem().getBinaryStream().readAllBytes()));
			}
			mav.addObject("produto", produto);
		} else {
			mav.addObject("pic", "");
			mav.addObject("produto", new Produto());
		}
		return mav;
	}

	@GetMapping("/produtoDelete")
	public ModelAndView produtoDelete(final Long id) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList.html");
		final Produto produto = produtoManager.findProdutoById(id);
		if (produto != null) {
			produtoManager.deleteProduto(produto);
		}
		final List<Produto> produtoList = produtoManager.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}

	@GetMapping("/produtoBusca")
	public ModelAndView produtoBusca(final String termo) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList.html");
		final Produto produto = produtoManager.findProdutoById(1l);
		if (produto != null) {
			produtoManager.deleteProduto(produto);
		}
		final List<Produto> produtoList = produtoManager.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}
}
