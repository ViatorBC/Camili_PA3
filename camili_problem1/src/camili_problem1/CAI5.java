package camili_problem1;
import java.security.SecureRandom;
import java.util.Scanner;
import java.text.DecimalFormat;

// for this one i found it a lot easier to scrap some of the things from before 
// and completely change up some functions and formatting. 
// also i was not sure how you would like division answered so i did it in decimal format
// for simplicities sake .

//-------------------------------------------------------------------------------------------------------------------------------------------//
public class CAI5 {
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// declaration of field variables
	private static float result = 0;
	private static float student_answer = 0;
	private static int correctAnswers = 0;
	private static int incorrectAnswers = 0;
	private static int total = 0;
	private static int difficulty = 0;
	private static int typeOfQuestion = 0;
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// quiz function
	public static void quiz() {
		int i = 0;
		// loops through indefinitely and every time it hits 10 it prints the finish prompt
		while(i == 0) {
			// asks for the difficulty
			difficultyRating();
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
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// this method determines the difficulty rating
	public static void difficultyRating() {
		Scanner ans = new Scanner(System.in);
		// the only ratings we have are 1-4 so any time it goes outside that it loops around 
		// asking them to input the right option
		while(difficulty < 1 || difficulty > 4) {
			
			System.out.println("Difficulty 1,2,3,4. (1-4)");
			System.out.println("Enter the difficulty rating:");
			
			difficulty = ans.nextInt();
			
			if( difficulty > 4 || difficulty < 1){
				System.out.println("Wrong Choice, Try Again.");
				System.out.println();
			}
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// asks a random multiplication question
	public static void askQuestion() {
		SecureRandom rand = new SecureRandom();
		// we declare the variables here because it looks cleaner
		// and resets the variables after each question
		int randomNum1 = 0, randomNum2 = 0;
		
		switch(difficulty) {
			// if the difficulty is 1 its between 1-9
			case 1: 
				randomNum1 = rand.nextInt(10);
				randomNum2 = rand.nextInt(10);
				break;
			// if the difficulty is 2 its between 1-99
			case 2:
				randomNum1 = rand.nextInt(100);
				randomNum2 = rand.nextInt(100);
				break;
			// if the difficulty is 3 its between 1-999
			case 3:
				randomNum1 = rand.nextInt(1000);
				randomNum2 = rand.nextInt(1000);
				break;
			// if the difficulty is 4 its between 1-9999
			case 4:
				randomNum1 = rand.nextInt(10000);
				randomNum2 = rand.nextInt(10000);
				break;
		}
		typeOfProblem(randomNum1, randomNum2);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	public static void typeOfProblem(int randomNum1, int randomNum2) {
		Scanner ans = new Scanner(System.in);
		SecureRandom rand = new SecureRandom();
		DecimalFormat df = new DecimalFormat("#.#####");
		
		if(typeOfQuestion == 0) {
			System.out.println("What Type of Question would you like to solve? ");
			System.out.println("1 for addition, 2 for multiplication, 3 for subraction, 4 for division, and 5 for mixed.");
			typeOfQuestion = ans.nextInt();
		}
		
		switch(typeOfQuestion) {
			case 1: 
				result = randomNum1 + randomNum2;
				System.out.println("What is " + randomNum1 +" plus " + randomNum2 + "?");
				break;
			case 2:
				result = randomNum1 * randomNum2;
				System.out.println("What is " + randomNum1 +" multiplied by " + randomNum2 + "?");
				break;
			case 3:
				result = randomNum1 - randomNum2;
				System.out.println("What is " + randomNum1 +" minus " + randomNum2 + "?");
				break;
				
			case 4:
				result = (float)randomNum1 / (float)randomNum2;
				System.out.println("What is " + randomNum1 +" divided by " + randomNum2 + "? (to the eight decimal place)");
				System.out.println(result);
				
				break;
			case 5:
				int randomNumber = (rand.nextInt(4) + 1);
				switch(randomNumber) {
					case 1: 
							result = randomNum1 + randomNum2;
							System.out.println("What is " + randomNum1 +" plus " + randomNum2 + "?");
							break;
					case 2:
						result = randomNum1 * randomNum2;
						System.out.println("What is " + randomNum1 +" multiplied by " + randomNum2 + "?");
						break;
					case 3:
						result = randomNum1 - randomNum2;
						System.out.println("What is " + randomNum1 +" minus " + randomNum2 + "?");
						break;
					case 4:
						result = (float)randomNum1 / (float)randomNum2;
						System.out.println("What is " + randomNum1 +" divided by " + randomNum2 + "? (to the eight decimal place)");
						break;
				}
				break;
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// reads the response
	public static void readResponse() {
		Scanner ans = new Scanner(System.in);
		student_answer = ans.nextFloat();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// checks if the answer is correct
	public static boolean isAnswerCorrect(float answer) {
		if(answer == result)
			return true;
		else
			return false;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
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
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
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
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// calculates the total grade
	public static void calculateTotal() {
		total = (100 - incorrectAnswers*10);
		System.out.println("You made a " + total +"%");
		if(total >= 75)
			System.out.println("Congratulations, you are ready to go to the next level!");
		else if(total < 75)
			System.out.println("Please ask your teacher for extra help.");
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// resets the correctAnsers, incorrectAnswers, and the total. 
	public static void resetAll() {
		correctAnswers = 0;
		incorrectAnswers = 0;
		total = 0;
		difficulty = 0;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
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
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	// after the first part we had to have the program reset
	// i felt like we needed an exit condition for the program 
	// instead of constantly resetting.
	public static int tryAgain() {
		Scanner response = new Scanner(System.in);
		System.out.println("Would you like to reset?");
		System.out.println("Enter 0 to reset and 1 to exit.");
		int choice = response.nextInt();
		System.out.println();
		System.out.println();
		return choice;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------//
	public static void main(String [] args) {
		quiz();
	}
}
