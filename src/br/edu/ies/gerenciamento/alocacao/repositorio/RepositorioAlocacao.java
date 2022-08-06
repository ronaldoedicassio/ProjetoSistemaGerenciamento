package br.edu.ies.gerenciamento.alocacao.repositorio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Alocacao;
import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;

public class RepositorioAlocacao {

	private ArrayList<Alocacao> colecao;
	private int ultimoIDadicionado;

	public RepositorioAlocacao() {
		this.colecao = new ArrayList<Alocacao>();
		this.ultimoIDadicionado = 0;
	}

	public Alocacao inserir(Alocacao item) {
		ultimoIDadicionado = ultimoIDadicionado + 1;
		item.setId(ultimoIDadicionado);
		colecao.add(item);
		return item;
	}

	public Alocacao procuraPorID(int id) {
		Alocacao item = null;
		for (Alocacao alocacao : colecao) {
			if (alocacao.getId() == id) {
				item = alocacao;
				break;
			}
		}
		return item;
	}

	public Alocacao procuraPorNomeProfessor(String nome) {
		Alocacao item = null;
		for (Alocacao alocacao : colecao) {
			if (alocacao.getProfessor().getNome().equals(nome)) {
				item = alocacao;
				break;
			}
		}
		return item;
	}

	public Alocacao procuraPorAlocacao(Professor professor, Curso curso) {
		Alocacao item = null;

		for (Alocacao alocacao : colecao) {
			if (alocacao.getCurso().equals(curso) & alocacao.getProfessor().equals(professor)) {
				item = alocacao;
				break;
			}
		}
		return item;
	}
	
	public ArrayList<Alocacao> procurarAlocacoesPorProfessor(String nome) {
		ArrayList<Alocacao> professorCursosMinistrado = new ArrayList<Alocacao>();
		ArrayList<Alocacao> procurarAlocado = procuraTodos();
		for (Alocacao item : procurarAlocado) {
			if (item.getProfessor().getNome().equals(nome)) {
				professorCursosMinistrado.add(item);
			}
		}
		return new ArrayList<>(professorCursosMinistrado);
	}


	public ArrayList<Alocacao> procuraTodos() {
		return new ArrayList<>(colecao);
	}
}
