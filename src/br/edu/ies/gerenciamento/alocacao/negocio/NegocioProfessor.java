package br.edu.ies.gerenciamento.alocacao.negocio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Departamento;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioProfessor;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.CPFQuantidadeCaracteresException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.CpfDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeInvalidoException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeProfessorInexisteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.TipoErro;

public class NegocioProfessor {

	private RepositorioProfessor repositorioProfessor;
	private NegocioDepartamento negocioDepartamento;

	public NegocioProfessor(RepositorioProfessor repositorioProfessor, NegocioDepartamento negocioDepartamento) {
		this.repositorioProfessor = repositorioProfessor;
		this.negocioDepartamento = negocioDepartamento;
	}

	public Professor procuraId(int id) {
		return repositorioProfessor.procuraPorID(id);
	}

	public Professor procuraNome(String nome) throws NomeProfessorInexisteException {
		Professor item = null;
		item = repositorioProfessor.procurarPorNome(nome);
		if (item !=null) {
			return item;
		}else {
			throw new NomeProfessorInexisteException();
		}
		
	}

	public Professor procurarCPF(String cpf) {
		return repositorioProfessor.procurarPorCPF(cpf);
	}

	public ArrayList<Professor> procuraTodos() {
		return repositorioProfessor.procuraTodos();
	}

	public boolean validarNome(String nome) throws NomeInvalidoException, NomeDuplicadoExcepetion {
		if (nome == null) {
			throw new NomeInvalidoException(TipoErro.NomeNull);
		} else if (nome.equals("")) {
			throw new NomeInvalidoException(TipoErro.NomeVazio);
		} else if (nome.length() < 2) {
			throw new NomeInvalidoException(TipoErro.NomeMuitoCurto);
		}

		return true;
	}

	public Departamento isDepartamento(String nome, NegocioDepartamento negocioDepartamento)
			throws DepartamentoInexistenteException {

		return negocioDepartamento.isDepartamento(nome, negocioDepartamento);
	}

	public void validarCPF(String cpf) throws CpfDuplicadoExcepetion, CPFQuantidadeCaracteresException {
		if (procurarCPF(cpf) != null) {
			throw new CpfDuplicadoExcepetion("CPF ja existente");
		}else if(cpf.length() != 11) {
			throw new CPFQuantidadeCaracteresException("Quantidade de Caracteres tem que ser igual a 11");
		}

	}

	public Professor inserir(Professor professor) throws NomeInvalidoException, NomeDuplicadoExcepetion,
			DepartamentoInexistenteException, CpfDuplicadoExcepetion, CPFQuantidadeCaracteresException {

		isDepartamento(professor.getDepartamento().getNomeDepartamento(), negocioDepartamento);
		validarNome(professor.getNome());
		validarCPF(professor.getCpf());

		return repositorioProfessor.inserir(professor);

	}

}
