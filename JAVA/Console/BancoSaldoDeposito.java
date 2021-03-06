package faesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class faesa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String saida = null;
		Double saldo = 0.0;
		Double emprestimo = 0.0;
		ArrayList<Double> saldoEmprestimo = new ArrayList<Double>();
		
		String escolha = null;
		
		Scanner s = new Scanner(System.in);

		System.out.println("A conta foi iniciada! Saldo e valor de empr�stimo est�o zerados.");
		while (saida != "sair") {

			
			
			saldoEmprestimo = programa(saldo, emprestimo);
			System.out.println();
			
			int auxiliar = 0;
			for (Double value : saldoEmprestimo){
				if (auxiliar == 0) {
					saldo = value;
				}
				else if (auxiliar == 1) {
					emprestimo = value;
				}
				auxiliar++;
			}
			
			System.out.println("Dados da conta:");
			System.out.println("Saldo: " + saldo); 
			System.out.println("Valor emprestado: " + emprestimo);
			
			System.out.println();
			System.out.print("Digite se voc� quer sair do programa ou fazer mais opera��es (sair/continuar): ");
			
			escolha = s.nextLine();
			
			try {
				if (escolha.equals("sair")) {
					saida = "sair";
				}
				else if (escolha.equals("continuar")) {
					saida = "";
				}
				else {
					System.out.println("Escolha inv�lida. Programa encerrado.");
					saida = "sair";
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
			
			System.out.println();
		}
		


	}

	public static ArrayList<Double> programa(double saldo, double emprestimo) {
		
		Double saque = 0.0;
		ArrayList<Double> saldoEmprestimo = new ArrayList<Double>();
		System.out.println();
		Scanner s = new Scanner(System.in);
		
		String escolha = null;
		
		System.out.print("Digite se voc� quer depositar ou sacar (sacar/depositar): ");
		escolha = s.nextLine();
		
		try {
			if (escolha.equals("sacar")) {
				System.out.print("Digite o valor de saque (ex.: 20,00): ");
				saque = s.nextDouble();
				
				if (saque > saldo) {
					emprestimo += (saque - saldo);
					saldo = 0;
					
				}
				
				else {
					saldo = (saldo - saque);
				}
			}
			
			else if (escolha.equals("depositar")) {
				System.out.print("Digite o valor de deposito (ex.: 20,00): ");
				saldo += s.nextDouble();			
				System.out.println("Valor depositado com sucesso!");
			}
			
			else {
				System.out.println("Escolha inv�lida.");
			}
			
			saldoEmprestimo.add(saldo); saldoEmprestimo.add(emprestimo);

		}
		
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		return saldoEmprestimo;
	}

}

