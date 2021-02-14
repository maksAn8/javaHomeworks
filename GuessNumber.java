import java.util.Scanner;

public class GuessNumber {

	private int generatedNumber, attemptsLeft, difference;
	private int upperLimit, lowerLimit, userGuess, userTry;
	private static int defaultUpperLimit = 100, defaultLowerLimit = 1, defaultAttempts = 5;
	private static int maxLimit = 200, minLimit = 1, minAttempts = 1, maxAttempts = 15;
	private Scanner scanner;
	
	public GuessNumber() {
		this(defaultLowerLimit, defaultUpperLimit, defaultAttempts); //default settings for game
	}
	
	public GuessNumber(int lowerLimit, int upperLimit, int attempts) {
		scanner = new Scanner(System.in);
		if(isValidSettings(lowerLimit, minLimit, maxLimit)) {
			this.lowerLimit = lowerLimit;
		} else {
			this.lowerLimit = defaultLowerLimit;
		}
		if(isValidSettings(upperLimit, minLimit, maxLimit)) {
			this.upperLimit = upperLimit;
		} else {
			this.upperLimit = defaultUpperLimit;
		}
		if(isValidSettings(attempts, minAttempts, maxAttempts)) {
			attemptsLeft = attempts;
		} else {
			attemptsLeft = defaultAttempts;
		}
		
	}
	
	public void start() {
		generateNumber();
		while(attemptsLeft != 0) {
			userGuess = getUserGuess();
			if(userGuess == generatedNumber) {
				System.out.println(String.format("Congratulations! You guessed the number in %s attempt(s)", ++userTry));
				exit();
			} else if(userTry == 0) {
				userTry++;
				difference = Math.abs(generatedNumber - userGuess);
				System.out.println(String.format("Try again! %s attempt(s) left", --attemptsLeft));
			} else if(attemptsLeft == 1) {
				attemptsLeft--;
				System.out.println("Game over!");
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
		exit();
	}
	
	private void generateNumber() {
		generatedNumber = lowerLimit + (int)(Math.random() * (upperLimit - lowerLimit + 1));
		System.out.println(String.format("Hi, I thought of a number from %s to %s. Try to guess it in %s attempt(s)!",
				lowerLimit, upperLimit, attemptsLeft));
	}
	
	private int getUserGuess() {
		int userGuess = 0;
		boolean isValid = false;
		while(!isValid) {
			while(!scanner.hasNextInt()) {
				if(scanner.next().toLowerCase().equals("exit")) {
					exit();
				} else {
					System.out.println("Incorrect input data! Try again...");
				}
			}
			userGuess = scanner.nextInt();
			if (userGuess < minLimit ) {
				System.out.println(String.format("The number can not be less than %s.", minLimit));
			} else if(userGuess > maxLimit) {
				System.out.println(String.format("The number can not be more than %s.", maxLimit));
			} else {
				isValid = true;
			}
		}
		return userGuess;
	}
	
	private boolean isValidSettings(int value, int lowerLimit, int upperLimit) {
		boolean isValid = false;
		if (value < lowerLimit ) {
			System.out.println(String.format("The number can not be less than %s.", lowerLimit));
		} else if(value > upperLimit) {
			System.out.println(String.format("The number can not be more than %s.", upperLimit));
		} else {
			isValid = true;
		}
		return isValid;
	}
	
	private void exit() {
		System.out.println("Application is closed.");
		System.exit(0);
	}
}
