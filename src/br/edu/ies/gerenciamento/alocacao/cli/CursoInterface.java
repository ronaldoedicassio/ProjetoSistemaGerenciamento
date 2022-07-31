package br.edu.ies.gerenciamento.alocacao.cli;

import br.edu.ies.gerenciamento.alocacao.modelo.Curso;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioCurso;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioDepartamento;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeInvalidoException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.SiglaDuplicadoExcepetion;

public class CursoInterface {

	public CursoInterface(NegocioCurso negocioCurso, NegocioDepartamento negocioDepartamento)
			throws NomeInvalidoException {
		ScannerAvancado scanner = new ScannerAvancado();

		while (true) {
			String departamentoCurso = scanner
					.pedirString("Forneca o departamento que o curso pertence\nDigitar SAIR para finalizar => ");

			if (departamentoCurso.toUpperCase().equals("SAIR")) {
				break;
			}

			try {
				negocioCurso.isDepartamento(departamentoCurso, negocioDepartamento);
				String nomeCurso = scanner.pedirString("Forneca Nome do curso ");
				negocioCurso.validarNome(nomeCurso);
				String siglaCurso = scanner.pedirString("Forneca sigla do Curso ");
				negocioCurso.validarSigla(siglaCurso, negocioDepartamento);
				negocioCurso.inserir(new Curso(nomeCurso,
						negocioCurso.isDepartamento(departamentoCurso, negocioDepartamento), siglaCurso));
			} catch (NomeDuplicadoExcepetion nde) {
				System.out.println(nde.getTipoOndeOcorreuNomeDuplicado());
			} catch (DepartamentoInexistenteException di) {
				System.out.println(di.getDepartamentoInexistente());

			} catch (SiglaDuplicadoExcepetion sde) {
				System.out.println(sde.getSiglaDuplicada());
			}
		}
		for (Curso curso : negocioCurso.procuraTodos()) {
			System.out.println(curso);
		}
	}
}
