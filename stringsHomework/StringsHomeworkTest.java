package homeworks;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StringsHomeworkTest {

    private StringsHomework sh;
    private String[] words;

    @BeforeEach
    public void setUp(){
        sh = new StringsHomework();
        words = new String[]{"123456", "qwerty", "123", ""};
    }

    @Test    //some shit happens here in assertEquals with strings, there are no differences in JUnit report, but test fails
    public void test_printSymbols(){    //upd: I found the difference with the help of compareTo() and debugger (\r regExp)
        String expected = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z \n" +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z \n" +
                "0 1 2 3 4 5 6 7 8 9 \n" +
                "а б в г д е ё ж з и й к л м н о п р с т у ф х ц ч ш щ ъ ы ь э ю я \r\n" +
                "  ! \" # $ % & ' ( ) * + , - . / 0 1 2 3 4 5 6 7 8 9 : ; < = > ? @ " +
                "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z [ \\ ] ^ _ ` " +
                "a b c d e f g h i j k l m n o p q r s t u v w x y z { | } ~ \r\n";
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        sh.printSymbols();
        String actual = outputStreamCaptor.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_null_validateString(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->sh.validateString(null), "Value can not be null!");
    }

    @Test
    public void test_blank_validateString(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->sh.validateString("    "), "Value can not be null!");
    }

    @Test
    public void test_int_convertNumberToString(){
        String actual = sh.convertNumberToString(1337);
        String expected = "1337";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_double_convertNumberToString(){
        String actual = sh.convertNumberToString(13.37);
        String expected = "13.37";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_convertStringToInt(){
        int expected = 1337;
        int actual = sh.convertStringToInt("1337");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_neg_convertStringToInt(){
        int expected = -1337;
        int actual = sh.convertStringToInt("-1337");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_incorrectData_convertStringToInt(){
        int expected = 0;
        int actual = sh.convertStringToInt("5j");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_convertStringToDouble(){
        double expected = 13.37;
        double actual = sh.convertStringToDouble("13.37");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_neg_convertStringToDouble(){
        double expected = -13.37;
        double actual = sh.convertStringToDouble("-13.37");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_incorrectData_convertStringToDouble(){
        double expected = 0.0;
        double actual = sh.convertStringToDouble("word");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_getShortestWordLength(){
        int expected = 2;
        int actual = sh.getShortestWordLength("    one  two d123456 three 23  wooow  ");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_replace3LastSymbols(){
        String[] expected = new String[]{"123$", "qwe$", "123", ""};
        sh.replace3LastSymbols(words, 6);
        Assertions.assertArrayEquals(expected, words);
    }

    @Test
    public void test_exception1_replace3LastSymbols(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->sh.replace3LastSymbols(words, -1),
                "Incorrect data!");
    }

    @Test
    public void test_exception2_replace3LastSymbols(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->sh.replace3LastSymbols(null, -1),
                "Incorrect data!");
    }

    @Test
    public void test_addSpaces(){
        String expected = "I, like, bananas. ";
        String actual = sh.addSpaces("I,like, bananas.");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_getUniqueSymbols(){
        String expected = "I,like bans.";
        String actual = sh.getUniqueSymbols("I,like, bananas.");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_3_countWords(){
        int expected = 3;
        int actual = sh.countWords("I,like,   bananas.  . ");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_deleteSubstring(){
        String expected = "I  like bananas";
        String actual = sh.deleteSubstring("I don`t like bananas", 3, 5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_allStr_deleteSubstring(){
        String expected = "";
        String actual = sh.deleteSubstring("I don`t like bananas", 1, 20);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_exception1_deleteSubstring(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->sh.deleteSubstring("I don`t like bananas", 0, 5),
                "Incorrect data!");
    }

    @Test
    public void test_exception2_deleteSubstring(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->sh.deleteSubstring("I don`t like bananas", 0, -5),
                "Incorrect data!");
    }

    @Test
    public void test_exception3_deleteSubstring(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->sh.deleteSubstring("I don`t like bananas", 1, 50),
                "Incorrect data!");
    }

    @Test
    public void test_reverseString(){
        String expected = "123 456";
        String actual = sh.reverseString("654 321");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_deleteLastWord(){
        String expected = "I don`t like/!!!";
        String actual = sh.deleteLastWord("I don`t like/bananas!!!");
        Assertions.assertEquals(expected, actual);
    }

    @AfterAll
    public static void tearDown(){
        System.setOut(System.out);
    }

}
