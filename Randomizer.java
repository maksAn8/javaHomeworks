import java.util.Scanner;

public class Randomizer {
	
	public int upperLimit, lowerLimit, randomNumber, uniqueNumbersCounter;
	public int[] alreadyGeneratedNumbers;
	public String userCommand;
	public Scanner scanner;
	
	public Randomizer() {
		scanner = new Scanner(System.in);
	}
	
	public void start() {
		boolean isRunning = true;
		setUserRangeForRandom();
		while(isRunning) {
			switch(getUserCommand()) {
				case "generate":
					do {
						generateRandomNumber();
					} while(!isUniqueRandomNumber() && uniqueNumbersCounter != upperLimit - lowerLimit + 1);
					System.out.println(randomNumber);
					if(uniqueNumbersCounter == upperLimit - lowerLimit + 1) {
						System.out.println("There are no more unique numbers here. Do you want to set a new range? (enter yes or no)");
						userCommand = scanner.next().toLowerCase();
						if(userCommand.equals("no")) {
							System.exit(0);
						} else if(userCommand.equals("yes")) {
							reset();
							setUserRangeForRandom();
						}
					}
					break;
				case "exit":
					exit();
					break;
				case "help":
					System.out.println("Enter 'generate' to get random number.");
					System.out.println("Enter 'exit' to quit the application.");
					break;
				default:
					System.out.println("Wrong command was entered, try again...");
			}
		}
			
	}

	public void setUserRangeForRandom() {
		System.out.println("Please, enter lower and upper limits of the range for number generetion (limits included)");
		lowerLimit = scanner.nextInt();
		upperLimit = scanner.nextInt();
		alreadyGeneratedNumbers = new int[upperLimit - lowerLimit + 1];
	}
	
	public String getUserCommand() {
		System.out.println("Enter command: generate, help or exit");
		String userCommand = scanner.next();
		userCommand.toLowerCase();
		return userCommand;
	}
	
	public void generateRandomNumber() {
		randomNumber = lowerLimit + (int)(Math.random() * (upperLimit - lowerLimit + 1));
	}
	
	public boolean isUniqueRandomNumber() {
		boolean isUnique = true;
		for(int alreadyGeneratedNumber : alreadyGeneratedNumbers) {
			if(randomNumber == alreadyGeneratedNumber) {
				return false;
			}
		}
		alreadyGeneratedNumbers[uniqueNumbersCounter++] = randomNumber;
		return isUnique;
	}
	
	public void reset() {
		uniqueNumbersCounter = 0;
	}
	
	public void exit() {
		System.out.println("Are you sure that you want to quit the app? (enter yes or no)");
		userCommand = scanner.next();
		if(userCommand.toLowerCase().equals("yes")) {
			System.exit(0);
		}
	}
	
}
