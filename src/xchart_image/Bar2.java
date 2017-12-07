package xchart_image;

import java.awt.Color;
import java.util.Arrays;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.bar.BarChart01;
import org.knowm.xchart.demo.charts.bar.BarChart02;
import org.knowm.xchart.demo.charts.bar.BarChart03;
import org.knowm.xchart.demo.charts.bar.BarChart04;
import org.knowm.xchart.demo.charts.bar.BarChart05;
import org.knowm.xchart.demo.charts.bar.BarChart06;
import org.knowm.xchart.demo.charts.bar.BarChart07;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;

public class Bar2 implements ExampleChart<CategoryChart> {
	 
	  public static void main(String[] args) {
	 
	    ExampleChart<CategoryChart> exampleChart = new BarChart01();
	    CategoryChart chart = exampleChart.getChart();
	    new SwingWrapper<CategoryChart>(chart).displayChart();
	  }
	 
	  @Override
	  public CategoryChart getChart() {
	 
	    // Create Chart
	    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();
	 
	    // Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
	    chart.getStyler().setHasAnnotations(true);
	    chart.getStyler().setErrorBarsColor(Color.WHITE);
	    chart.getStyler().setChartTitleBoxBackgroundColor(Color.YELLOW);
	    chart.getStyler().setLegendBackgroundColor(Color.GRAY);
	    Color[] sliceColors = new Color[] { new Color(0, 128, 0), new Color(255, 0, 0) };
	    chart.getStyler().setSeriesColors(sliceColors);
	    //String clr[]= {"Color.WHITE","Color.WHITE","Color.WHITE","Color.WHITE","Color.WHITE"};
	    chart.getStyler().setLegendSeriesLineLength(1000);
	   // BitmapEncoder.saveBitmapWithDPI(chart, "barchart", BitmapEncoder.BitmapFormat.PNG, 150);
	 
	    // Series
	    chart.addSeries("test 1", Arrays.asList(new Integer[] { 0, 1, 2, 3, 4 }), Arrays.asList(new Integer[] { 4, 5, 9, 6, 5 }));
	 
	    return chart;
	  }
	}