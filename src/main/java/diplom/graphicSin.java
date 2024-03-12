package diplom;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;

public class graphicSin {

//    public static void main(String[] args) {
    public static void constractionGraphSin() {
        XYSeries series = new XYSeries("sin(a)");

        for(float i = (float) -(2 * Math.PI); i < 2 * Math.PI; i+=0.1){
            series.add(i, Math.sin(i));
        }

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("y = sin(x)", "x", "y",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
//        JFrame frame =
//                new JFrame("MinimalStaticChart");
        JFrame frameGraph = getFrame();

        // Помещаем график на фрейм
        frameGraph.getContentPane()
                .add(new ChartPanel(chart));
//        frame.setSize(400,300);
        frameGraph.show();
    }

    static JFrame getFrame() {
//        JFrame frame = new JFrame("My window");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        получение размера экрана
        Dimension dimension = toolkit.getScreenSize();
        frame.setBounds(dimension.width/2 - (800/2), dimension.height/2 - (600/2), 800, 600);

        return frame;
    }
}
