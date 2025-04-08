package com.ex.goth3l.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.goth3l.entities.Departamento;
import com.ex.goth3l.entities.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {

}
