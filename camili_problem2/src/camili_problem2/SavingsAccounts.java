package camili_problem2;

import java.text.DecimalFormat;

public class SavingsAccounts {

	private double annualInterestRate = 0;
	private static double savingsBalance = 0;
	DecimalFormat df = new DecimalFormat("#.##");
			
	
	
	public SavingsAccounts(double balance, double interestRate) {
		// to test the overloaded constructor 
		// System.out.println("ooooh! fancy construction time boiiiiii <3.");
		annualInterestRate = interestRate;
		savingsBalance = balance;
	}
	
	// private method to calculate the monthly interest rate. 
	private double calculateMonthlyInterest() {
		double monthlyRate = annualInterestRate/12;
		savingsBalance = savingsBalance + ((savingsBalance*annualInterestRate)/12);
		return monthlyRate;
	}
	
	// public method to print out the monthly interest
	public void printMonthlyInterest() {
		System.out.println(df.format(100*calculateMonthlyInterest()) + "%");
	}
	
	// sets the annual interest rate 
	public void modifyInterestRate(double newRate){
		annualInterestRate = newRate;
	}
	
	// sets the balance, wasnt needed but felt wrong not to include 
	public void setSavingsBalance(double newBal){
		savingsBalance = newBal;
	}
	
	// prints the balance 
	public void printBal() {
		System.out.println("Current Balance is $" + df.format(savingsBalance));
		System.out.println();
	}
	
	// prints the annual interes rate, wasnt needed but felt wrong not to include
	public void printRate() {
		System.out.println("Annual Interest Rate is " + annualInterestRate*100 + "%");
		System.out.println();
	}
}
