package br.edu.ies.gerenciamento.alocacao.cli;

import br.edu.ies.gerenciamento.alocacao.modelo.Alocacao;
import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioAlocacao;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioCurso;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioProfessor;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.AlocacaoExistenteExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.CursoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DataHoraExistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoCursoDifrenteProfessorException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeProfessorInexisteException;

public class AlocacaoInterface {

	public AlocacaoInterface(NegocioAlocacao negocioAlocacao, NegocioProfessor negocioProfessor,
			NegocioCurso negocioCurso) {

		ScannerAvancado scanner = new ScannerAvancado();

		while (true) {
			String nomeProfessor = scanner.pedirString(
					"Forneca o Nome do professor para realizar alocacao em um curso\nDigitar SAIR para finalizar => ");

			if (nomeProfessor.toUpperCase().equals("SAIR")) {
				break;
			}

			try {
				Professor professor = negocioAlocacao.procuraProfessor(nomeProfessor, negocioProfessor);
				String nomeCurso = scanner.pedirString("Forneça o curso que o professor sera alocado ");
				Curso curso = negocioAlocacao.procurarCurso(nomeCurso, negocioCurso);
				String data = scanner.pedirString("Dia da semana da alocacao ");
				String hora = scanner.pedirString("Hora da alocacao");

				negocioAlocacao.inserir(new Alocacao(professor, curso, data, hora));

			} catch (NomeProfessorInexisteException nie) {
				System.out.println(nie.getMessage());
			} catch (CursoInexistenteException cie) {
				System.out.println(cie.getMessage());
			} catch (AlocacaoExistenteExcepetion aee) {
				System.out.println(aee.getAlocacaoExistenteExcepetion());
			} catch (DepartamentoCursoDifrenteProfessorException dcpe) {
				System.out.println(dcpe.getDepartamentoCursoDifrenteProfessorException());
			} catch (DataHoraExistenteException dhee) {
				System.out.println(dhee.getDataHoraExistenteException());
			}

		}
		for (Alocacao alocacao : negocioAlocacao.procuraTodos()) {
			System.out.println(alocacao);
		}
	}

}
