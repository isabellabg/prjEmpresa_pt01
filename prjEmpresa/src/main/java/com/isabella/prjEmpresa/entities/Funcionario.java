package com.isabella.prjEmpresa.entities;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Funcodigo;
	
	private String Funname;
	
	@DateTimeFormat (pattern = "dd/MM/yyyy")
	private LocalDate Funnascimento;
	
	private double Funsalario;

	public Long getFuncodigo() {
		return Funcodigo;
	}

	public void setFuncodigo(Long funcodigo) {
		Funcodigo = funcodigo;
	}

	public String getFunname() {
		return Funname;
	}

	public void setFunname(String funname) {
		Funname = funname;
	}

	public LocalDate getFunnascimento() {
		return Funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		Funnascimento = funnascimento;
	}

	public double getFunsalario() {
		return Funsalario;
	}

	public void setFunsalario(double funsalario) {
		Funsalario = funsalario;
	}

}