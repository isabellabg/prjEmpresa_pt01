package com.isabella.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.isabella.prjEmpresa.entities.Departamento;
import com.isabella.prjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	private final DepartamentoRepository departamentorepository;

	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentorepository = departamentoRepository;
	}

	public Departamento saveDepartamento(Departamento departamento) {
		return departamentorepository.save(departamento);
	}

	public Departamento getDepartamentoById(Long id) {
		return departamentorepository.findById(id).orElse(null);
	}

	public Departamento getProdutoById(long id) {
		return departamentorepository.findById(id).orElse(null);
	}

	public List<Departamento> getAllDepartamento() {
		return departamentorepository.findAll();
	}

	public void deletDepartamento(Long id) {
		departamentorepository.deleteById(id);
	}

	// fazendo o update do departamento com o optional

	public Departamento updateDepartamento(Long id, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentorepository.findById(id);

		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setName(novoDepartamento.getName());
			return departamentorepository.save(departamentoExistente);
		} else {
			return null;
		}
	}
}
