package jfreechart;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart_AWT extends ApplicationFrame {
   
   public BarChart_AWT( String applicationTitle , String chartTitle ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Category",            
         "Score",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
      File BarChart = new File( "BarCh1.jpeg" ); 
      try {
		ChartUtilities.saveChartAsPNG(BarChart, barChart, 900, 300);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   private CategoryDataset createDataset( ) {
      final String fiat = "Name";        
      final String audi = "AUDI";        
      final String ford = "FORD";        
      final String speed = "Speed";        
      final String millage = "Millage";        
      final String userrating = "User Rating";        
      final String safety = "safety";        
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 1.0 , fiat ,"2.7" );        
      dataset.addValue( 3.0 , fiat , "2.8" );        
      dataset.addValue( 5.0 , fiat , "2.9" ); 
      
      
      
      return dataset; 
   }
   
   public static void main( String[ ] args ) {
      BarChart_AWT chart = new BarChart_AWT("Pass %", 
         "Patient Name Coverage Statistics");
      chart.pack( );        
      RefineryUtilities.centerFrameOnScreen( chart );        
      chart.setVisible( true ); 
     
      
   }
}
