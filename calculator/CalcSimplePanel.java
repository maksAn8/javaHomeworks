package homeworks.calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcSimplePanel extends JPanel implements ActionListener {
    private JTextField textFldNumber1, textFldNumber2, textFldMathOperation, textFldResult;
    private Calculator calc;

    public CalcSimplePanel(Calculator calc) {
        createAll();
        this.calc = calc;
    }

    private void createAll() {
        setLayout(null);
        createTextFields();
        createLabels();
        createButtons();
    }

    private void createLabels() {
        JLabel labelNumber1 = new JLabel("Number 1");
        labelNumber1.setBounds(45, 50, Constant.LBL_WIDTH, Constant.LBL_HEIGHT);
        add(labelNumber1);
        JLabel labelNumber2 = new JLabel("Number 2");
        labelNumber2.setBounds(45, 110, Constant.LBL_WIDTH, Constant.LBL_HEIGHT);
        add(labelNumber2);
        JLabel labelMathOperation = new JLabel("Math operation");
        labelMathOperation.setBounds(45, 170, Constant.LBL_WIDTH, Constant.LBL_HEIGHT);
        add(labelMathOperation);
        JLabel labelResult = new JLabel("Result");
        labelResult.setBounds(45, 290, Constant.LBL_WIDTH, Constant.LBL_HEIGHT);
        add(labelResult);
    }

    private void createTextFields() {
        textFldNumber1 = new JTextField();
        textFldNumber1.setBounds(150, 50, Constant.TXT_FLD_WIDTH, Constant.TXT_FLD_HEIGHT);
        add(textFldNumber1);
        textFldNumber2 = new JTextField();
        textFldNumber2.setBounds(150, 110, Constant.TXT_FLD_WIDTH, Constant.TXT_FLD_HEIGHT);
        add(textFldNumber2);
        textFldMathOperation = new JTextField();
        textFldMathOperation.setBounds(150, 170, Constant.TXT_FLD_WIDTH, Constant.TXT_FLD_HEIGHT);
        add(textFldMathOperation);
        textFldResult = new JTextField();
        textFldResult.setBounds(150, 290, Constant.TXT_FLD_WIDTH, Constant.TXT_FLD_HEIGHT);
        add(textFldResult);
    }

    private void createButtons() {
        JButton button = new JButton("=");
        button.setBounds(45, 230, Constant.BTN_WIDTH, Constant.BTN_HEIGHT);
        button.addActionListener(this);
        add(button);
    }

    public String getNumber1() {
        return textFldNumber1.getText();
    }

    public String getNumber2() {
        return textFldNumber2.getText();
    }

    public String getMathOperation() {
        return textFldMathOperation.getText();
    }

    public JTextField getTextFldResult() {
        return textFldResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        calc.getResult();
    }
}
