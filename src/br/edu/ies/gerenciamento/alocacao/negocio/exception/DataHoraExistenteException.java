package br.edu.ies.gerenciamento.alocacao.negocio.exception;

public class DataHoraExistenteException extends Exception {
	private String dataHoraExistenteException;

	public DataHoraExistenteException(String dataHoraExistenteException) {
		super("Esse professor ja ministra uma aula nessa mesmo dia e horario");
		this.dataHoraExistenteException = dataHoraExistenteException;
	}

	public String getDataHoraExistenteException() {
		return dataHoraExistenteException;
	}

	public void setDataHoraExistenteException(String dataHoraExistenteException) {
		this.dataHoraExistenteException = dataHoraExistenteException;
	}

}
