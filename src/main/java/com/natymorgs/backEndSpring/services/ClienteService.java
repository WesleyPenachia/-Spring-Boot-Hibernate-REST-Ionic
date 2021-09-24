package com.natymorgs.backEndSpring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natymorgs.backEndSpring.domain.Cliente;
import com.natymorgs.backEndSpring.repositories.ClienteRepository;
import com.natymorgs.backEndSpring.services.exceptions.ObjecNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) { 
		 Optional<Cliente> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjecNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		} 
}
