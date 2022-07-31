package br.edu.ies.gerenciamento.alocacao.repositorio;

import java.awt.geom.Area;
import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Departamento;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeInvalidoException;

public class RepositorioDepartamento {

	private ArrayList<Departamento> colecao;
	private int ultimoIDadicionado;

	public RepositorioDepartamento() {
		colecao = new ArrayList<Departamento>();
		ultimoIDadicionado = 0;
	}

	public Departamento inserir(Departamento item) throws NomeInvalidoException, NomeDuplicadoExcepetion {
		ultimoIDadicionado = ultimoIDadicionado + 1;
		item.setId(ultimoIDadicionado);
		colecao.add(item);

		return item;
	}

	public Departamento procuraPorID(int id) {
		Departamento item = null;

		for (Departamento departamento : colecao) {
			if (departamento.getId() == id) {
				item = departamento;
				break;
			}
		}
		return item;
	}

	public Departamento procurarPorNome(String nome) {
		Departamento item = null;

		for (Departamento departamento : colecao) {
			if (departamento.getNomeDepartamento().toLowerCase().equals(nome.toLowerCase())) {
				item = departamento;
				break;
			}
		}
		return item;
	}

	public Departamento procuraSigla(String sigla) {
		Departamento item = null;
		for (Departamento departamento : colecao) {
			if (departamento.getSiglaDepartamento().toLowerCase().equals(sigla.toLowerCase())) {
				item = departamento;
				break;
			}
		}

		return item;
	}

//	public Departamento procuraSigla(String sigla, RepositorioCurso repositorioCurso) {
//		Departamento item = null;
//		for (Departamento departamento : colecao) {
//			if (departamento.getSiglaDepartamento().toLowerCase().equals(procuraSiglaCurso(sigla, repositorioCurso))) {
//				item = departamento;
//				break;
//			}
//		}
//
//		return item;
//	}

	public Curso procuraSiglaCurso(String sigla, RepositorioCurso repositorioCurso) {
		return repositorioCurso.procurarSigla(sigla);
	}

	public boolean delatarPorId(int id) {
		Departamento item = procuraPorID(id);

		if (item != null) {
			colecao.remove(item);
			return true;
		} else {
			return false;
		}
	}

	public boolean modificarNome(String nomeAtual, String nomeNovo) {
		Departamento item = procurarPorNome(nomeAtual);

		if (item != null) {
			item.setNomeDepartamento(nomeNovo);
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Departamento> procuraTodos() {
		return new ArrayList<>(colecao);
	}
}
