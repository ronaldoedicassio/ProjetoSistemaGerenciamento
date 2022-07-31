package br.edu.ies.gerenciamento.alocacao.repositorio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Alocacao;

public class RepositorioAlocacao {

	private ArrayList<Alocacao> colecao;
	private int ultimoIDadicionado;

	public RepositorioAlocacao() {
		this.colecao = new ArrayList<Alocacao>();
		this.ultimoIDadicionado = 0;
	}
	
	public Alocacao inserir(Alocacao item ) {
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

	public ArrayList<Alocacao> procuraTodos() {
		return new ArrayList<>(colecao);
	}
}
