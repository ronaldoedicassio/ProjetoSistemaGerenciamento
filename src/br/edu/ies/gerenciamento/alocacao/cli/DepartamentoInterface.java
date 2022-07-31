package br.edu.ies.gerenciamento.alocacao.cli;

import br.edu.ies.gerenciamento.alocacao.modelo.AreaDepartamento;
import br.edu.ies.gerenciamento.alocacao.modelo.Departamento;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioCurso;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioDepartamento;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioCurso;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.NomeInvalidoException;
import br.edu.ies.gerenciamento.alocacao.repositorio.exceptions.SiglaDuplicadoExcepetion;

public class DepartamentoInterface {

	public DepartamentoInterface(NegocioDepartamento negocioDepartamento, NegocioCurso negocioCurso, RepositorioCurso repositorioCurso)
			throws SiglaDuplicadoExcepetion {
		ScannerAvancado scanner = new ScannerAvancado();

		while (true) {
			String nomeDepto = scanner
					.pedirString("Digite um departamento a ser inserido, ou digite SAIR para finalizar");

			if (nomeDepto.toUpperCase().equals("SAIR")) {
				break;
			}

			try {
				negocioDepartamento.validarNome(nomeDepto);
				String siglaDepartamento = scanner.pedirString("Forneca a sigla do departamento");
				negocioDepartamento.validarSigla(siglaDepartamento, negocioCurso,repositorioCurso);
				AreaDepartamento area = scanner.pedirAreaDepartamento();
				negocioDepartamento.inserir(new Departamento(nomeDepto, area, siglaDepartamento));

			} catch (NomeDuplicadoExcepetion nde) {
				System.out.println(nde.getTipoOndeOcorreuNomeDuplicado());
			} catch (NomeInvalidoException nie) {
				System.out.println("Nome foi invalido " + nie.getTipoErro());
			} catch (SiglaDuplicadoExcepetion sde) {
				System.out.println(sde.getSiglaDuplicada());
			}
		}

		for (Departamento departamento : negocioDepartamento.procuraTodos()) {
			System.out.println(departamento);
		}
	}

}
