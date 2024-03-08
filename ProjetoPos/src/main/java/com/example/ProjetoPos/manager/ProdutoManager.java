package com.example.ProjetoPos.manager;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProjetoPos.model.Produto;
import com.example.ProjetoPos.repository.ProdutoRepository;

@Service
public class ProdutoManager {

	private static final Logger logger = LoggerFactory.getLogger(ProdutoManager.class);

	@Autowired
	private ProdutoRepository produtoRepository;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void saveProduto(final Produto produto) throws Exception {
		produtoRepository.save(produto);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Produto findProdutoById(final Long id) throws Exception {
		final Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return produto.get();
		}
		return null;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Produto> findByNomeContainingIgnoreCase(final String termo) throws Exception {
		return produtoRepository.findByNomeContainingIgnoreCase(termo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void deleteProduto(final Produto produto) throws Exception {
		produtoRepository.delete(produto);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Produto> findAll() throws Exception {
		return produtoRepository.findAll();
	}

}
