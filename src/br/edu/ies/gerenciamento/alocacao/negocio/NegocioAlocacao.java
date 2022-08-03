package br.edu.ies.gerenciamento.alocacao.negocio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Alocacao;
import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.AlocacaoExistenteExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.CursoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DataHoraExistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoCursoDifrenteProfessorException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeProfessorInexisteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioAlocacao;

public class NegocioAlocacao {

	private RepositorioAlocacao repositorioAlocacao;
	private NegocioProfessor negocioProfessor;
	private NegocioCurso negocioCurso;

	public NegocioAlocacao(RepositorioAlocacao repositorioAlocacao, NegocioProfessor negocioProfessor,
			NegocioCurso negocioCurso) {
		super();
		this.repositorioAlocacao = repositorioAlocacao;
		this.negocioProfessor = negocioProfessor;
		this.negocioCurso = negocioCurso;
	}

	public ArrayList<Alocacao> procuraTodos() {
		return repositorioAlocacao.procuraTodos();
	}

	public Alocacao inserir(Alocacao alocacao) throws AlocacaoExistenteExcepetion,
			DepartamentoCursoDifrenteProfessorException, DataHoraExistenteException, NomeProfessorInexisteException, CursoInexistenteException {
		Alocacao item = validarAlocacao(alocacao.getProfessor(), alocacao.getCurso());
//		procuraProfessor(alocacao.getProfessor().getNome());
//		procurarCurso(alocacao.getCurso().getNomeCurso());
		if (item != null) {
			validarDataHora(alocacao, item);
		}

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

	public void validarDataHora(Alocacao alocacao, Alocacao item) throws DataHoraExistenteException {

		if (item.getDiaDaSemana().equals(alocacao.getDiaDaSemana()) & item.getHorario().equals(alocacao.getHorario())) {
			throw new DataHoraExistenteException(item.getProfessor().getNome() + " ja ministra o curso "
					+ item.getCurso().getNomeCurso() + " neste horario");
		}

	}

	public Alocacao validarAlocacao(Professor professor, Curso curso)
			throws AlocacaoExistenteExcepetion, DepartamentoCursoDifrenteProfessorException {
		Alocacao alocacao = null;
		alocacao = repositorioAlocacao.procuraPorAlocacao(professor, curso);
		if (alocacao != null) {
			throw new AlocacaoExistenteExcepetion("Este Professor ja esta alocado ao curso informado");
		} else if (!professor.getDepartamento().getNomeDepartamento()
				.equals(curso.getDepartamentoCurso().getNomeDepartamento())) {
			throw new DepartamentoCursoDifrenteProfessorException(
					"Departamento do professor precisa ser o mesmo do departamento do curso");
		}
		return alocacao;
	}

}
