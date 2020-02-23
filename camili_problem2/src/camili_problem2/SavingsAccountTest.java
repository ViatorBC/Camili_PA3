package camili_problem2;

public class SavingsAccountTest {
	
	public static void main(String [] args) {
		
		SavingsAccounts saver1 = new SavingsAccounts(2000, 0.04);
		for(int  i = 1; i < 13; i++) {
			System.out.println("Month " + i + " interest rate is:");
			saver1.printMonthlyInterest();
			saver1.printBal();
			System.out.println();
		}
		saver1.modifyInterestRate(0.05);
		System.out.println("Next Months Interest is :");
		saver1.printMonthlyInterest();
		saver1.printBal();
		
		
		
		SavingsAccounts saver2 = new SavingsAccounts(3000, 0.04);
		for(int  i = 1; i < 13; i++) {
			System.out.println("Month " + i + " interest rate is:");
			saver1.printMonthlyInterest();
			saver1.printBal();
			System.out.println();
		}
		saver1.modifyInterestRate(0.05);
		System.out.println("Next Months Interest is :");
		saver1.printMonthlyInterest();
		saver1.printBal();
	}
}
