package com.ex.goth3l.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ex.goth3l.entities.Dependente;
import com.ex.goth3l.repositories.DependenteRepository;

@Service
public class DependenteServices {
	private DependenteRepository dependenteRepository;
	
	@Autowired
	private DependenteServices(DependenteRepository dependenteRepository) {
		this.dependenteRepository = dependenteRepository;
	}
	
	public Dependente getDependenteByid(Long id) {
		return dependenteRepository.findById(id).orElse(null);
	}
	
	public List<Dependente> getAllDependentes(){
		return dependenteRepository.findAll();
	}
	
	public Dependente saveDependente(Dependente dependente) {
		return dependenteRepository.save(dependente);
	}

}
