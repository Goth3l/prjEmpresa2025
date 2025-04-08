package com.ex.goth3l.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ex.goth3l.entities.Funcionario;
import com.ex.goth3l.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Funcionario getFuncionarioByid(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	
	public List<Funcionario> getAllFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

}
