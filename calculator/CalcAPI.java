package homeworks.calculator;

public class CalcAPI {
    public static double calculate(double num1, double num2, char operation) {
        double result = 0;
        switch (operation) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num1 / num2; break;
        }
        return result;
    }
}
