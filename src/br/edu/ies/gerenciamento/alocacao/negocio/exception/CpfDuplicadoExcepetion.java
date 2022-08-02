package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class CpfDuplicadoExcepetion extends Exception {

	private String cpfduplicado;

	public CpfDuplicadoExcepetion(String cpfduplicado) {
		super("CPF Duplicado");
		this.cpfduplicado = cpfduplicado;
	}

	public String getCpfduplicado() {
		return cpfduplicado;
	}

	public void setCpfduplicado(String cpfduplicado) {
		this.cpfduplicado = cpfduplicado;
	}

}
