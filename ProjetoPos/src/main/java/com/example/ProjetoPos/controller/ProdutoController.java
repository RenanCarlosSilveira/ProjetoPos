package com.example.ProjetoPos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ProjetoPos.manager.ProdutoManager;
import com.example.ProjetoPos.model.Area;
import com.example.ProjetoPos.model.Produto;
import com.example.ProjetoPos.model.dto.ProdutoDTO;

import io.micrometer.common.util.StringUtils;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoManager produtoManager;

	@GetMapping("/produtoList")
	public ModelAndView produtoList() throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList");
		mav.addObject("produtoList", produtoManager.findAll());
		return mav;
	}

	@GetMapping("/produtoForm")
	public ModelAndView produtoForm(final Long id) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoForm");
		mav.addObject("areas", Area.values());
		if (id != null) {
			final Produto produto = produtoManager.findProdutoById(id);
			mav.addObject("produtoDTO", new ProdutoDTO(produto));
		} else {
			mav.addObject("produtoDTO", new ProdutoDTO());
		}
		return mav;
	}

	@PostMapping("/produtoSave")
	public ModelAndView produtoSave(final ProdutoDTO produtoDTO, final BindingResult result,
			final RedirectAttributes attributes) throws Exception {
		ModelAndView mav;
		if (!produtoDTO.isValid()) {
			mav = new ModelAndView("/pages/produtoForm");
			mav.addObject("error", "Verifique as informacoes!");
		}
		try {
			mav = new ModelAndView("/pages/produtoList");
			final Produto produto = new Produto(produtoDTO);
			produtoManager.saveProduto(produto);
			mav.addObject("produtoList", produtoManager.findAll());
			mav.addObject("message", "Produto salvo com sucesso!");
		} catch (final Exception e) {
			mav = new ModelAndView("/pages/produtoForm");
			mav.addObject("error", "Ocorreu um erro!");
		}
		return mav;
	}

	@PostMapping("/produtoDelete")
	public ModelAndView produtoDelete(final Long id) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList");
		final Produto produto = produtoManager.findProdutoById(id);
		if (produto != null) {
			produtoManager.deleteProduto(produto);
			mav.addObject("message", "Deletado!");
		}
		final List<Produto> produtoList = produtoManager.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}

	@RequestMapping("/produtoBusca")
	public ModelAndView produtoBusca(@Param("termo") String termo) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList");
		List<Produto> produtoList = new ArrayList<>();
		if (!StringUtils.isEmpty(termo)) {
			produtoList = produtoManager.findByNomeContainingIgnoreCase(termo);
		} else {
			produtoList = produtoManager.findAll();
		}
		mav.addObject("produtoList", produtoList);
		return mav;
	}
}
