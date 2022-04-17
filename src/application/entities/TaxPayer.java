package application.entities;

public class TaxPayer {
	private double salaryIncome;
	private double serviceIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServiceIncome() {
		return serviceIncome;
	}

	public void setServiceIncome(double serviceIncome) {
		this.serviceIncome = serviceIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public double salaryTax() {
		double monthSalary, salTax;

		monthSalary = this.salaryIncome / 12.0;

		if (monthSalary > 5000)
			salTax = this.salaryIncome * 0.2;
		else if (monthSalary > 3000)
			salTax = this.salaryIncome * 0.1;
		else
			salTax = 0;

		return salTax;
	}

	public double servicesTax() {
		return this.serviceIncome * 0.15;
	}

	public double capitalTax() {
		return this.capitalIncome * 0.2;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double taxTotal, deductibleValue, rebateMax, rebateValue;

		taxTotal = grossTax();
		rebateMax = taxTotal * 0.3;
		deductibleValue = this.healthSpending + this.educationSpending;

		if (deductibleValue > rebateMax)
			rebateValue = rebateMax;
		else
			rebateValue = deductibleValue;

		return rebateValue;
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}
}
