package com.isabella.prjEmpresa.controllers;
	
	import java.util.List;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.RequestEntity;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;

import com.isabella.prjEmpresa.entities.Funcionario;
import com.isabella.prjEmpresa.services.FuncionarioService;

	public class FuncionarioControler {

		//Utilizando o ResponseEntity e RequestEntity
			@GetMapping
			public ResponseEntity<List<Funcionario>> getAllFuncionarios(RequestEntity<Void> requestEntity) {
				String method = requestEntity.getMethod().name();
				String contentType = requestEntity.getHeaders().getContentType().toString();
				List<Departamento> departamentos = FuncionarioService.getAllFuncionarios();
				return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
						.body(funcionarios);
			}
			
			@PutMapping("/{id}")
			public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Funcionario funcionario) {
				return funcionarioService.updateFuncionario(id, funcionario);
			}
	}


