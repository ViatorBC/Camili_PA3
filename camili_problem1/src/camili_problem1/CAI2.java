package camili_problem1;
import java.security.SecureRandom;
import java.util.Scanner;

//-------------------------------------------------------------------------------------------------------------------------------------------//
public class CAI2 {
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// variables used are result and student answer 
	private static int result = 0;
	private static int student_answer = 0;
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	public static void quiz() {
		// ask the question and generate the answer
		askQuestion();
		// read the response to the answer 
		readResponse();
		// check if the response is true and if not display
		// the incorrect response message and try again
		while(isAnswerCorrect(student_answer) != true) {
			displayIncorrectResponse();
			readResponse();
		}
		// after done display the correct response
		displayCorrectResponse();
		
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this asks the question and creates the answer
	public static void askQuestion() {
		SecureRandom rand = new SecureRandom();
		int randomNum1 = rand.nextInt(10);
		int randomNum2 = rand.nextInt(10);
		result = randomNum1 * randomNum2;
		System.out.println("What is " + randomNum1 +" multiplied by " + randomNum2 + "?");
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this reads in the response and writes it to student_answer
	public static void readResponse() {
		Scanner ans = new Scanner(System.in);
		student_answer = ans.nextInt();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this checks whether the answer is correct or not
	public static boolean isAnswerCorrect(int answer) {
		if(answer == result)
			return true;
		else
			return false;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this chooses one of four random responses if they got the right answer
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
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this chooses one of four random responses if they got the wrong answer
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
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// main function with only quiz()
	public static void main(String [] args) {
		quiz();
	}
}