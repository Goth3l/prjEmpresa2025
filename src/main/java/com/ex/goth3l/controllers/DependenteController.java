package com.ex.goth3l.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.goth3l.entities.Dependente;
import com.ex.goth3l.services.DependenteServices;


@RestController
@RequestMapping("/dependentes")
public class DependenteController {
	
	private final DependenteServices dependenteService;
	
	public DependenteController (DependenteServices dependenteService) {
		this.dependenteService =  dependenteService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dependente> findDepartamentoById(@PathVariable Long id ){
		Dependente dependente = dependenteService.getDependenteByid(id);
		if(dependente != null) {
			return ResponseEntity.ok(dependente);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Dependente>> findAllDependente(){
		List<Dependente>dependente = dependenteService.getAllDependentes();
		return ResponseEntity.ok(dependente);
	}
	
	@PostMapping("/")
	public ResponseEntity<Dependente> insertDependente(@RequestBody Dependente dependente){
		Dependente novoDependente= dependenteService.saveDependente(dependente);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDependente);
	}

}
