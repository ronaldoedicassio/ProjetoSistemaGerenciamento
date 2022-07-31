package br.edu.ies.gerenciamento.alocacao.modelo;

public class Professor {

	private int id;
	private String nome;
	private String cpf;
	private Departamento departamento;

	public Professor(String nome, String cpf, Departamento departamento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.departamento = departamento;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", departamento=" + departamento + "]";
	}

	
}
