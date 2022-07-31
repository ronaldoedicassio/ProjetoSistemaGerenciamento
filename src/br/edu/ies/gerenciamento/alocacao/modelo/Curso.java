package br.edu.ies.gerenciamento.alocacao.modelo;

public class Curso {

	private int id;
	private String nomeCurso;
	private Departamento departamentoCurso;
	private String siglaCurso;

	public Curso(String nome, Departamento departamentoCurso, String siglaCurso) {
		this.nomeCurso = nome;
		this.departamentoCurso = departamentoCurso;
		this.siglaCurso = siglaCurso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Departamento getDepartamentoCurso() {
		return departamentoCurso;
	}

	public void setDepartamentoCurso(Departamento departamentoCurso) {
		this.departamentoCurso = departamentoCurso;
	}

	public String getSiglaCurso() {
		return siglaCurso;
	}

	public void setSiglaCurso(String sigla) {
		this.siglaCurso = sigla;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nome) {
		this.nomeCurso = nome;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nomeCurso=" + nomeCurso + ", departamentoCurso=" + departamentoCurso
				+ ", siglaCurso=" + siglaCurso + "]";
	}

}
