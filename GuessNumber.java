import java.util.Scanner;

public class GuessNumber {

	public int generatedNumber, attemptsLeft, difference;
	public int upperLimit, lowerLimit, userGuess, userTry;
	public Scanner scanner;
	
	public GuessNumber() {
		setUserRange();
		setUserAttempts();
	}
	
	public void start() {
		generateNumber();
		while(attemptsLeft != 0) {
			userGuess = scanner.nextInt();
			if(userGuess == generatedNumber) {
				System.out.println(String.format("Congratulations! You guessed the number in %s attempt(s)", ++userTry));
			} else if(userTry == 0) {
				userTry++;
				difference = Math.abs(generatedNumber - userGuess);
				System.out.println(String.format("Try again! %s attempt(s) left", --attemptsLeft));
			} else if(Math.abs(generatedNumber - userGuess) < difference) {
				userTry++;
				difference = Math.abs(generatedNumber - userGuess);
				System.out.println(String.format("Wrong! But you are getting warmer! %s attempt(s) left", --attemptsLeft));
			} else if(Math.abs(generatedNumber - userGuess) > difference) {
				userTry++;
				difference = Math.abs(generatedNumber - userGuess);
				System.out.println(String.format("Wrong! You are getting colder! %s attempt(s) left", --attemptsLeft));
			} else if(Math.abs(generatedNumber - userGuess) == difference) {
				userTry++;
				System.out.println(String.format("Try again! %s attempt(s) left", --attemptsLeft));
			} 
		}
		System.out.println("It was the number " + generatedNumber);
	}
	
	public void setUserRange() {
		scanner = new Scanner(System.in);
		System.out.println("Please, set lower and upper limits of the range to start a game!");
		lowerLimit = getLowerLimit(); //add validation, i.e. isValidRange(), min = 1 , max = 200
		upperLimit = getUpperLimit();
	}
	
	public int getLowerLimit() {
		return scanner.nextInt();
	}
	
	public int getUpperLimit() {
		return scanner.nextInt();
	}
	
	public boolean isValidRange() {
		return true;
	}
	
	public void setUserAttempts() {	//add validation, attempts can be from 1 to 15;
		System.out.println("Please, set amount of attempts from 1 to 15)!");
		attemptsLeft = scanner.nextInt();
	}
	
	public void generateNumber() {
		generatedNumber = lowerLimit + (int)(Math.random() * (upperLimit - lowerLimit + 1));
		System.out.println(String.format("Hi, I thought of a number from %s to %s of your range. Try to guess it in %s attempt(s)!",
				lowerLimit, upperLimit, attemptsLeft));
	}
	
}
