package com.isabella.prjEmpresa.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isabella.prjEmpresa.entities.Funcionario;
import com.isabella.prjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService (FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	// preparando as buscas por id
	public Funcionario getFuncionarioById(Long id) {
		Optional<Funcionario> Funcionario = funcionarioRepository.findById(id);
		return Funcionario.orElse(null);
	}

	// preparando a busca geral
	public List<Funcionario> findAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	// salvando o Jogo
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	// fazendo o update do jogo com o optional
	public Funcionario updateFuncionario(Long id, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFuncodigo(novoFuncionario.getFuncodigo());
			funcionarioExistente.setFunname(novoFuncionario.getFunname());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null;
		}
	}

	// deletando o update do usuario com o optional
	public boolean deleteFuncionario(Long id) {
		Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(id);
		if (funcionarioExistente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
