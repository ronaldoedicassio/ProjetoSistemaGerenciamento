package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class NomeDuplicadoExcepetion extends Exception {

	private String tipoOndeOcorreuNomeDuplicado;

	public NomeDuplicadoExcepetion(String tipoOndeOcorreuNomeDuplicado) {
		super("Um nome duplicado foi detectado");
		this.tipoOndeOcorreuNomeDuplicado = tipoOndeOcorreuNomeDuplicado;
	}

	public String getTipoOndeOcorreuNomeDuplicado() {
		return tipoOndeOcorreuNomeDuplicado;
	}

	public void setTipoOndeOcorreuNomeDuplicado(String tipoOndeOcorreuNomeDuplicado) {
		this.tipoOndeOcorreuNomeDuplicado = tipoOndeOcorreuNomeDuplicado;
	}

}
