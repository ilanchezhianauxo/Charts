package xchart_image;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class Linechart {
	 
	  public static void main(String[] args) throws Exception {
		  double currentPass=70.67;
	 
	  double[] yData = new double[] { 56.5, 63.6,43,55.6};
	  double[] xData = new double[] { 1,2,3,4};
	 
		 
	    // Create Chart
	   
		  XYChart chart = QuickChart.getChart("NAME", "Time","Name Pass %", "kl", xData, yData);
	    
	 
	    // Show it
	    new SwingWrapper(chart).displayChart();
	    BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);
	    StringUtils.isBlank(str_name);
	 
	  }
	}