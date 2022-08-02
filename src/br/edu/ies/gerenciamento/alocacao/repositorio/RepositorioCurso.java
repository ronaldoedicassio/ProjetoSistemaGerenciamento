package br.edu.ies.gerenciamento.alocacao.repositorio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeInvalidoException;

public class RepositorioCurso {

	private ArrayList<Curso> colecao;
	private int ultimoIDadicionado;

	public RepositorioCurso() {
		colecao = new ArrayList<Curso>();
		ultimoIDadicionado = 0;
	}

	public Curso inserir(Curso item) throws NomeInvalidoException, NomeDuplicadoExcepetion {
		ultimoIDadicionado = ultimoIDadicionado + 1;
		item.setId(ultimoIDadicionado);
		colecao.add(item);

		return item;
	}

	public Curso procuraPorID(int id) {
		Curso item = null;

		for (Curso curso : colecao) {
			if (curso.getId() == id) {
				item = curso;
				break;
			}
		}
		return item;
	}

	public String procurarDepartamento(String nomeCurso) {
		String nomeDepartamento = null;
		for (Curso curso : colecao) {
			if (curso.getNomeCurso().equals(nomeCurso)) {
				nomeDepartamento = curso.getDepartamentoCurso().getNomeDepartamento();
				break;
			}
		}
		return nomeDepartamento;
	}

	public Curso procurarSigla(String sigla) {
		Curso item = null;
		for (Curso curso : colecao) {
			if (curso.getSiglaCurso().toLowerCase().equals(sigla.toLowerCase())) {
				item = curso;
				break;
			}
		}

		return item;
	}

	public Curso procurarPorNome(String nome) {
		Curso item = null;

		for (Curso curso : colecao) {
			if (curso.getNomeCurso().toLowerCase().equals(nome.toLowerCase())) {
				item = curso;
				break;
			}
		}
		return item;
	}

	public ArrayList<Curso> procuraTodos() {
		return new ArrayList<>(colecao);
	}

}
