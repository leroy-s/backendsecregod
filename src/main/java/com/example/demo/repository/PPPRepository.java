package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PPP;
import java.util.List;
@Repository
public interface PPPRepository extends JpaRepository<PPP, Long>{

	// Método para encontrar todas las prácticas por id de línea
	List<PPP> findByLineaId(Long idLinea);
//DIAGRAMA DE CLASE DE DISEÑO 

//DIAGRA



}