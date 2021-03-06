package homeworks.calculator;

import javax.swing.*;
import java.awt.*;

public class CalcFrame extends JFrame {

    public CalcFrame(JPanel calcPanel) {
        createFrame(calcPanel);
    }

    private void createFrame(JPanel calcPanel) {
        setTitle(Constant.TITLE);
        setSize(Constant.WIN_WIDTH, Constant.WIN_HEIGHT);
        setResizable(false);
        setFrameAtCenter();
        add(calcPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setFrameAtCenter() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenW = gd.getDisplayMode().getWidth();
        int screenH = gd.getDisplayMode().getHeight();
        setBounds((screenW - Constant.WIN_WIDTH) / 2, (screenH - Constant.WIN_HEIGHT) / 2, Constant.WIN_WIDTH, Constant.WIN_HEIGHT);
    }

}
