package com.isabella.prjEmpresa.repositories;
	
import org.springframework.data.jpa.repository.JpaRepository;

import com.isabella.prjEmpresa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}