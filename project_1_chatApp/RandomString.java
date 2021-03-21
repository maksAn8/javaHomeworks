package autotests;

import java.util.Random;

public class RandomString {

    String getRandomString(int stringLen) {
        String validSymbols = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder randomString = new StringBuilder();
        Random rnd = new Random();
        while (randomString.length() < stringLen) {
            int index = (int) (rnd.nextFloat() * validSymbols.length());
            randomString.append(validSymbols.charAt(index));
        }
        return randomString.toString();
    }

    String getRandomEmail(int stringLen, String emailDomain) {
        return getRandomString(stringLen) + emailDomain;
    }

}
