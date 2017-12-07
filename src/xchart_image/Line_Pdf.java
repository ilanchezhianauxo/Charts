package xchart_image;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.FontMapper;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class Line_Pdf {

	   public static void main( String[ ] args ) throws Exception 
	   {
		   double[] percentage = new double[] {12,22,45,65};
		   String[] version=new String[] {"2.9.8","2.9.9","2.9.10","2.9.11"};
		   String arg="Patient Name";
		   //
		   DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
		      String name="name";
		      int length=percentage.length;
		      for(int i=0;i<length;i++)
		    {
		    	 line_chart_dataset.addValue( percentage[i], name , version[i] );
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
		     
		     
		     
		     //saveChartAsPDF
		     CategoryPlot p1 = lineChartObject.getCategoryPlot(); 
		     CategoryAxis axis1 = p.getDomainAxis();
		     Font font1 = new Font("Dialog", Font.BOLD, 15);
		     axis.setTickLabelFont(font1);
		     //
		    
		     plot.getRenderer().setPaint(new Color(53, 160, 17));
		     
		    
		      int width = 800;    /* Width of the image */
		      int height = 400;   /* Height of the image */ 
		     // String outputFileName = UUID.randomUUID().toString()+".png";
		      File lineChart = new File("./gggg.pdf"); 
		      
		      saveChartAsPDF(lineChart ,lineChartObject, 400 ,300, null);  
		   //
	   }
	  
	   //
	   public static void writeChartAsPDF(OutputStream out,
			   JFreeChart chart,
			   int width, int height,
			   FontMapper mapper) throws IOException {
			   Rectangle pagesize = new Rectangle(width, height);
			   Document document = new Document();
			   try {
			   PdfWriter writer = PdfWriter.getInstance(document, out);
			   document.addAuthor("JFreeChart");
			   document.addSubject("Demonstration");
			   document.open();
			   PdfContentByte cb = writer.getDirectContent();
			   PdfTemplate tp = cb.createTemplate(width, height);
			   Graphics2D g2 = tp.createGraphics(width, height, mapper);
			   Rectangle2D r2D = new Rectangle2D.Double(0, 0, width, height);
			   chart.draw(g2, r2D, null);
			   g2.dispose();
			   cb.addTemplate(tp, 0, 0);
			   }
			   catch(DocumentException de) {
			   System.err.println(de.getMessage());
			   }
			   document.close();
			   }
	   //
	   public static void saveChartAsPDF(File file,
			   JFreeChart chart,
			   int width, int height,
			   FontMapper mapper) throws IOException {
			   OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
			   writeChartAsPDF(out, chart, width, height, mapper);
			   out.close();
			   }
	   //
	}