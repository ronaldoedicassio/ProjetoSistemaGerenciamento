package br.edu.ies.gerenciamento.alocacao.cli;

import java.util.Scanner;

import br.edu.ies.gerenciamento.alocacao.modelo.AreaDepartamento;

public class ScannerAvancado {
	private Scanner scanner;

	public ScannerAvancado() {
		scanner = new Scanner(System.in);
	}

	public double pedirDouble(String textoPedido) {
		return pedirDouble(textoPedido, 0);
	}

	public double pedirDouble(String textoPedido, int tentativas) {
		try {
			System.out.println(textoPedido);
			String valorLido = scanner.nextLine();
			double valorInicial = Double.parseDouble(valorLido);
			return valorInicial;
		} catch (NumberFormatException numberFormatException) {
			System.out.println("O valor informado não é número, favor inserir um número");
			return pedirDouble(textoPedido, ++tentativas);
		}
	}

	public int pedirInt(String textoPedido) {
		try {
			System.out.println(textoPedido);
			String valorLido = scanner.nextLine();
			int valorInicial = Integer.parseInt(valorLido);
			return valorInicial;
		} catch (NumberFormatException numberFormatException) {
			System.out.println("O valor informado não é número, favor inserir um número");
			return pedirInt(textoPedido);
		}
	}

	public String pedirString(String textoPedido) {

		System.out.println(textoPedido);
		String valorLido = scanner.nextLine();
		return valorLido;

	}

	public AreaDepartamento pedirAreaDepartamento() {
		AreaDepartamento area = null;

		String op = pedirString("Escolha a area: \n" + "\tB => Biologicas\n" + "\tE => Exatas\n" + "\tH => Humanas");

		while (area == null) {
			if (op.equals("B")) {
				area = AreaDepartamento.Biologicas;
			} else if (op.equals("E")) {
				area = AreaDepartamento.Exatas;
			} else if (op.equals("H")) {
				area = AreaDepartamento.Humanas;
			} else {
				System.out.println("\nOpcao invalida, tente novamente, escolha opção correta");
				op = pedirString("Escolha a area: \n" + "\tB => Biologicas\n" + "\tE => Exatas\n" + "\tH => Humanas");
			}
		}

		return area;
	}
}
