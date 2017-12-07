package xchart_image;

import java.awt.Color;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.VectorGraphicsEncoder;
import org.knowm.xchart.VectorGraphicsEncoder.VectorGraphicsFormat;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class Linechart_1 {
	 
	  public static void main(String[] args) throws Exception {
	 
	    double[] yData = new double[] { 2.0, 1.0, 0.0 ,2.3,3.2};
	    double[] xData = new double[] { 0,2.7, 2.8,2.9 ,3.0};
	 
	    // Create Chart
	    XYChart chart = new XYChart(500, 400);
	    chart.setTitle("Sample Chart");
	    chart.setXAxisTitle("X");
	    chart.setXAxisTitle("Y");
	    XYSeries series = chart.addSeries("y(x)", xData, yData);
	    
	    Color[] lineColor = new Color[] { new Color(0, 102, 0) };
	    chart.getStyler().setChartBackgroundColor(Color.getHSBColor(200, 145, 110));
        chart.getStyler().setSeriesColors(lineColor);
	    series.setMarker(SeriesMarkers.CIRCLE);
	 
	    BitmapEncoder.saveBitmap(chart, "./Sample_Chartiiiii", BitmapFormat.PNG);
	    BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.JPG);
	    BitmapEncoder.saveJPGWithQuality(chart, "./Sample_Chart_With_Quality.jpg", 0.95f);
	    BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.BMP);
	    BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.GIF);
	 
	    BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
	    BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.JPG, 300);
	    BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.GIF, 300);
	 
	   // VectorGraphicsEncoder.saveVectorGraphic(chart, "./Sample_Chart", VectorGraphicsFormat.EPS);
	   // VectorGraphicsEncoder.saveVectorGraphic(chart, "./Sample_Chart", VectorGraphicsFormat.PDF);
	   // VectorGraphicsEncoder.saveVectorGraphic(chart, "./Sample_Chart", VectorGraphicsFormat.SVG);
	 
	  }
	}