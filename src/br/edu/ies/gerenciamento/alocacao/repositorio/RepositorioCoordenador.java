package br.edu.ies.gerenciamento.alocacao.repositorio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Coordenador;
import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeInvalidoException;

public class RepositorioCoordenador {

	private ArrayList<Coordenador> colecao;
	private int ultimoIDadicionado;

	public RepositorioCoordenador() {
		colecao = new ArrayList<Coordenador>();
		ultimoIDadicionado = 0;
	}

	public Coordenador inserir(Coordenador item) throws NomeInvalidoException, NomeDuplicadoExcepetion {
		ultimoIDadicionado = ultimoIDadicionado + 1;
		item.setId(ultimoIDadicionado);
		colecao.add(item);
		item.setNameCoordenador("Coord " + item.getNome());

		return item;
	}

	public Coordenador procuraPorID(int id) {
		Coordenador item = null;

		for (Coordenador Coordenador : colecao) {
			if (Coordenador.getId() == id) {
				item = Coordenador;
				break;
			}
		}
		return item;
	}

	public Coordenador procurarPorCPF(String cpf) {
		Coordenador item = null;

		for (Coordenador Coordenador : colecao) {
			if (Coordenador.getCpf().equals(cpf)) {
				item = Coordenador;
				break;
			}
		}
		return item;
	}

	public Coordenador procurarPorNome(String nome) {
		Coordenador item = null;

		for (Coordenador Coordenador : colecao) {
			if (Coordenador.getNome().toLowerCase().equals(nome.toLowerCase())) {
				item = Coordenador;
				break;
			}
		}
		return item;
	}

	public ArrayList<Coordenador> procuraTodos() {
		return new ArrayList<>(colecao);
	}
}
