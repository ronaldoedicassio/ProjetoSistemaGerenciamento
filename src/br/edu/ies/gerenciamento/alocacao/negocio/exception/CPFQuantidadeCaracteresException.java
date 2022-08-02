package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class CPFQuantidadeCaracteresException extends Exception {
	private String qtdCaracteresCPF;

	public CPFQuantidadeCaracteresException(String qtdCaracteresCPF) {
		super("Quantidade de numero tem que ser 11");
		this.qtdCaracteresCPF = qtdCaracteresCPF;
	}

	public String getqtdCaracteresCPF() {
		return qtdCaracteresCPF;
	}

	public void setqtdCaracteresCPF(String qtdCaracteresCPF) {
		this.qtdCaracteresCPF = qtdCaracteresCPF;
	}


}
