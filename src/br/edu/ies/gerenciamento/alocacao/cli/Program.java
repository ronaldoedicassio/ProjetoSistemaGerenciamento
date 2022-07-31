package br.edu.ies.gerenciamento.alocacao.cli;

import br.edu.ies.gerenciamento.alocacao.negocio.NegocioAlocacao;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioCoordenador;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioCurso;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioDepartamento;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioProfessor;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioAlocacao;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioCoordenador;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioCurso;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioDepartamento;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioProfessor;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.CPFQuantidadeCaracteresException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.CpfDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.CursoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.DepartamentoCursoDifrenteProfessorException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeInvalidoException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeProfessorInexisteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.SiglaDuplicadoExcepetion;

public class Program {

	public static void main(String[] args)
			throws NomeDuplicadoExcepetion, NomeInvalidoException, DepartamentoInexistenteException,
			CpfDuplicadoExcepetion, DepartamentoCursoDifrenteProfessorException, NomeProfessorInexisteException,
			CursoInexistenteException, CPFQuantidadeCaracteresException, SiglaDuplicadoExcepetion {

		ScannerAvancado scanner = new ScannerAvancado();

		RepositorioDepartamento repositorioDepartamento = new RepositorioDepartamento();
		RepositorioProfessor repositorioProfessor = new RepositorioProfessor();
		RepositorioCurso repositorioCurso = new RepositorioCurso();
		RepositorioCoordenador repositorioCoordenador = new RepositorioCoordenador();
		RepositorioAlocacao repositorioAlocacao = new RepositorioAlocacao();

		NegocioDepartamento negocioDepartamento = new NegocioDepartamento(repositorioDepartamento, repositorioCurso);
		NegocioProfessor negocioProfessor = new NegocioProfessor(repositorioProfessor, negocioDepartamento);
		NegocioCurso negocioCurso = new NegocioCurso(repositorioCurso, negocioDepartamento);
		NegocioCoordenador negocioCoordenador = new NegocioCoordenador(repositorioCoordenador, negocioCurso,
				negocioProfessor);
		NegocioAlocacao negocioAlocacao = new NegocioAlocacao(repositorioAlocacao, negocioProfessor, negocioCurso);

		int op = scanner.pedirInt("\n**********************" + "*\nEscolha opcao desejada." + "\n  1 -> Departamento"
				+ "\n  2 -> Professor" + "\n  3 -> Curso" + "\n  4 -> Coordenador" + "\n  5 -> Alocacao"
				+ "\n  0 -> Sair" + "\n***********************");

		while (op != 0) {

			if (op == 1) {
				DepartamentoInterface departamentoInterface = new DepartamentoInterface(negocioDepartamento,
						negocioCurso, repositorioCurso);
			} else if (op == 2) {
				ProfessorInterface professorInterface = new ProfessorInterface(negocioProfessor, negocioDepartamento);
			} else if (op == 3) {
				CursoInterface cursoInterface = new CursoInterface(negocioCurso, negocioDepartamento);
			} else if (op == 4) {
				CoordenadorInterface coordenadorInterface = new CoordenadorInterface(negocioCoordenador, negocioCurso,
						negocioProfessor);
			} else if (op == 5) {
				AlocacaoInterface alocacaoInterface = new AlocacaoInterface(negocioAlocacao, negocioProfessor,
						negocioCurso);
			}
			op = scanner.pedirInt("\n**********************" + "*\nEscolha opcao desejada." + "\n  1 -> Departamento"
					+ "\n  2 -> Professor" + "\n  3 -> Curso" + "\n  4 -> Coordenador" + "\n  5 -> Alocacao"
					+ "\n  0 -> Sair" + "\n***********************");
		}
	}
}
