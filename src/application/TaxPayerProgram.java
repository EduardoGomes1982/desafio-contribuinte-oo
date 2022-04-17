package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import application.entities.TaxPayer;

public class TaxPayerProgram {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos Contribuintes Você vai Digitar? ");
		int payersNumber = sc.nextInt();
		List<TaxPayer> taxPayers = new ArrayList<>();
		System.out.println();
		
		for (int i = 0; i < payersNumber; i++) {
			TaxPayer tp = new TaxPayer();
			System.out.printf("Digite os Dados do %do Contribuinte:%n", i + 1);
			System.out.print("Renda Anual com Salário: ");
			tp.setSalaryIncome(sc.nextDouble());
			System.out.print("Renda Anual com Prestação de Serviços: ");
			tp.setServiceIncome(sc.nextDouble());
			System.out.print("Renda Anual com Ganho de Capital: ");
			tp.setCapitalIncome(sc.nextDouble());
			System.out.print("Gastos Médicos: ");
			tp.setHealthSpending(sc.nextDouble());
			System.out.print("Gastos Educacionais: ");
			tp.setEducationSpending(sc.nextDouble());
			taxPayers.add(tp);
			System.out.println();
		}

		for (int i = 0; i < taxPayers.size(); i++) {
			System.out.printf("Resumo do %do Contribuinte:%n", i + 1);
			System.out.printf("Imposto bruto total: %.2f%n", taxPayers.get(i).grossTax());
			System.out.printf("Abatimento: %.2f%n", taxPayers.get(i).taxRebate());
			System.out.printf("Imposto devido: %.2f%n", taxPayers.get(i).netTax());
			System.out.println();
		}

		sc.close();
	}
}
