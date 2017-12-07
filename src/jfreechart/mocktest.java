package jfreechart;

public class mockTest()
{
	public static void main(String args[])
	{
    //Mock data
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
    int[] times = new int[]{1,2,3,4,5,6,7,8,9};

    for ( int i = 0; i < times.length; i++ ){
        dataset.addValue(times[i], "Time", "Hour" + String.valueOf(i+1));;
        if(i>2)
        {
            dataset2.addValue((times[i] + times[i-1] + times[i-2])/3, "Time", "Hour" + String.valueOf(i+1));

        }

    }
    CategoryPlot plot = new CategoryPlot();

    //create the plot

    //add the first dataset, and render as bar values
    CategoryItemRenderer renderer = new BarRenderer();
    plot.setDataset(0,dataset);
    plot.setRenderer(0,renderer);  

    //add the second dataset, render as lines
    CategoryItemRenderer renderer2 = new LineAndShapeRenderer();
    plot.setDataset(1, dataset2);

    plot.setRenderer(1, renderer2);

    //set axis 
    CategoryAxis domainAxis = new CategoryAxis("Time");  
    NumberAxis rangeAxis = new NumberAxis("Value"); 

    plot.setDomainAxis(0,domainAxis);
    plot.setRangeAxis(rangeAxis);
    JFreeChart chart = new JFreeChart(plot);
    ChartPanel chartPanel = new ChartPanel( chart ); 

    this.setContentPane(chartPanel);
}   
}