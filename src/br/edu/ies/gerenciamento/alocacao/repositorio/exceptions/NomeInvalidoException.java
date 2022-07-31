package br.edu.ies.gerenciamento.alocacao.repositorio.exceptions;

public class NomeInvalidoException extends Exception {
	private TipoErro tipoErro;

	public NomeInvalidoException(TipoErro tipoErro) {
		this.tipoErro = tipoErro;
	}

	public TipoErro getTipoErro() {
		return tipoErro;
	}

	public void setTipoErro(TipoErro tipoErro) {
		this.tipoErro = tipoErro;
	}
}
