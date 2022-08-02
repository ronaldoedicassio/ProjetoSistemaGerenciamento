package br.edu.ies.gerenciamento.alocacao.cli;

import br.edu.ies.gerenciamento.alocacao.modelo.Departamento;
import br.edu.ies.gerenciamento.alocacao.modelo.Professor;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioDepartamento;
import br.edu.ies.gerenciamento.alocacao.negocio.NegocioProfessor;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.CPFQuantidadeCaracteresException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.CpfDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.DepartamentoInexistenteException;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeDuplicadoExcepetion;
import br.edu.ies.gerenciamento.alocacao.negocio.exception.NomeInvalidoException;
import br.edu.ies.gerenciamento.alocacao.repositorio.RepositorioDepartamento;

public class ProfessorInterface {

	public ProfessorInterface(NegocioProfessor negocioProfessor, NegocioDepartamento negocioDepartamento)
			throws NomeInvalidoException, CpfDuplicadoExcepetion, CPFQuantidadeCaracteresException,
			NomeDuplicadoExcepetion, DepartamentoInexistenteException {

		ScannerAvancado scanner = new ScannerAvancado();

		while (true) {
			String departamentoProfessor = scanner
					.pedirString("Forneca o departamento que o professor pertence\nDigitar SAIR para finalizar => ");

			if (departamentoProfessor.toUpperCase().equals("SAIR")) {
				break;
			}
			try {
				Departamento departamento = negocioProfessor.isDepartamento(departamentoProfessor, negocioDepartamento);
				String cpfProfessor = scanner.pedirString("Forneca CPF do professor ");
				negocioProfessor.validarCPF(cpfProfessor);
				String nomeProfessor = scanner.pedirString("Forneca Nome do professor ");
				negocioProfessor.validarNome(nomeProfessor);
				negocioProfessor.inserir(new Professor(nomeProfessor, cpfProfessor, departamento));
			} catch (NomeDuplicadoExcepetion nde) {
				System.out.println(nde.getTipoOndeOcorreuNomeDuplicado());
			} catch (DepartamentoInexistenteException di) {
				System.out.println(di.getDepartamentoInexistente());
			} catch (CpfDuplicadoExcepetion cpfd) {
				System.out.println(cpfd.getCpfduplicado());
			} catch (CPFQuantidadeCaracteresException cpfqtd) {
				System.out.println(cpfqtd.getqtdCaracteresCPF());
			}
		}

		for (Professor professor : negocioProfessor.procuraTodos()) {
			System.out.println(professor);
		}
	}

}
