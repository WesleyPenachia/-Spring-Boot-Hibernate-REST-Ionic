package com.natymorgs.backEndSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natymorgs.backEndSpring.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{	

}
