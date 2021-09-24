package com.natymorgs.backEndSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natymorgs.backEndSpring.domain.Pedido;
import com.natymorgs.backEndSpring.repositories.PedidoRepository;
import com.natymorgs.backEndSpring.services.exceptions.ObjecNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) { 
		 Optional<Pedido> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjecNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		} 
}
