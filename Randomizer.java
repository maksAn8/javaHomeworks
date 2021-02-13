import java.util.Scanner;

public class Randomizer {
	
	private int upperLimit, lowerLimit, randomNumber, uniqueNumbersCounter;
	private int[] alreadyGeneratedNumbers;
	private String userCommand;
	private Scanner scanner;
	
	public Randomizer() {
		scanner = new Scanner(System.in);
	}
	
	public void start() {
		boolean isRunning = true;
		setUserRangeForRandom();
		System.out.println("Enter command: generate, help or exit");
		while(isRunning) {
			switch(getUserCommand()) {
				case "generate":
					generate();
					break;
				case "exit":
					exit();
					break;
				case "help":
					help();
					break;
				default:
					System.out.println("Wrong command was entered, try again...");
			}
		}
			
	}

	private void setUserRangeForRandom() {
		System.out.println("Please, enter lower and upper limits of the range for number generetion (limits included)");
		lowerLimit = getValidLimit();
		upperLimit = getValidLimit();
		if(lowerLimit > upperLimit) {
			int temp = lowerLimit;
			lowerLimit = upperLimit;
			upperLimit = temp;
		}
		alreadyGeneratedNumbers = new int[upperLimit - lowerLimit + 1];	
	}
	
	private int getValidLimit() {
		int limit = 0;
		boolean isValidLimit = false;
		while(!isValidLimit) {
			while(!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Incorrect limit! Try again...");
			}
			limit = scanner.nextInt();
			if (limit < 1 ) {
				System.out.println("The limit can not be less than 1");
			} else if(limit > 500) {
				System.out.println("The limit can not be more than 500");
			} else {
				isValidLimit = true;
			}
		}
		return limit;
	}
	
	private String getUserCommand() {
		return scanner.next().toLowerCase();
	}
	
	private void generateRandomNumber() {
		randomNumber = lowerLimit + (int)(Math.random() * (upperLimit - lowerLimit + 1));
	}
	
	private boolean isUniqueRandomNumber() {
		boolean isUnique = true;
		for(int alreadyGeneratedNumber : alreadyGeneratedNumbers) {
			if(randomNumber == alreadyGeneratedNumber) {
				return false;
			}
		}
		alreadyGeneratedNumbers[uniqueNumbersCounter++] = randomNumber;
		return isUnique;
	}
	
	private void generate() {
		if(uniqueNumbersCounter == upperLimit - lowerLimit + 1) {
			reset();
		} else {
			while(!isUniqueRandomNumber()) {
				generateRandomNumber();
			}
			System.out.println(randomNumber);
		}
	}
	
	private void reset() {
		System.out.println("There are no more unique numbers. Do you want to set a new range? (enter yes or no)");
		userCommand = scanner.next().toLowerCase();
		if(userCommand.equals("no")) {
			System.out.println("Application is closed.");
			System.exit(0);
		} else if(userCommand.equals("yes")) {
			uniqueNumbersCounter = lowerLimit = upperLimit = 0;
			setUserRangeForRandom();
		}
	}
	
	private void exit() {
		System.out.println("Are you sure that you want to quit the app? (enter yes or no)");
		if(scanner.next().toLowerCase().equals("yes")) {
			System.out.println("Application is closed.");
			System.exit(0);
		}
	}
	
	private void help() {
		System.out.println("Enter 'generate' to get random number. Max range: 1-500");
		System.out.println("Enter 'exit' to quit the application.");
	}
	
}
