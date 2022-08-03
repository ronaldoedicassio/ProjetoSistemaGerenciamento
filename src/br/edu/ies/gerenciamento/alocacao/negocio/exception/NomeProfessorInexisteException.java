package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class NomeProfessorInexisteException extends Exception {
	private String nomeProfessorInexisteException;
	
	public NomeProfessorInexisteException(String nomeProfessorInexisteException) {
		super("Professor não esta cadastro");
		this.nomeProfessorInexisteException = nomeProfessorInexisteException;
	}

	public String getNomeProfessorInexisteException() {
		return nomeProfessorInexisteException;
	}

	public void setNomeProfessorInexisteException(String nomeProfessorInexisteException) {
		this.nomeProfessorInexisteException = nomeProfessorInexisteException;
	}
	

}
