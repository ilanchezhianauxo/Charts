package xchart_image;

import java.awt.Color;
import java.util.Arrays;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.demo.charts.bar.BarChart01;
import org.knowm.xchart.demo.charts.bar.BarChart02;
import org.knowm.xchart.demo.charts.bar.BarChart03;
import org.knowm.xchart.demo.charts.bar.BarChart04;
import org.knowm.xchart.demo.charts.bar.BarChart08;
import org.knowm.xchart.demo.charts.bar.BarChart09;
import org.knowm.xchart.style.Styler.LegendPosition;

public class Bar_chart
{
	 
	public static void main(String[] args) 
	{
		ExampleChart<CategoryChart> exampleChart = new BarChart02();
	    CategoryChart chart = exampleChart.getChart();
		double x[]=new double[] {2.6,2.7,2.8,2.9};
	    double y[]=new double[] {23.2,34.5,44.5,67.92};
	    createChart("Name",x,y);
	   
	  }
	 public static void createChart(String name,double pass[],double version[])
	 {
		 ExampleChart<CategoryChart> exampleChart = new BarChart09();
		    CategoryChart chart = new CategoryChartBuilder().width(600).height(300).title(name+"passed against each Version").xAxisTitle("Version").yAxisTitle("Pass % ").build();
			 
		    // Customize Chart
		    chart.getStyler().setLegendPosition(LegendPosition.OutsideE);
		    chart.getStyler().setChartBackgroundColor(Color.getHSBColor(200, 145, 110));
		    chart.getStyler().setLegendPadding(30);
		    chart.getStyler().setHasAnnotations(true);
		    chart.getStyler().setLegendVisible(true);
	        Color[] sliceColors = new Color[] { new Color(51, 204, 51)};
	        chart.getStyler().setSeriesColors(sliceColors);
	       // chart.getStyler().hasAnnotations(true);
	       chart.getStyler().setMarkerSize(15000);
	        chart.getStyler().setPlotContentSize(0.7);	
	        chart.getWidth();
	       // chart.getStyler()
	       // chart.getStyler().setChartBackgroundColor(color)
	       chart.getStyler().setToolTipBorderColor(Color.BLACK);
	        chart.getStyler().setToolTipBackgroundColor(Color.BLUE);
	        //chart
		    // Series
		    chart.addSeries(name, pass, version);
		 
		    new SwingWrapper<CategoryChart>(chart).displayChart();
	 }
	  
	 
	}