package diplom;

import javax.swing.*;
import java.awt.*;

public class DrawingComponent extends JPanel {

//    int xg[] = GraficSin.xInt;
//    int yg[] = GraficSin.yInt;
    int xg[] = GraficSin.x;
    int yg[] = GraficSin.y;
    int ng = xg.length;

    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        Graphics2D drg = (Graphics2D) g;
        drg.drawLine(20, 340, 20, 20);
        drg.drawLine(20, 340, 460, 340);
        drg.drawPolygon((int[]) xg, yg, ng);
    }

}

class GraficSin extends JFrame {
    public static final double pi = 3.14;

//    public static double x[] = {-(2*pi), -(3*pi/2), -(pi), -(pi/2), 0, pi/2, pi, 3*pi/2, 2*pi };
//    public static double y[] = getYSin(x);

//    public static int xInt[] = getIntArray(x);
//    public static int yInt[] = getIntArray(y);

    public static int[] x = {50, 100, 150, 200, 250};
    public static int[] y = {80, 200, 150, 320, 100};

    public GraficSin() {
        super("График sin() по точкам");
        JPanel panelGraf = new JPanel(new BorderLayout());
        setContentPane(panelGraf);
        panelGraf.add(new DrawingComponent(), BorderLayout.CENTER);
        panelGraf.setBackground(Color.lightGray);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GraficSin().setVisible(true);
    }



    private static double[] getYSin(double[] x) {
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = Math.sin(x[i]);
        }
        return y;
    }

    private static int[] getIntArray(double[] x) {
        int[] result = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = (int) (x[i] * 10);
        }
        return result;
    }
}
