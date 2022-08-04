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
			NomeProfessorInexisteException, CursoInexistenteException {

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

	public Alocacao procurarProfessorAlocado(String nome) {
		return repositorioAlocacao.procuraPorNomeProfessor(nome);
	}

	public void validarDataHora(Alocacao alocacao) throws DataHoraExistenteException {

		Alocacao procurarAlocado = procurarProfessorAlocado(alocacao.getProfessor().getNome());
		if (procurarAlocado != null) {
			if (alocacao.getDiaDaSemana().equals(procurarAlocado.getDiaDaSemana())
					& alocacao.getHorario().equals(procurarAlocado.getHorario())) {
				throw new DataHoraExistenteException("Professor " + procurarAlocado.getProfessor().getNome()
						+ " ja tem aula nesse mesmo horario" + "no curso " + procurarAlocado.getCurso().getNomeCurso());
			}
		}
	}

	public void validarAlocacao(Professor professor, Curso curso, Alocacao alocacao) throws AlocacaoExistenteExcepetion,
			DepartamentoCursoDifrenteProfessorException, DataHoraExistenteException {

		Alocacao item = null;
		item = repositorioAlocacao.procuraPorAlocacao(professor, curso);

		if (item != null) {
			throw new AlocacaoExistenteExcepetion("Este Professor ja esta alocado ao curso informado");
		} else if (!professor.getDepartamento().getNomeDepartamento()
				.equals(curso.getDepartamentoCurso().getNomeDepartamento())) {
			throw new DepartamentoCursoDifrenteProfessorException(
					"Departamento do professor precisa ser o mesmo do departamento do curso");
		} else {
			validarDataHora(alocacao);
		}
	}

}
