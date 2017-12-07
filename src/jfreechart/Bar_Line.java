package jfreechart;

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;

public class Bar_Line {
	public static void main(String args[])
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int[] times = new int[]{1,2,3,4,5,6,7,8,9};
		for ( int i = 0; i < times.length; i++ ){
		    dataset.addValue(times[i], "Time", "Hour" + String.valueOf(i+1));
		}

		//create the plot
		  CategoryChart plot = new CategoryChartBuilder().width(600).height(300).title("passed against each Version").xAxisTitle("Version").yAxisTitle("Pass % ").build();

		//add the first dataset, and render as bar values
		CategoryItemRenderer renderer = new BarRenderer();
		((CategoryPlot) plot).setDataset(0,dataset);
		plot.setRenderer(0,renderer);  

		//add the second dataset, render as lines
		CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
		plot.setDataset(1, dataset);
		plot.setRenderer(1, renderer2);

		//set axis 
		plot.setDomainAxis(new CategoryAxis("Time"));
		plot.setRangeAxis(new NumberAxis("Value"));
		 BitmapEncoder.saveBitmap(plot, "./Sample_Chart", BitmapFormat.PNG);
	}

}
