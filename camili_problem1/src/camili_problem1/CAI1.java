package camili_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

//-------------------------------------------------------------------------------------------------------------------------------------------//
public class CAI1 {
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// i saved the users input and the correct answer as 
	// private static ints. 
	private static int result = 0;
	private static int student_answer = 0;
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	public static void quiz() {
		// first we ask the question, this generates the question and answer
		askQuestion();
		// when we read the response we scan it to the student_answer variable
		readResponse();
		// we use the boolean isAnswerCorrect to check if its the right answer
		while(isAnswerCorrect(student_answer) != true) {
			// while its wrong it displays the incorrect response
			displayIncorrectResponse();
			// and allows the user to put in their response again
			readResponse();
		}
		// this displays the correct message after the while loop 
		displayCorrectResponse();	
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// we make a new random object and generate 2 random numbers and assign them
	// then we make the result equal to the multiplication of the two and ask the question
	public static void askQuestion() {
		SecureRandom random = new SecureRandom();
		int randomNum1 = random.nextInt(10);
		int randomNum2 = random.nextInt(10);
		result = randomNum1 * randomNum2;
		System.out.println("What is " + randomNum1 +" multiplied by " + randomNum2 + "?");
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this scans in the response and puts the users answer in student_answer
	public static void readResponse() {
		Scanner ans = new Scanner(System.in);
		student_answer = ans.nextInt();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this checks if the answer is correct if it is it returns true if not then false
	public static boolean isAnswerCorrect(int answer) {
		if(answer == result)
			return true;
		else
			return false;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this displays the response if the answer is correct
	public static void displayCorrectResponse() {
		System.out.println("Very good!");
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this displays the response if the answer is wrong
	public static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// main function with only quiz() in it
	public static void main(String [] args) {
		quiz();
	}
}
