package com.natymorgs.backEndSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natymorgs.backEndSpring.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{	

}
