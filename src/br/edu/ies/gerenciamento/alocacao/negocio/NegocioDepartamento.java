package br.edu.ies.gerenciamento.alocacao.negocio;

import java.awt.geom.Area;
import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.AreaDepartamento;
import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Departamento;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeInvalidoException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.SiglaDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioCurso;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioDepartamento;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.TipoErro;

public class NegocioDepartamento {

	// toda classe de Negocio vai ter ao menos um classe do tipo repositório
	private RepositorioDepartamento repositorioDepartamento;
	private NegocioCurso negocioCurso;
	private RepositorioCurso repositorioCurso;

	/*
	 * E interessante ter um contrutor para a classe, e receba o repositorio pois
	 * não sera necessario instanciar toda vez Facilitando fazer instancias de forma
	 * automatica
	 */

	public NegocioDepartamento(RepositorioDepartamento repositorioDepartamento, RepositorioCurso repositorioCurso) {
		this.repositorioDepartamento = repositorioDepartamento;
		this.repositorioCurso = repositorioCurso;
	}

	public NegocioDepartamento(NegocioCurso negocioCurso) {
		this.negocioCurso = negocioCurso;
	}

	public ArrayList<Departamento> procuraTodos() {
		return repositorioDepartamento.procuraTodos();
	}

	public boolean deletar(int id) {
		return repositorioDepartamento.delatarPorId(id);
	}

	public boolean atualizarNome(String nomeAtual, String nomeNovo)
			throws NomeInvalidoException, NomeDuplicadoExcepetion {
		validarNome(nomeNovo);
		return repositorioDepartamento.modificarNome(nomeAtual, nomeNovo);
	}

	public Departamento procuraId(int id) {
		return repositorioDepartamento.procuraPorID(id);
	}

	public Departamento procuraNome(String nome) {
		return repositorioDepartamento.procurarPorNome(nome);
	}

	public Departamento isDepartamento(String nomeProcurado, NegocioDepartamento negocioDepartamento)
			throws DepartamentoInexistenteException {
		Departamento departamento = null;
		departamento = repositorioDepartamento.procurarPorNome(nomeProcurado);
		if (departamento != null) {
			return departamento;
		} else {
			throw new DepartamentoInexistenteException("Departamento nao existe");
		}
	}

	public void validarNome(String nome) throws NomeInvalidoException, NomeDuplicadoExcepetion {
		if (nome == null) {
			throw new NomeInvalidoException(TipoErro.NomeNull);
		} else if (nome.equals("")) {
			throw new NomeInvalidoException(TipoErro.NomeVazio);
		} else if (nome.length() <= 2) {
			throw new NomeInvalidoException(TipoErro.NomeMuitoCurto);
		} else if (procuraNome(nome) != null) {
			throw new NomeDuplicadoExcepetion("Ja existe um departamento com esse nome");
		}
	}

	public Departamento procurarSigla(String sigla) {
		return repositorioDepartamento.procuraSigla(sigla);
	}

	public Curso procurarSigla(String sigla, RepositorioCurso repositorioCurso) {
		return repositorioDepartamento.procuraSiglaCurso(sigla, repositorioCurso);
	}

	public void validarSigla(String sigla, NegocioCurso negocioCurso, RepositorioCurso repositorioCurso)
			throws SiglaDuplicadoExcepetion {
		if (procurarSigla(sigla) != null || negocioCurso.procurarSigla(sigla, repositorioCurso) != null) {
			throw new SiglaDuplicadoExcepetion("Sigla Existente");
		}
	}

	public Departamento inserir(Departamento item) throws NomeDuplicadoExcepetion, NomeInvalidoException {

		validarNome(item.getNomeDepartamento());		
		return repositorioDepartamento.inserir(item);
	}
}
