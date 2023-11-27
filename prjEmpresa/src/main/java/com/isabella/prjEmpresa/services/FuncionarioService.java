package com.isabella.prjEmpresa.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isabella.prjEmpresa.entities.Departamento;
import com.isabella.prjEmpresa.entities.Funcionario;
import com.isabella.prjEmpresa.repositories.DepartamentoRepository;
import com.isabella.prjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionariorepository;
	
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionariorepository = funcionarioRepository;
	}

	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionariorepository.save(funcionario);
	}

	public Funcionario getFuncionarioById(Long id) {
		return funcionariorepository.findById(id).orElse(null);
	}

	public Funcionario getProdutoById(long id) {
		return funcionariorepository.findById(id).orElse(null);
	}

	public List<Funcionario> getAllFuncionario(){
		return funcionariorepository.findAll();
	}

	public void deletFuncionario(Long id) {
		funcionariorepository.deleteById(id);
	}

}
