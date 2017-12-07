package jfreechart;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.*;
import java.util.UUID;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.knowm.xchart.BitmapEncoder;

public class LineChart {

   public static void main( String[ ] args ) throws Exception {
	   double[] namePassPercentage = new double[] {12,22,45,65,66,67,69,72,77,83,85,88,92,95,95,96};
	   String[] version=new String[] {"2.9.8","2.9.9","2.9.10","2.9.11","v2.10.2","v2.10.3","v2.10.5","v2.10.6","v2.10.7","v2.10.9","v2.10.10","v2.10.11","v2.10.14","v2.11.2","v2.11.3","v2.11.5"};
	   String arg="Patient Name";
	   drawchart(namePassPercentage,version,arg);
     
   }
   public static void drawchart(double passPercentage[],String version[],String arg) throws IOException
   {
	   DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	      String name="name";
	      int length=passPercentage.length;
	      for(int i=0;i<length;i++)
	    {
	    	 line_chart_dataset.addValue( passPercentage[i], name , version[i] );
	    }
	      

	     JFreeChart lineChartObject = ChartFactory.createLineChart(
	         "name passed","Version",
	         "name",
	         line_chart_dataset,PlotOrientation.VERTICAL,
	         true,true,true);
	     //
	     
	         lineChartObject.setBackgroundPaint(new Color(218, 242, 201));//outer color
	         CategoryPlot plot = (CategoryPlot) lineChartObject.getPlot();
	         plot.setBackgroundPaint(new Color(0xFF, 0xFF, 0xFF));//inner color
	      plot.getRenderer().setSeriesStroke(0, new BasicStroke(5.0f)); //this works
	     plot.setRangeGridlinesVisible(true);
	     plot.setDomainGridlinesVisible(true);
	     plot.setRangeMinorGridlinesVisible(true);
	     plot.setRangeGridlinePaint(Color.black);
	     plot.setDomainGridlinePaint(Color.black);
	     //font
	     
	     
	     CategoryPlot p = lineChartObject.getCategoryPlot(); 
	     ValueAxis axis = p.getRangeAxis();
	     Font font = new Font("Dialog", Font.PLAIN, 30);
	     axis.setTickLabelFont(font);
	     XYLineAndShapeRenderer r1 = new XYLineAndShapeRenderer();
	     final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer(); 
	     renderer.setShapesVisible(true);
	     renderer.setAutoPopulateSeriesFillPaint(true);
	     renderer.setAutoPopulateSeriesOutlinePaint(true);
	     renderer.setAutoPopulateSeriesStroke(true);
	     renderer.setAutoPopulateSeriesPaint(true);
	     renderer.setBaseFillPaint(Color.cyan);
	     renderer.setBaseSeriesVisible(true);
	     //
	     renderer.setSeriesShape(0, new Rectangle(-5, -5, 7, 7));
	     renderer.setSeriesShapesVisible(0, true);
	     renderer.setShapesFilled(true);
	     //
	     renderer.setSeriesOutlinePaint(0, Color.GREEN);
	    // renderer.setPlotShapes(true);
	     renderer.setShapesFilled(true);
	     renderer.setItemLabelsVisible(true);
	     //
	     LineAndShapeRenderer renderer1 = (LineAndShapeRenderer) plot.getRenderer(); 
	     //renderer1.setDrawShapes(true);
	     renderer1.setItemLabelsVisible(true);
	     //
	    // plot.setRenderer
	     
	     
	     //
	     CategoryPlot p1 = lineChartObject.getCategoryPlot(); 
	     CategoryAxis axis1 = p.getDomainAxis();
	     Font font1 = new Font("Dialog", Font.BOLD, 15);
	     axis.setTickLabelFont(font1);
	     //
	     CategoryAxis domainAxis = plot.getDomainAxis();
	     domainAxis.setCategoryLabelPositions(
	         CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 4.75));
	     plot.getRenderer().setPaint(new Color(53, 160, 17));
	     
	    
	      int width = 800;    /* Width of the image */
	      int height = 400;   /* Height of the image */ 
	     // String outputFileName = UUID.randomUUID().toString()+".png";
	      File lineChart = new File("./gggg.jpg"); 
	      
	      ChartUtilities.saveChartAsPNG(lineChart ,lineChartObject, width ,height);  
   }
}