package br.edu.ies.gerenciamento.alocacao.negocio;

import java.util.ArrayList;
import java.util.Iterator;

import br.edu.ies.gerenciamento.alocacao.modelo.Alocacao;
import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.AlocacaoExistenteExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.CursoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.CursoPreenchidoException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DataHoraExistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoCursoDifrenteProfessorException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeProfessorInexisteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioAlocacao;

public class NegocioAlocacao {

	private RepositorioAlocacao repositorioAlocacao;

	public NegocioAlocacao(RepositorioAlocacao repositorioAlocacao, NegocioProfessor negocioProfessor,
			NegocioCurso negocioCurso) {
		super();
		this.repositorioAlocacao = repositorioAlocacao;
	}

	public ArrayList<Alocacao> procuraTodos() {
		return repositorioAlocacao.procuraTodos();
	}

	public Alocacao inserir(Alocacao alocacao)
			throws AlocacaoExistenteExcepetion, DepartamentoCursoDifrenteProfessorException, DataHoraExistenteException,
			NomeProfessorInexisteException, CursoInexistenteException, CursoPreenchidoException {

		validarAlocacao(alocacao.getProfessor(), alocacao.getCurso(), alocacao);

		return repositorioAlocacao.inserir(alocacao);
	}

	public Professor procuraProfessor(String nomeProfessor, NegocioProfessor negocioProfessor)
			throws NomeProfessorInexisteException {

		return negocioProfessor.procuraNome(nomeProfessor);
	}

	public Curso procurarCurso(String nomeCurso, NegocioCurso negocioCurso) throws CursoInexistenteException {
		Curso item = null;
		item = negocioCurso.procuraNome(nomeCurso);

		if (item != null) {
			return item;
		} else {
			throw new CursoInexistenteException("Curso não esta cadastrado");
		}
	}

	public ArrayList<Alocacao> procurarTodos() {
		return repositorioAlocacao.procuraTodos();
	}

	public void validarAlocacao(Professor professor, Curso curso, Alocacao alocacao) throws AlocacaoExistenteExcepetion,
			DepartamentoCursoDifrenteProfessorException, DataHoraExistenteException, CursoPreenchidoException {

		Alocacao item = null;
		item = repositorioAlocacao.procuraPorAlocacao(professor, curso);

		if (item != null) {
			throw new AlocacaoExistenteExcepetion("Este Professor ja esta alocado ao curso informado");
		} else if (!professor.getDepartamento().getNomeDepartamento()
				.equals(curso.getDepartamentoCurso().getNomeDepartamento())) {
			throw new DepartamentoCursoDifrenteProfessorException(
					"Departamento do professor precisa ser o mesmo do departamento do curso");
		} else {
			validarCursoAlocado(alocacao, curso.getNomeCurso());
			ArrayList<Alocacao> cursoProfessor = procurarAlocacoesPorProfessor(alocacao, professor.getNome());
			if (cursoProfessor != null) {
				validarDataHoraDisponivel(cursoProfessor, alocacao);
			}
		}
	}

	private void validarDataHoraDisponivel(ArrayList<Alocacao> cursoProfessor, Alocacao alocacao)
			throws DataHoraExistenteException {
		for (Alocacao item : cursoProfessor) {
			if (item.getDiaDaSemana().equals(alocacao.getDiaDaSemana())
					& item.getHorario().equals(alocacao.getHorario())) {
				throw new DataHoraExistenteException("Este horario indisponivel, pois esta sendo ministrado pelo curso "
						+ item.getCurso().getNomeCurso());
			}
		}
	}

	private ArrayList<Alocacao> procurarAlocacoesPorProfessor(Alocacao alocacao, String nome) {

		return repositorioAlocacao.procurarAlocacoesPorProfessor(nome);
	}

	private void validarCursoAlocado(Alocacao alocacao, String nomeCurso) throws CursoPreenchidoException {
		ArrayList<Alocacao> procurarAlocado = procurarTodos();
		for (Alocacao item : procurarAlocado) {
			if (item.getCurso().getNomeCurso().equals(nomeCurso)) {
				throw new CursoPreenchidoException("Curso " + item.getCurso().getNomeCurso()
						+ " ja esta ministrado pelo professor(a) " + item.getProfessor().getNome());
			}
		}
	}
}
