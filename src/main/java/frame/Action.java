package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Action {
    static JFrame frame = getFrame();
    static JPanel panel = new JPanel();

    public static void main(String[] args) {
        frame.add(panel);
        AbstractAction myAction = new MyAction();
        JButton button = new JButton(new MyAction());
        button.setText("SUBMIT");
        panel.add(button);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

//        сочетание клавиш - KeyStroke - ??? для MAC OS
//        KeyStroke keyStroke = KeyStroke.getKeyStroke("ctrl B");
//        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_CONTROL, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        InputMap inputMap = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(keyStroke, "changeColor");
        ActionMap actionMap = panel.getActionMap();
        actionMap.put("changeColor", myAction);

    }

    static class MyAction extends AbstractAction {

        MyAction() {
            putValue(AbstractAction.SHORT_DESCRIPTION, "При наведении на кнопку");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(Color.YELLOW);
        }
    }


    static JFrame getFrame() {
//        JFrame frame = new JFrame("My window");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        получение размера экрана
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2 - (400/2), dimension.height/2 - (300/2), 400, 300);

        return frame;
    }
}
