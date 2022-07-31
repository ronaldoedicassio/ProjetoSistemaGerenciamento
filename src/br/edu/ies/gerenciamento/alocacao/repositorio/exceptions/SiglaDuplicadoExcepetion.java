package br.edu.ies.gerenciamento.alocacao.repositorio.exceptions;

public class SiglaDuplicadoExcepetion extends Exception {

	private String siglaDuplicada;
	
	public SiglaDuplicadoExcepetion(String siglaDuplicada) {
		super("Ja existe um departamento ou curso com essa sigla");
		this.siglaDuplicada = siglaDuplicada;
	}

	public String getSiglaDuplicada() {
		return siglaDuplicada;
	}

	public void setSiglaDuplicada(String siglaDuplicada) {
		this.siglaDuplicada = siglaDuplicada;
	}
	
	
}
