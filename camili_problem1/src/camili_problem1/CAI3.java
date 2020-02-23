package camili_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {

	// declaration of variables
	private static int result = 0;
	private static int student_answer = 0;
	private static int correctAnswers = 0;
	private static int incorrectAnswers = 0;
	private static int total = 0;
	
	// quiz function
	public static void quiz() {
		int i = 0;
		// loops through indefinitely and every time it hits 10 it prints the finish prompt
		while(i == 0) {
			// asks a question
			askQuestion();
			// reads the response
			readResponse();
			// if the answer is incorrect display the incorrect response and increment incorrectAnswers by 1
			if(isAnswerCorrect(student_answer) != true) {
				if(incorrectAnswers + correctAnswers != 10)
					displayIncorrectResponse();
				incorrectAnswers++;
			}
			// if the answer is correct display the correct response and increment correctAnswers by 1
			else if(isAnswerCorrect(student_answer) == true) {
				if(incorrectAnswers + correctAnswers != 10)
					displayCorrectResponse();
				correctAnswers++;
			}
			// when incorrect answers and correct answers added equals 10 deploy the prompt
			if(incorrectAnswers + correctAnswers == 10) {
				finishPrompt();
				i = tryAgain();
			}
		}
	}
	
	// asks a random multiplication question
	public static void askQuestion() {
		SecureRandom rand = new SecureRandom();
		int randomNum1 = rand.nextInt(10);
		int randomNum2 = rand.nextInt(10);
		result = randomNum1 * randomNum2;
		System.out.println("What is " + randomNum1 +" multiplied by " + randomNum2 + "?");
	}
	
	// reads the response
	public static void readResponse() {
		Scanner ans = new Scanner(System.in);
		student_answer = ans.nextInt();
	}
	
	// checks if the answer is correct
	public static boolean isAnswerCorrect(int answer) {
		if(answer == result)
			return true;
		else
			return false;
	}
	
	// displays the positive reinforcement
	public static void displayCorrectResponse() {
		SecureRandom rand = new SecureRandom();
		int randNumber = (rand.nextInt(4) + 1);
		switch(randNumber) {
			case 1:
				System.out.println("Very good!");
				break;
			case 2:
				System.out.println("Excellent!");
				break;
			case 3:
				System.out.println("Nice work!");
				break;
			case 4:
				System.out.println("Keep up the good work!");
				break;
		}

	}
	// displays the positive reinforcement 
	public static void displayIncorrectResponse() {
		SecureRandom rand = new SecureRandom();
		int randNumber = (rand.nextInt(4) + 1);
		switch(randNumber) {
			case 1:
				System.out.println("No. Please try again.");
				break;
			case 2:
				System.out.println("Wrong. Try once more.");
				break;
			case 3:
				System.out.println("Don’t give up!");
				break;
			case 4:
				System.out.println("No. Keep trying.");
				break;
		}
	}
	
	// calculates the total grade
	public static void calculateTotal() {
		total = (100 - incorrectAnswers*10);
		System.out.println("You made a " + total +"%");
		if(total >= 75)
			System.out.println("Congratulations, you are ready to go to the next level!");
		else if(total < 75)
			System.out.println("Please ask your teacher for extra help.");
	}
	
	// resets the correctAnsers, incorrectAnswers, and the total. 
	public static void resetAll() {
		correctAnswers = 0;
		incorrectAnswers = 0;
		total = 0;
	}
	
	// a finish prompt for when you do the 10 question quiz.
	public static void finishPrompt() {
		System.out.println();
		System.out.println("===============================================================");
		System.out.println("===============================================================");
		calculateTotal();
		resetAll();
		System.out.println("===============================================================");
		System.out.println("===============================================================");
		System.out.println();
		System.out.println();
	}
	// felt wrong to not have a try again function to act like a 
	// program terminator isntead of having it constantly resetting
	public static int tryAgain() {
		Scanner response = new Scanner(System.in);
		System.out.println("Would you like to reset?");
		System.out.println("Enter 0 to reset and 1 to exit.");
		int choice = response.nextInt();
		System.out.println();
		System.out.println();
		return choice;
	}
	public static void main(String [] args) {
		quiz();
	}
}
