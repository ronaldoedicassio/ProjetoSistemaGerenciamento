package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class CursoInexistenteException extends Exception {
	private String cursoInexistenteException;
	
	public CursoInexistenteException(String cursoInexistenteException) {
		super("Curso não esta cadastro");
		this.cursoInexistenteException = cursoInexistenteException;
	}

	public String getNomeProfessorInexisteException() {
		return cursoInexistenteException;
	}

	public void setNomeProfessorInexisteException(String nomeProfessorInexisteException) {
		this.cursoInexistenteException = nomeProfessorInexisteException;
	}
	


}
