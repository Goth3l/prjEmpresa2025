package com.ex.goth3l.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.goth3l.entities.Departamento;
import com.ex.goth3l.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}