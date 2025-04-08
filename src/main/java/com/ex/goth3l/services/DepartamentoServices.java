package com.ex.goth3l.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.goth3l.entities.Departamento;
import com.ex.goth3l.repositories.DepartamentoRepository;

@Service
public class DepartamentoServices {
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	private DepartamentoServices(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}
	
	public Departamento getDepartametoByid(Long id) {
		return departamentoRepository.findById(id).orElse(null);
	}
	
	public List<Departamento> getAllDepartamentos(){
		return departamentoRepository.findAll();
	}
	
	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

}
