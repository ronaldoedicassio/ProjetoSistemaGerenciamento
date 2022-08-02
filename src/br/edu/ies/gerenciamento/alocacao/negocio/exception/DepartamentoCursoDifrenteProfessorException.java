package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class DepartamentoCursoDifrenteProfessorException extends Exception {

	private String departamentoCursoDifrenteProfessorException;

	public DepartamentoCursoDifrenteProfessorException(String departamentoCursoDifrenteProfessorException) {
		super("Departamento do curso não pertence ao departamento do professor");
		this.departamentoCursoDifrenteProfessorException = departamentoCursoDifrenteProfessorException;
	}

	public String getDepartamentoCursoDifrenteProfessorException() {
		return departamentoCursoDifrenteProfessorException;
	}

	public void setDepartamentoCursoDifrenteProfessorException(String departamentoCursoDifrenteProfessorException) {
		this.departamentoCursoDifrenteProfessorException = departamentoCursoDifrenteProfessorException;
	}

}
