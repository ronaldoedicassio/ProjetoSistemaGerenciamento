package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class AlocacaoExistenteExcepetion extends Exception {
	private String alocacaoExistenteExcepetion;

	public AlocacaoExistenteExcepetion(String alocacaoExistenteExcepetion) {
		super("Professr ja se encontra alocado a esse curso");
		this.alocacaoExistenteExcepetion = alocacaoExistenteExcepetion;

	}

	public String getAlocacaoExistenteExcepetion() {
		return alocacaoExistenteExcepetion;
	}

	public void setAlocacaoExistenteExcepetion(String alocacaoExistenteExcepetion) {
		this.alocacaoExistenteExcepetion = alocacaoExistenteExcepetion;
	}

}
