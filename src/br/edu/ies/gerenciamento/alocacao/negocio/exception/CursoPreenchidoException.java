package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class CursoPreenchidoException extends Exception {

	private String cursoPreenchidoException;

	public CursoPreenchidoException(String cursoPreenchidoException) {
		super("Curso ja esta alocado a outro professor");
		this.cursoPreenchidoException = cursoPreenchidoException;
	}

	public String getCursoPreenchidoException() {
		return cursoPreenchidoException;
	}

	public void setCursoPreenchidoException(String cursoPreenchidoException) {
		this.cursoPreenchidoException = cursoPreenchidoException;
	}

}
