package br.edu.ies.gerenciamento.alocacao.negocio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Departamento;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeInvalidoException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.SiglaDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioCurso;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.TipoErro;

public class NegocioCurso {

	private RepositorioCurso repositorioCurso;
	private NegocioDepartamento negocioDepartamento;

	public NegocioCurso(RepositorioCurso repositorioCurso, NegocioDepartamento negocioDepartamento) {
		super();
		this.repositorioCurso = repositorioCurso;
		this.negocioDepartamento = negocioDepartamento;
	}

	public Curso procuraId(int id) {
		return repositorioCurso.procuraPorID(id);
	}

	public Curso procuraNome(String nome) {
		return repositorioCurso.procurarPorNome(nome);
	}

	public ArrayList<Curso> procuraTodos() {
		return repositorioCurso.procuraTodos();
	}

	public Departamento isDepartamento(String nome, NegocioDepartamento negocioDepartamento)
			throws DepartamentoInexistenteException {

		return negocioDepartamento.isDepartamento(nome, negocioDepartamento);
	}

	public Curso procurarSigla(String sigla) {
		return repositorioCurso.procurarSigla(sigla);
	}

	public Curso procurarSigla(String sigla, RepositorioCurso repositorioCurso) {
		return repositorioCurso.procurarSigla(sigla);
	}

	public void validarSigla(String siglaCurso, NegocioDepartamento negocioDepartamento)
			throws SiglaDuplicadoExcepetion {
		if (repositorioCurso.procurarSigla(siglaCurso) != null
				|| negocioDepartamento.procurarSigla(siglaCurso) != null) {
			throw new SiglaDuplicadoExcepetion("Sigla Existente");
		}

	}

	public void validarSigla(String siglaCurso, RepositorioCurso repositorioCurso) throws SiglaDuplicadoExcepetion {
		if (repositorioCurso.procurarSigla(siglaCurso) != null) {
			throw new SiglaDuplicadoExcepetion("Sigla Existente");
		}

	}

	public boolean validarNome(String nome) throws NomeInvalidoException, NomeDuplicadoExcepetion {
		if (nome == null) {
			throw new NomeInvalidoException(TipoErro.NomeNull);
		} else if (nome.equals("")) {
			throw new NomeInvalidoException(TipoErro.NomeVazio);
		} else if (nome.length() < 2) {
			throw new NomeInvalidoException(TipoErro.NomeMuitoCurto);
		} else if (procuraNome(nome) != null) {
			throw new NomeDuplicadoExcepetion("Ja existe um nome para esse curso cadastrado! ");
		}

		return true;
	}

	public Curso inserir(Curso curso) throws NomeInvalidoException, NomeDuplicadoExcepetion,
			DepartamentoInexistenteException, SiglaDuplicadoExcepetion {
		isDepartamento(curso.getDepartamentoCurso().getNomeDepartamento(), negocioDepartamento);
		validarNome(curso.getNomeCurso());
		validarSigla(curso.getSiglaCurso(), negocioDepartamento);
		return repositorioCurso.inserir(curso);
	}

}
