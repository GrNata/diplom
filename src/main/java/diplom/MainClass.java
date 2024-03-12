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
        JButton button_sin = getButton("SIN");
        panel.add(button_sin);

        button_sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                строим первоначальный график
                constractionGraphSin(1.0f, 1.0F);

                frame.setVisible(false);
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

//    ввод смещения графика
    private static void offsetConstrationGraphSin(int z) {
//        z, по какой оси смещение - 2 по Х, 1 по Y
        String m = JOptionPane.showInputDialog("Введите число для смещения графика:");

        switch (z) {
            case 1:
                constractionGraphSin(Float.parseFloat(m), 1);
                break;
            case 2:
                constractionGraphSin(1, Float.parseFloat(m));
                break;
        }
    }

//  построение графика
    private static void constractionGraphSin(float ay, float bx) {
        JFrame frameGraph = getFrame();

        JPanel panelGraph = new JPanel();

        JButton buttonSX = getButton("Ввести смещение графика - x");
        JButton buttonSY = getButton("Ввести смещение графика - y");

        frameGraph.add(panelGraph);

        buttonSX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                offsetConstrationGraphSin(2);

                frameGraph.setVisible(false);
            }
        });
        buttonSY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                offsetConstrationGraphSin(1);

                frameGraph.setVisible(false);
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

        panelGraph.setLayout(new FlowLayout());

        // Создаем панель для графика
        ChartPanel chartPanel = new ChartPanel(chart);
        panelGraph.add(chartPanel, BorderLayout.CENTER);

        // Добавляем кнопки в верхнюю часть (NORTH)
        panelGraph.add(buttonSX, BorderLayout.NORTH);
        panelGraph.add(buttonSY, BorderLayout.NORTH);

        frameGraph.setVisible(true);
    }

//    Заголовок графика
    private static String getTitleGraphSin(float a, float b) {

        if (b == 1 && a == 1) {
            return "y = sin(x)";
        } else { if (b != 1) {
            return "y = sin(" + b + "x)";
        } else {
            return  "y = " + a + " sin(x)";
        }
        }
    }



}

