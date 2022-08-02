package br.edu.ies.gerenciamento.alocacao.repositorio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeInvalidoException;

public class RepositorioProfessor {

	private ArrayList<Professor> colecao;
	private int ultimoIDadicionado;

	public RepositorioProfessor() {
		colecao = new ArrayList<Professor>();
		ultimoIDadicionado = 0;
	}

	public Professor inserir(Professor item) throws NomeInvalidoException, NomeDuplicadoExcepetion {
		ultimoIDadicionado = ultimoIDadicionado + 1;
		item.setId(ultimoIDadicionado);
		colecao.add(item);

		return item;
	}

	public Professor procuraPorID(int id) {
		Professor item = null;

		for (Professor Professor : colecao) {
			if (Professor.getId() == id) {
				item = Professor;
				break;
			}
		}
		return item;
	}

	public Professor procurarPorCPF(String cpf) {
		Professor item = null;

		for (Professor Professor : colecao) {
			if (Professor.getCpf().equals(cpf)) {
				item = Professor;
				break;
			}
		}
		return item;
	}

	public Professor procurarPorNome(String nome) {
		Professor item = null;

		for (Professor Professor : colecao) {
			if (Professor.getNome().toLowerCase().equals(nome.toLowerCase())) {
				item = Professor;
				break;
			}
		}
		return item;
	}

	public ArrayList<Professor> procuraTodos() {
		return new ArrayList<>(colecao);
	}

}
