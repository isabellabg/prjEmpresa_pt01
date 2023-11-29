package com.isabella.prjEmpresa.controllers;
	
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.isabella.prjEmpresa.entities.Funcionario;
import com.isabella.prjEmpresa.services.FuncionarioService;

	@RestController
	@RequestMapping("/funcionario")
	public class FuncionarioControler {
		private final FuncionarioService funcionarioService;

		 @GetMapping("/home")
		   public String paginaInicial() {
		       return "index";
		   }

		   @Autowired
		   public FuncionarioControler(FuncionarioService funcionarioService) {
		       this.funcionarioService = funcionarioService;
		   }

		   @PostMapping
		   public Funcionario createDepartamento(@RequestBody Funcionario funcionario) {
		       return funcionarioService.saveFuncionario(funcionario);
		   }
		   
		   //Utilizando o ResponseEntity e RequestEntit
		   @GetMapping
		   public ResponseEntity<List<Funcionario>> getAllDepartamento(RequestEntity<Void> requestEntity) {
		       String method = requestEntity.getMethod().name();
		       String contentType = requestEntity.getHeaders().getContentType().toString();
		       List<Funcionario> funcionario = funcionarioService.findAllFuncionario();
		       return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
		               .body(funcionario);
		   }
		   
		   @PutMapping("/{id}")
		   public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		       return funcionarioService.updateFuncionario(id, funcionario);
		   }

		   @GetMapping("/{id}")
		   public ResponseEntity<Funcionario> getDepartamento(@PathVariable Long id) {
			   Funcionario funcionario = funcionarioService.getFuncionarioById(id);
		       if (funcionarioService != null) {
		           return ResponseEntity.ok(funcionario);
		       } else {
		           return ResponseEntity.notFound().build();
		       }
		   }

		   @DeleteMapping("/{id}")
		   public void deleteDepartamento(@PathVariable Long id) {
			   funcionarioService.deleteFuncionario(id);
		   }
	}


