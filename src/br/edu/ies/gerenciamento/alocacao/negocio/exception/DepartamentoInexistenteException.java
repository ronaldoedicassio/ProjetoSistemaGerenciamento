package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class DepartamentoInexistenteException extends Exception {
	private String departamentoInexistente;

	public DepartamentoInexistenteException(String departamentoInexistente) {
		super("Departamento nao foi encontrado ");
		this.departamentoInexistente = departamentoInexistente;
	}

	public String getDepartamentoInexistente() {
		return departamentoInexistente;
	}

	public void setDepartamentoInexistente(String departamentoInexistente) {
		this.departamentoInexistente = departamentoInexistente;
	}

}
