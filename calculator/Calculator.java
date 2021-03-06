package homeworks.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    private CalcSimplePanel panel;

    public Calculator() {
        panel = new CalcSimplePanel(this);
        new CalcFrame(panel);
    }

    void getResult() {
        double num1 = 0, num2 = 0;
        char mathOperation = ' ';
        boolean isValid = true;
        try {
            num1 = Double.parseDouble(panel.getNumber1());
            num2 = Double.parseDouble(panel.getNumber2());
            mathOperation = panel.getMathOperation().charAt(0);
        } catch (Exception e) {
            isValid = false;
            panel.getTextFldResult().setText("Incorrect input!");
        }
        if(isValid) {
            switchMathOperation(num1, num2, mathOperation);
        }
    }

    private void switchMathOperation(double num1, double num2, char mathOperation) {
        double result;
        switch(mathOperation) {
            case '/':
                if(num2 == 0) {
                    panel.getTextFldResult().setText("Can not divide by 0!");
                    break;
                }
            case '*':
            case '+':
            case '-':
                result = CalcAPI.calculate(num1, num2, mathOperation);
                panel.getTextFldResult().setText(String.valueOf(result));
                break;
            default:
                panel.getTextFldResult().setText("Enter: *, /, + or -");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

