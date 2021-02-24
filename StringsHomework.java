import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsHomework {
	
	public static void main(String args[]) {
		String[] words = new String[] {"qwerty", "asdf", "zxcv"};
		StringsHomework xz = new StringsHomework();
		xz.outputSymbols();
		System.out.println(xz.convertNumberToString(1234));
		System.out.println(xz.convertNumberToString(123.31231));
		System.out.println(xz.convertStringToFloatPointNumber("123.31231"));
		System.out.println(xz.convertStringToNumber("123	"));
		System.out.println(xz.getShortestWordLength(" bla-bl, helasj. asf, afs"));
		xz.replace3LastSymbols(words, 4);
		System.out.println(java.util.Arrays.toString(words));
		xz.addSpaces(",,,,qwerty,qwerty. qwerty!werwer!!!");
		System.out.println(xz.getUniqueSymbols("asdfasdfasdf...[]"));
		System.out.println(xz.deleteSubstring("qwertyuiop", 3, 5));
		System.out.println(xz.reverseString("1234567890"));
	}
	
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
		int result = 0;
		try {
			return Integer.parseInt(value.strip());
		} catch (NumberFormatException e) {
			System.out.println("Incorrect input!");
		}
		return result;
	}
	
	public double convertStringToFloatPointNumber(String value) {
		double result = 0;
		try {
			return Double.parseDouble(value.strip());
		} catch (NumberFormatException e) {
			System.out.println("Incorrect input!");
		}
		return result;
	}
	
	public int getShortestWordLength(String value) {
		if(value == null) {
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
		if(value == null) {
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
		if(value == null) {
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
	
	public String deleteSubstring(String value, int startIndex, int len) {
		if(value == null || startIndex < 1 || len < 0 || startIndex - 1 + len > value.length()) {
			throw new IllegalArgumentException("Incorrect data!");
		}
		return value.substring(0, startIndex - 1) + value.substring(startIndex - 1 + len, value.length());
	}
	
	public String reverseString(String value) {
		if(value == null) {
			throw new IllegalArgumentException("String cannot be null!");
		}
		String result = "";
		
		for(int i = 0; i < value.length(); i++) {
			result += value.charAt(value.length() - 1 - i);
		}
		return result;
	}
	
}
