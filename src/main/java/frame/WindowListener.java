package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowListener {

    public static void main(String[] args) {
        JFrame frame = getFrame();
//  лучше чем new WindowListener(), можно выбрать от одного нужного метода
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int i = 0;
            }
        });

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
