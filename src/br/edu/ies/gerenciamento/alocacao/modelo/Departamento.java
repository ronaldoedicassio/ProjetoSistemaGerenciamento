package br.edu.ies.gerenciamento.alocacao.modelo;

public class Departamento {

	private int id;
	private String nomeDepartamento;
	private AreaDepartamento areaDepartamento;
	private String siglaDepartamento;

	public Departamento() {

	}

	public Departamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public Departamento(String nomeDepartamento, AreaDepartamento area, String siglaDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
		this.areaDepartamento = area;
		this.siglaDepartamento = siglaDepartamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

	public AreaDepartamento getArea() {
		return areaDepartamento;
	}

	public void setArea(AreaDepartamento area) {
		this.areaDepartamento = area;
	}

	public String getSiglaDepartamento() {
		return siglaDepartamento;
	}

	public void setSiglaDepartamento(String siglaDepartamento) {
		this.siglaDepartamento = siglaDepartamento;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nomeDepartamento=" + nomeDepartamento + ", areaDepartamento="
				+ areaDepartamento + ", siglaDepartamento=" + siglaDepartamento + "]";
	}

}
