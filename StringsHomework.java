import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsHomework {
		
	public void outputSymbols() {
		String lowerCase = "";
		String numbers = "";
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
			lowerCase += (char)(i + 32) + " ";
			if(i >= 80 && i <= 89) {
				numbers += (char)(i - 32) + " ";
			}
		}
		System.out.print("\n" + lowerCase + "\n");
		System.out.print(numbers + "\n");
		
		for(char i = 'а'; i <= 'я'; i++) {
			System.out.print(i + " ");
			if(i == 'е') {
				System.out.print((char)(i + 28) + " ");
			}
		}
		System.out.println();
		
		for(char i = ' '; i <= '~'; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public String convertNumberToString(int number) {
		return String.valueOf(number);
	}
	
	public String convertNumberToString(double number) {
		return String.valueOf(number);
	}
	
	public int convertStringToNumber(String value) {
		if(value == null || value.strip().length() == 0) {
			throw new IllegalArgumentException("Value can not be null!");
		}
		int result = 0;
		try {
			return Integer.parseInt(value.strip());
		} catch (NumberFormatException e) {
			System.out.println("Incorrect input!");
		}
		return result;
	}
	
	public double convertStringToFloatPointNumber(String value) {
		if(value == null || value.strip().length() == 0) {
			throw new IllegalArgumentException("Value can not be null!");
		}
		double result = 0;
		try {
			return Double.parseDouble(value.strip());
		} catch (NumberFormatException e) {
			System.out.println("Incorrect input!");
		}
		return result;
	}
	
	public int getShortestWordLength(String value) {
		if(value == null || value.strip().length() == 0) {
			throw new IllegalArgumentException("Value can not be null!");
		}
		int result = 0;
		String[] words = value.replaceAll("\\W+", " ").strip().split(" ");
		for(int i = 0; i < words.length - 1; i++) {
			if(words[i].length() < words[i + 1].length()) {
				result = words[i].length();
			}
		}
		return result;
	}
	
	public void replace3LastSymbols(String words[], int wordLength) {
		for(int i = 0; i < words.length; i++) {
			if(words[i].length() == wordLength) {
				words[i] = words[i].replaceAll("...$", "\\$");
			}
		}
	}
	
	public String addSpaces(String value) {
		if(value == null || value.strip().length() == 0) {
			throw new IllegalArgumentException("Value can not be null!");
		}
		Pattern pattern = Pattern.compile("[\\pP\\W]");
		Matcher matcher = pattern.matcher(value); 
		while(matcher.find()) {
			String w = matcher.group();
			value = value.replaceAll("\\" + w, w + " ");
			value = value.replaceAll("\\s+", " ");
		}
		return value;
	}
	
	public String getUniqueSymbols(String value) {
		if(value == null || value.strip().length() == 0) {
			throw new IllegalArgumentException("Value can not be null!");
		}
		String result = "";
		for(int i = 0; i < value.length(); i++) {
			if (result.indexOf(value.charAt(i)) == - 1) {
				result += value.charAt(i);
			}
		}
		return result;
	}
	
	public int countWords(String value) {
		if(value == null || value.strip().length() == 0) {     
			throw new IllegalArgumentException("Value can not be null!");
		}
		int counter = 0;
		String[] splitValue = value.strip().split("\\W");
		for(int i = 0; i < splitValue.length; i++) { 
			if(splitValue[i].matches("[a-zA-z]+")) {
				counter++;
			}
		}
		return counter;
	}
	
	public String deleteSubstring(String value, int startIndex, int len) {
		if(value == null || value.strip().length() == 0 || startIndex < 1 || len < 0 || startIndex - 1 + len > value.length()) {
			throw new IllegalArgumentException("Incorrect data!");
		}
		return value.substring(0, startIndex - 1) + value.substring(startIndex - 1 + len, value.length());
	}
	
	public String reverseString(String value) {
		if(value == null || value.strip().length() == 0) {
			throw new IllegalArgumentException("String cannot be null!");
		}
		String result = "";
		for(int i = 0; i < value.length(); i++) {
			result += value.charAt(value.length() - 1 - i);
		}
		return result;
	}
	
	public String deleteLastWord(String value) {
		if(value == null || value.strip().length() == 0) {     
			throw new IllegalArgumentException("Value can not be null!");
		}
		value = reverseString(value);
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(value);
		int start = 0;
		int end = 0;
		if(matcher.find()) {
			start = matcher.start();
			end = matcher.end();
		} 
		return reverseString(value.replaceFirst(value.substring(start, end), ""));
	}
	
}
