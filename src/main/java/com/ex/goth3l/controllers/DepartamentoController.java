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

import com.ex.goth3l.entities.Departamento;
import com.ex.goth3l.services.DepartamentoServices;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

	private final DepartamentoServices departamentoService;

	public DepartamentoController(DepartamentoServices departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> findDepartamentoById(@PathVariable Long id) {
		Departamento departamento = departamentoService.getDepartametoByid(id);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Departamento>> findAllDepartamentos() {
		List<Departamento> departamentos = departamentoService.getAllDepartamentos();
		return ResponseEntity.ok(departamentos);
	}
	
	@PostMapping("/")
	public ResponseEntity<Departamento> insertDepartamento(@RequestBody Departamento departamento) {
		Departamento novoDepartamento = departamentoService.saveDepartamento(departamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoDepartamento);
	}

}
