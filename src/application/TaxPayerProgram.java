package application;

import java.util.Locale;
import java.util.Scanner;

import application.entities.TaxPayer;

public class TaxPayerProgram {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos Contribuintes Você vai Digitar? ");
		int payersNumber = sc.nextInt();
		TaxPayer[] tp = new TaxPayer[payersNumber];
		System.out.println();
		
		for (int i = 0; i < tp.length; i++) {
			tp[i] = new TaxPayer();
			System.out.printf("Digite os Dados do %do Contribuinte:%n", i + 1);

			System.out.print("Renda Anual com Salário: ");
			tp[i].setSalaryIncome(sc.nextDouble());
			System.out.print("Renda Anual com Prestação de Serviços: ");
			tp[i].setServiceIncome(sc.nextDouble());
			System.out.print("Renda Anual com Ganho de Capital: ");
			tp[i].setCapitalIncome(sc.nextDouble());
			System.out.print("Gastos Médicos: ");
			tp[i].setHealthSpending(sc.nextDouble());
			System.out.print("Gastos Educacionais: ");
			tp[i].setEducationSpending(sc.nextDouble());
		}

		for (int i = 0; i < tp.length; i++) {
			System.out.println();
			System.out.printf("Resumo do %do Contribuinte:%n", i + 1);
			System.out.printf("Imposto bruto total: %.2f%n", tp[i].grossTax());
			System.out.printf("Abatimento: %.2f%n", tp[i].taxRebate());
			System.out.printf("Imposto devido: %.2f%n", tp[i].netTax());
		}

		sc.close();
	}
}
