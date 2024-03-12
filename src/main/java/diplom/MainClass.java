package diplom;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass {

    static JFrame frame = getFrame();
    static JPanel panel = new JPanel();

    public static void main(String[] args) {
        frame.add(panel);
//        JButton button_2sin = getButton("SIN смещение на 2");
        JButton button_sin = getButton("SIN");
//        panel.add(button_2sin);
        panel.add(button_sin);

//        button_2sin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                offsetConstrationGraphSin();
//                сonstructingGraficSin();
//            }
//        });

        button_sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                сonstructingGraficSin();
            }
        });
    }

    private static JFrame getFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        получение размера экрана
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2 - (800/2), dimension.height/2 - (600/2), 800, 600);

        return frame;
    }

    private static JButton getButton(String title) {
        JButton button = new JButton(title);
        return button;
    }

    static void offsetConstrationGraphSin(int z) {
        System.out.println("Dialog window");
        String m = JOptionPane.showInputDialog("Введите число для смещения графика:");
        System.out.println("число для смещения графика: " + m);

        switch (z) {
            case 1:
                constractionGraphSin(Float.parseFloat(m), 1);
                break;
            case 2:
                constractionGraphSin(1, Float.parseFloat(m));
                break;
        }


//        constractionGraphSin(Float.parseFloat(m), 1);


    }

    static void сonstructingGraficSin() {
        System.out.println("Graf - SIN");
        constractionGraphSin(1, 1);
    }


    private static void constractionGraphSin(float ay, float bx) {
        JFrame frameGraph = getFrame();
        JButton buttonSY = getButton("Ввести смещение графика - x");
        JButton buttonSX = getButton("Ввести смещение графика - y");

        buttonSX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                offsetConstrationGraphSin(1);
            }
        });
        buttonSY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                offsetConstrationGraphSin(2);
            }
        });


        XYSeries series = new XYSeries("sin(a)");

        for (float i = (float) -(2 * Math.PI); i < 2 * Math.PI; i += 0.1) {
            series.add(i, Math.sin(i * bx) * ay) ;
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        String titleGraph = getTitleGraphSin(ay, bx);
        JFreeChart chart = ChartFactory
                .createXYLineChart(titleGraph, "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);

        frameGraph.setLayout(new BorderLayout());

        // Создаем панель для графика
        ChartPanel chartPanel = new ChartPanel(chart);
        frameGraph.add(chartPanel, BorderLayout.CENTER);

        // Добавляем кнопку в верхнюю часть (NORTH)
        frameGraph.add(buttonSX, BorderLayout.NORTH);
        frameGraph.add(buttonSY, BorderLayout.NORTH);

        frameGraph.setVisible(true);
    }


//    private static void constractionGraphSin2(double b) {
//        JFrame frameGraph = getFrame();
////        JPanel panelGraph = new JPanel();
//        JButton buttonS = getButton("Ввести смещение графика");
////        frameGraph.add(buttonS);
////        panelGraph.add(buttonS);
//
//        XYSeries series = new XYSeries("sin(a)");
//
//        for(float i = (float) -(2 * Math.PI); i < 2 * Math.PI; i+=0.1){
//            series.add(i, Math.sin(i * b));
//        }
//
//        XYDataset xyDataset = new XYSeriesCollection(series);
//        String titleGraph = getTitleGraphSin(b);
//        JFreeChart chart = ChartFactory
//                .createXYLineChart( titleGraph, "x", "y",
//                        xyDataset,
//                        PlotOrientation.VERTICAL,
//                        true, true, true);
////        JFrame frame =
////                new JFrame("MinimalStaticChart");
////        JFrame frameGraph = getFrame();
//
//        // Помещаем график на фрейм
//        frameGraph.getContentPane()
//                .add(new ChartPanel(chart));
////        frame.setSize(400,300);
//
////        frameGraph.add(buttonS);
//
//        frameGraph.show();
//    }

    private static String getTitleGraphSin(float a, float b) {
        if (b == 1 && a == 1) {
            return "y = sin(x)";
        } else { if (b != 1) {
            return "y = sin(" + b + "x)";
        } else {
            return "y = " + a + " sin(x)";
        }
        }
    }
}

