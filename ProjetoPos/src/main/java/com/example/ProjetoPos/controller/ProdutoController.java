package com.example.ProjetoPos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoManager produtoManager;

	@GetMapping("/produtoList")
	public ModelAndView produtoList() throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoList.html");
		final List<Produto> produtoList = this.produtoManager.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}

	@GetMapping("/produtoForm")
	public ModelAndView produtoForm(final Long id) throws Exception {
		final ModelAndView mav = new ModelAndView("/pages/produtoForm.html");
		mav.addObject("areas", Area.values());
		if (id != null) {
			final Produto produto = this.produtoManager.findProdutoById(id);
			mav.addObject("produto", produto);
		} else {
			mav.addObject("produto", new Produto());
		}
		return mav;
	}

	@PostMapping("/produtoSave")
	public ModelAndView produtoSave(final Produto produto, final BindingResult result, final RedirectAttributes attributes)
			throws Exception {
		if (!produto.isValid()) {
			return this.produtoForm(null);
		}
		try {
			this.produtoManager.saveProduto(produto);
			attributes.addFlashAttribute("mensagem", "Projeto salvo com sucesso!");
		} catch (final Exception e) {
			return this.produtoForm(null);
		}
		return this.produtoForm(produto.getId());

	}

	@GetMapping("/produtoDelete")
	public ModelAndView produtoDelete(final Long id) throws Exception {
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
