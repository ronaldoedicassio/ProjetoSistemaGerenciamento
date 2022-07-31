package br.edu.ies.gerenciamento.alocacao.negocio;

import java.util.ArrayList;

import br.edu.ies.gerenciamento.alocacao.modelo.Alocacao;
import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioAlocacao;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.CursoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeProfessorInexisteException;

public class NegocioAlocacao {
	
	private RepositorioAlocacao repositorioAlocacao;
	private NegocioProfessor negocioProfessor;
	private NegocioCurso negocioCurso;
	
	public NegocioAlocacao(RepositorioAlocacao repositorioAlocacao, NegocioProfessor negocioProfessor, NegocioCurso negocioCurso) {
		super();
		this.repositorioAlocacao = repositorioAlocacao;
		this.negocioProfessor = negocioProfessor;
		this.negocioCurso = negocioCurso;
	}
	
	public ArrayList<Alocacao> procuraTodos() {
		return repositorioAlocacao.procuraTodos();		
	}
	
	public Alocacao inserir(Alocacao alocacao) {
		return repositorioAlocacao.inserir(alocacao);
	}

	public Professor procuraProfessor(String nomeProfessor, NegocioProfessor negocioProfessor) throws NomeProfessorInexisteException {
		
		return negocioProfessor.procuraNome(nomeProfessor);
	}

	public Curso procurarCurso(String nomeCurso, NegocioCurso negocioCurso) throws CursoInexistenteException {
		Curso item = null;
		item = negocioCurso.procuraNome(nomeCurso);
		
		if(item != null) {
			return item;
		}else {
			throw new CursoInexistenteException();
		}
	}

}
