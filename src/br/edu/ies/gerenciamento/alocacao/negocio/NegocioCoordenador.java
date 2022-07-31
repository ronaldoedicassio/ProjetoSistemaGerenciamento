package br.edu.ies.gerenciamento.alocacao.negocio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Coordenador;
import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioCoordenador;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioCurso;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioDepartamento;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioProfessor;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.CursoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.DepartamentoCursoDifrenteProfessorException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeInvalidoException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeProfessorInexisteException;

public class NegocioCoordenador {
	private RepositorioCoordenador repositorioCoordenador;
	private NegocioDepartamento negocioDepartamento;
	private NegocioCurso negocioCurso;
	private NegocioProfessor negocioProfessor;
	private RepositorioProfessor repositorioProfessor;
	private RepositorioDepartamento repositorioDepartamento;
	private RepositorioCurso repositorioCurso;

	public NegocioCoordenador(RepositorioCoordenador repositorioCoordenador, NegocioCurso negocioCurso,
			NegocioProfessor negocioProfessor) {
		super();
		this.repositorioCoordenador = repositorioCoordenador;
		this.negocioProfessor = negocioProfessor;
		this.negocioCurso = negocioCurso;
	}

	public Coordenador procuraId(int id) {
		return repositorioCoordenador.procuraPorID(id);
	}

	public Coordenador procuraNome(String nome) {
		return repositorioCoordenador.procurarPorNome(nome);
	}

	public Coordenador procurarCPF(String cpf) {
		return repositorioCoordenador.procurarPorCPF(cpf);
	}

	public ArrayList<Coordenador> procuraTodos() {
		return repositorioCoordenador.procuraTodos();
	}

	public String validarNome(String nome) throws NomeProfessorInexisteException {
		Coordenador nomeValidar = null;
		nomeValidar = procuraNome(nome);

		if (nomeValidar != null) {
			nome = "Coord " + nome;
			return nome;
		} else {
			throw new NomeProfessorInexisteException();
		}

	}

//	public void isPertenceDepartamento(Curso curso, String nome)
//			throws DepartamentoCursoDifrenteProfessorException {
//		if (!curso.getDepartamentoCurso().getNomeDepartamento().equals(nome.getDepartamento().getNomeDepartamento())) {
//			throw new DepartamentoCursoDifrenteProfessorException();
//		}
//	}

	public Curso isPertenceDepartamento(String cursoCoordenado, String nomeCoordenador, NegocioCurso negocioCurso,
			NegocioProfessor negocioProfessor) throws DepartamentoCursoDifrenteProfessorException,
			CursoInexistenteException, NomeProfessorInexisteException {

		Curso curso = validarCurso(cursoCoordenado, negocioCurso);
		Professor professor = validarCoordenador(nomeCoordenador, negocioProfessor);

		if (curso.getDepartamentoCurso().getNomeDepartamento()
				.equals(professor.getDepartamento().getNomeDepartamento())) {
			return curso;

		} else {
			throw new DepartamentoCursoDifrenteProfessorException();
		}
	}

	public Curso validarCurso(String nomeCursoCoordenado, NegocioCurso negocioCurso) throws CursoInexistenteException {
		Curso curso = null;
		curso = negocioCurso.procuraNome(nomeCursoCoordenado);
		if (curso != null) {
			return curso;
		} else {
			throw new CursoInexistenteException();
		}
	}

	public Professor validarCoordenador(String nomeCoordenador, NegocioProfessor negocioProfessor)
			throws NomeProfessorInexisteException {
		Professor professor = null;
		professor = negocioProfessor.procuraNome(nomeCoordenador);

		if (professor != null) {
			return professor;
		} else {
			throw new NomeProfessorInexisteException();
		}

	}

//	public Professor isValidando(String nomeCoordenador) throws NomeProfessorInexisteException {
//
//		Professor professor = repositorioProfessor.procurarPorNome(nomeCoordenador);
//		if (professor != null) {
//			return professor;
//		} else {
//			throw new NomeProfessorInexisteException();
//		}
//	}

	public Coordenador inserir(Coordenador coordenador) throws NomeInvalidoException, NomeDuplicadoExcepetion,
			NomeProfessorInexisteException, DepartamentoCursoDifrenteProfessorException, CursoInexistenteException {

		Professor professor = validarCoordenador(coordenador.getNome(),negocioProfessor);
		isPertenceDepartamento(coordenador.getCursosCoordenados().getNomeCurso(), professor.getNome(),negocioCurso,negocioProfessor);

		return repositorioCoordenador.inserir(coordenador);

	}
}
