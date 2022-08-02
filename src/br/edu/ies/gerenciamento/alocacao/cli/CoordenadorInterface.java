package br.edu.ies.gerenciamento.alocacao.cli;

import br.edu.ies.gerenciamento.alocacao.modelo.AreaDepartamento;
import br.edu.ies.gerenciamento.alocacao.modelo.Coordenador;
import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Departamento;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioCoordenador;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioCurso;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioProfessor;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.CursoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoCursoDifrenteProfessorException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeInvalidoException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeProfessorInexisteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.SiglaDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioCurso;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioProfessor;

public class CoordenadorInterface {

	public CoordenadorInterface(NegocioCoordenador negocioCoordenador, NegocioCurso negocioCurso,
			NegocioProfessor negocioProfessor) throws DepartamentoCursoDifrenteProfessorException,
			NomeProfessorInexisteException, CursoInexistenteException {

		ScannerAvancado scanner = new ScannerAvancado();

		String nomeCoordenador = scanner
				.pedirString("Digite o nome do professor que sera coordenador, ou digite SAIR para finalizar");

		while (!nomeCoordenador.toUpperCase().equals("SAIR")) {

			try {
				Professor professorCoordenador = negocioCoordenador.validarCoordenador(nomeCoordenador,
						negocioProfessor);
				String cursoCoordenado = scanner.pedirString("Forneca o curso a ser coordenado");
				negocioCoordenador.validarCurso(cursoCoordenado, negocioCurso);
				Curso curso = negocioCoordenador.isPertenceDepartamento(cursoCoordenado, nomeCoordenador, negocioCurso,
						negocioProfessor);

				negocioCoordenador.inserir(new Coordenador(nomeCoordenador, professorCoordenador.getCpf(),
						professorCoordenador.getDepartamento(), curso));

			} catch (NomeDuplicadoExcepetion nde) {
				System.out.println(nde.getTipoOndeOcorreuNomeDuplicado());
			} catch (NomeInvalidoException nie) {
				System.out.println("Nome foi invalido " + nie.getTipoErro());
			} catch (CursoInexistenteException cie) {
				System.out.println(cie.getMessage());
			} 

			nomeCoordenador = scanner
					.pedirString("Digite o nome do professor que sera coordenador, ou digite SAIR para finalizar");
		}

		for (Coordenador coordenador : negocioCoordenador.procuraTodos()) {
			System.out.println(coordenador);
		}
	}

}
