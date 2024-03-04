package com.example.ProjetoPos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ProjetoPos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
