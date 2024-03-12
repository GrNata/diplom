package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener {

    static JFrame frame = getFrame();
    static JPanel panel = new JPanel();

    public static void main(String[] args) {
        JComponent component = new MyComponent();
        frame.add(component);
        frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                MyComponent.xCoord = e.getX();
                MyComponent.yCoord = e.getY();
                component.repaint();
            }
        });
//        frame.add(panel);
//         на клик мыши
//        panel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                panel.setBackground(Color.red);
//            }
//        });

//        отслеживание координат маши


    }

    static  class MyComponent extends JComponent {
        public static int xCoord;
        public static int yCoord;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ((Graphics2D) g).drawString("Coordinates x: " + xCoord + "   y: " + yCoord, 50, 50);
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
