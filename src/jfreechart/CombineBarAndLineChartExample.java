package jfreechart;


import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.knowm.xchart.BitmapEncoder;

/**
 * @author imssbora
 *
 */
public class CombineBarAndLineChartExample extends JFrame {

   private static final long serialVersionUID = 1L;

   public CombineBarAndLineChartExample(String title) {
      super(title);

      // Create Category plot
      CategoryPlot plot = new CategoryPlot();

      // Add the first dataset and render as bar
      CategoryItemRenderer lineRenderer = new LineAndShapeRenderer();
      plot.setDataset(0, createDataset());
      plot.setRenderer(0, lineRenderer);

      // Add the second dataset and render as lines
      CategoryItemRenderer baRenderer = new BarRenderer();
      plot.setDataset(1, createDataset());
      plot.setRenderer(1, baRenderer);
      plot.setBackgroundPaint(Color.white);
      plot.setDomainCrosshairPaint(Color.CYAN);
      plot.setOutlinePaint(Color.green);
      plot.setOutlinePaint(Color.green);
      plot.setpaint
      // Set Axis
      plot.setDomainAxis(new CategoryAxis("Version"));
      plot.setRangeAxis(new NumberAxis("Name Passed"));
      
      JFreeChart chart = new JFreeChart(plot);
      chart.setTitle("Patient Name Coverage Passed");
     
      ChartPanel panel = new ChartPanel(chart);
      setContentPane(panel);
      File BarChart = new File( "BarChart.jpeg" ); 
      try {
		ChartUtilities.saveChartAsPNG(BarChart, chart, 900, 300);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

   private DefaultCategoryDataset createDataset() {

      // First Series
      String series1 = "Vistor";
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      dataset.addValue(200.20, series1, "2.7");
      dataset.addValue(150, series1, "2.8");
      dataset.addValue(100, series1, "2.9");
     
      // Second Series
     

      return dataset;
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         CombineBarAndLineChartExample example = new CombineBarAndLineChartExample(
               "Line Chart and Bar chart Example");
        
         
      });
      
   }
}