package com.natymorgs.backEndSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natymorgs.backEndSpring.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{	

}
