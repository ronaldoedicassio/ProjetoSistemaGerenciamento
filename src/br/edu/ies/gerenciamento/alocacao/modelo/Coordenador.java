package br.edu.ies.gerenciamento.alocacao.modelo;

public class Coordenador extends Professor {

	private Curso cursosCoordenados;
	private int id;

	public Curso getCusrosCoordenados() {
		return cursosCoordenados;
	}

	public Coordenador(String nome, String cpf, Departamento departamento, Curso curso) {
		super(nome, cpf, departamento);
		cursosCoordenados = curso;
	}

	public Curso getCursosCoordenados() {
		return cursosCoordenados;
	}

	public void setCursosCoordenados(Curso cursosCoordenados) {
		this.cursosCoordenados = cursosCoordenados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNameCoordenador(String nome) {
		this.setNome(nome);
	}

	@Override
	public String toString() {
		return "Coordenador [cursosCoordenados=" + cursosCoordenados + ", getNome()=" + getNome() + ", getCpf()="
				+ getCpf() + ", getDepartamento()=" + getDepartamento() + "]";
	}

}
