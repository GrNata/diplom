package frame;

import com.sun.tools.internal.ws.wsdl.framework.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.EventHandler;
import java.net.MalformedURLException;
import java.net.URL;


public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = getFrame();
//        frame.add(new MyComponent());

        JPanel panel = new JPanel();    //  можно добавлять кнопки
        frame.add(panel);

        JButton button = new JButton("submit");
        panel.add(button);
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                panel.setBackground(Color.RED);
//                frame.setTitle(((JButton) e.getSource()).getText());
//            }
//        });
//        button.addActionListener(EventHandler.create(ActionListener.class, frame, "title", "source.text"));

//        UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
//        for (UIManager.LookAndFeelInfo l : lookAndFeelInfos) {
//            System.out.println(l.getName());
//            System.out.println(l.getClassName());
//        }
//
//        JButton button1 = new JButton(("Metal"));
//        JButton button2 = new JButton(("Nimbus"));
//        JButton button3 = new JButton(("Motif"));
//        JButton button4 = new JButton(("MAC OS"));
//        panel.add(button1);
//        panel.add(button2);
//        panel.add(button3);
//        panel.add(button4);
//        button1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        button2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        button3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });
//        button4.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        });

     }

////    графика отрисовка, шрифты
//    static class MyComponent extends JComponent {
//        @Override
//        protected void paintComponent(Graphics g) {
//            Font font = new Font("Times New Roman", Font.BOLD, 20);
//            Graphics2D g2 = (Graphics2D) g;
//            g2.setFont(font);
//            g2.drawString("Hello world!", 130,50);
//            Point2D p1 = new Point2D.Double(70, 70);
//            Point2D p2 = new Point2D.Double(170, 170);
//            Line2D l2 = new Line2D.Double(p1, p2);
//            g2.draw(l2);
//            Ellipse2D e2 = new Ellipse2D.Double(70, 70, 170,170);
//            g2.draw(e2);    // отрисовка
//            g2.setPaint(Color.GREEN);
//            g2.fill(e2);    // закрасить
//            Rectangle2D r2 = new Rectangle2D.Double(70, 70, 170, 170);
//            g2.setPaint(Color.MAGENTA);
//            g2.draw(r2);
//
//            try {
//                URL url = new URL("https://cdn-icons-png.flaticon.com/128/840/840684.png");
////                Image image = new ImageIcon(url).getImage();
//                Image image = new ImageIcon("img/paret.jpeg").getImage();
//                g2.drawImage(image, 220, 50, null);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

    static JFrame getFrame() {
//        JFrame frame = new JFrame("My window");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
//        frame.setSize(400, 300);
//        frame.setLocation(500, 250);
//        frame.setBounds(500, 250, 400, 300);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        получение размера экрана
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2 - (400/2), dimension.height/2 - (300/2), 400, 300);

        return frame;
    }

}
