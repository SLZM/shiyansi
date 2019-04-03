package word;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner; 


 
public class StatisticalWord  extends JFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final int DEFAULT_WIDTH = 800;
	 static final int DEFAULT_HEIGHT = 800;
	 private static JTextField text1 ;
	 private static JTextField text2 ;
	 
	 
	 static String line;
	 
    public StatisticalWord(){
    	//setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    	JTextArea  result = new JTextArea(CROSSHAIR_CURSOR,CROSSHAIR_CURSOR);
		 text1 = new JTextField();
		 text2 = new JTextField();
		// result = new JTextField();
		 JPanel northPanel = new JPanel();
		 northPanel.setLayout(new GridLayout(8,8));
		 northPanel.add(new JLabel("请输入txt文件",SwingConstants.CENTER));
		 northPanel.add(text1);
		 northPanel.add(new JLabel("输入单词",SwingConstants.CENTER));
		 northPanel.add(text2);
		 northPanel.add(new JLabel("结果",SwingConstants.CENTER));
		 northPanel.add(result);
		 
		 add(northPanel,BorderLayout.CENTER);
		 
		 JPanel southPanel = new JPanel();
		 JButton insertButton = new JButton("确定");
		 southPanel.add(insertButton);
		 JButton Button1 = new JButton("取消");
		 southPanel.add(Button1);
		 
		 insertButton.addActionListener(new ActionListener()
		    {
		    	private String s;
		    	private String w;

				public void actionPerformed(ActionEvent event)
		    	{
		    		
		    		//Scanner in = new Scanner(System.in);
		        	int count2=0;
		        	String Word="";
		        	int flag=1;
		    		 String filecontent = "";//用来存放读取到的文件内容信息
		    		 
		           //用键值对分别存储单词和它出现的次数
		           Map<String,Integer> map = new HashMap<String, Integer>();
		           String str = "";
		    	   try
		    	   {
		    		   //System.out.println("请输入读取文件的文件名：");
		    		   s =text1.getText();
		    	 		@SuppressWarnings("resource")
		    	 		BufferedReader br = new BufferedReader(new FileReader(s));
		    	 		String value;
		    	       //一行一行读取
		    	       while ((str = br.readLine()) != null)
		    	       {
		    	       	filecontent = filecontent + str;
		    	       }
		    	   }
		    	   catch (IOException e) 
		    	   {
		    	       e.printStackTrace();
		    	   }
		           //sum数组用来统计单词出现的次数
		           String [] sum = filecontent.split("[^a-zA-Z]+");
		           for (int i=0;i<sum.length;i++){

		          
		               if (map.get(sum[i]) == null){
		               	//统计键值对
		                   map.put(sum[i],1);
		               }else {
		                   int count = map.get(sum[i]);
		                   map.put(sum[i],++count);
		               }
		           }
		           //利用TreeMap实现Comparator接口
		           Comparator<Map.Entry<String, Integer>> valcom = new Comparator<Map.Entry<String,Integer>>() {

		           	//对词频统计结果进行排序
		    	        public int compare(Map.Entry<String, Integer> rst1,Map.Entry<String, Integer> rst2) {
		    	        	//降序排序
		    	        	int sortrst=rst2.getValue()-rst1.getValue();
		    				return sortrst;					
		    	        	} 
		    	        
		    	        };
		    				
		    	        List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		    			
		    			// 用sort函数来排序
		    			Collections.sort(ordlist,valcom);
		    			
		    			w=text1.getText();
		    	       // Scanner in1 = new Scanner(System.in);
		    	       // System.out.println("请输入想要统计出现在文章中的单词:");
		    			//String w = in1.nextLine();
		    			String ws[] = w.split(" ");
		    			String m;
		    			
		    			 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		    			
		    	        for (String word : ws) 
		    	         {
		    	             for (Map.Entry<String, Integer> entry : ordlist)
		    	              {

		    	              if (word.equals(entry.getKey())) 
		                      {
		    	            	//  m=dataset.addValue(entry.getValue(),entry.getKey(),entry.getKey());
		    	            	//  result.setText(String.valueOf(count2));
		                        //System.out.print(entry.getKey()+"   numbers "+entry.getValue()+"   :  ");
		                       dataset.addValue(entry.getValue(),entry.getKey(),entry.getKey());
		                        // System.out.println();
		    	            	 
		                   }
		    	          }
		    	         }
		    	        try 
		    		    {
		    		    	long startTime=System.currentTimeMillis();
		    		        long lines = Files.lines(Paths.get(new File("src\\data.txt").getPath())).count();
		    		        long endTime=System.currentTimeMillis();
		    		        result.append("所消耗时间为:"+ (endTime-startTime)+"ms");
		    		        //System.out.println("所消耗时间为:"+ (endTime-startTime)+"ms"  );
		    		    }
		    		    catch (IOException e)
		    		       {
		    		         System.out.println("No File Found");
		    		       }
		    	        
		    	        JFreeChart chart = ChartFactory.createBarChart3D(
		    	                   "单词频数",
		    	                   "单词",//X轴的标签 
		    	                   "频数",//Y轴的标签 
		    	                   dataset, //图标显示的数据集合
		    	                   PlotOrientation.VERTICAL, //图像的显示形式（水平或者垂直）
		    	                   false,//是否显示子标题 
		    	                   false,//是否生成提示的标签 
		    	                   false); //是否生成URL链接
		    	        
		    	        
		    	        
		    	        //处理主标题的乱码
		                chart.getTitle().setFont(new Font("黑体",Font.BOLD,18));

		                //获取图表区域对象
		                CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();

		                //获取X轴的对象
		                CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();

		                //获取Y轴的对象
		                NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot.getRangeAxis();

		                //处理X轴上的乱码
		                categoryAxis3D.setTickLabelFont(new Font("黑体",Font.BOLD,10));

		                //处理X轴外的乱码
		                categoryAxis3D.setLabelFont(new Font("黑体",Font.BOLD,10));

		                //处理Y轴上的乱码
		                numberAxis3D.setTickLabelFont(new Font("黑体",Font.BOLD,10));

		                //处理Y轴外的乱码
		                numberAxis3D.setLabelFont(new Font("黑体",Font.BOLD,10));

		                //自定义Y轴上显示的刻度，以10作为1格
		                numberAxis3D.setAutoTickUnitSelection(false);
		                NumberTickUnit unit = new NumberTickUnit(1); 
		                numberAxis3D.setTickUnit(unit);

		                //获取绘图区域对象
		                BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();

		                //设置柱形图的宽度
		                barRenderer3D.setMaximumBarWidth(0.07);

		                //在图形上显示数字
		                barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		                barRenderer3D.setBaseItemLabelsVisible(true);
		                barRenderer3D.setBaseItemLabelFont(new Font("宋体",Font.BOLD,10));
		                
		                
		                File file = new File("src\\1.png");
		                  try {
		                       ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
		                      } catch (IOException e) {
		                         e.printStackTrace();
		                    }

		    	}
		    });

		 add(southPanel,BorderLayout.SOUTH);
		 pack();
		 
		 
		 
		 Button1.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent event)
		    	{
		    		System.exit(1);//终止当前程序
		    		
		    	}
		    });

		 add(southPanel,BorderLayout.SOUTH);
		 pack();
    }

    
    
    
    
	protected String setText(String text) {
		// TODO Auto-generated method stub
		return null;
	}





	public void StatisticalWord() 
	{
		// TODO Auto-generated method stub
		
	}
		 
		 /*
    	Scanner in = new Scanner(System.in);
    	int count2=0;
    	String Word="";
    	int flag=1;
		 String filecontent = "";//用来存放读取到的文件内容信息
		 
       //用键值对分别存储单词和它出现的次数
       Map<String,Integer> map = new HashMap<String, Integer>();
       String str = "";
	   try
	   {
		   System.out.println("请输入读取文件的文件名：");
	 		String s = in.nextLine();
	 		@SuppressWarnings("resource")
	 		BufferedReader br = new BufferedReader(new FileReader(s));
	 		String value;
	       //一行一行读取
	       while ((str = br.readLine()) != null)
	       {
	       	filecontent = filecontent + str;
	       }
	   }
	   catch (IOException e) 
	   {
	       e.printStackTrace();
	   }
       //sum数组用来统计单词出现的次数
       String [] sum = filecontent.split("[^a-zA-Z]+");
       for (int i=0;i<sum.length;i++){

      
           if (map.get(sum[i]) == null){
           	//统计键值对
               map.put(sum[i],1);
           }else {
               int count = map.get(sum[i]);
               map.put(sum[i],++count);
           }
       }
       //利用TreeMap实现Comparator接口
       Comparator<Map.Entry<String, Integer>> valcom = new Comparator<Map.Entry<String,Integer>>() {

       	//对词频统计结果进行排序
	        public int compare(Map.Entry<String, Integer> rst1,Map.Entry<String, Integer> rst2) {
	        	//降序排序
	        	int sortrst=rst2.getValue()-rst1.getValue();
				return sortrst;					
	        	} 
	        
	        };
				
	        List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
			
			// 用sort函数来排序
			Collections.sort(ordlist,valcom);
			
			 
	        Scanner in1 = new Scanner(System.in);
	        System.out.println("请输入想要统计出现在文章中的单词:");
			String w = in1.nextLine();
			String ws[] = w.split(" ");
			
			 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			
	        for (String word : ws) 
	         {
	             for (Map.Entry<String, Integer> entry : ordlist)
	              {

	              if (word.equals(entry.getKey())) 
                  {

                    //System.out.print(entry.getKey()+"   numbers "+entry.getValue()+"   :  ");
                    dataset.addValue(entry.getValue(),entry.getKey(),entry.getKey());
                    // System.out.println();
                
                     
               }
	          }
	         }
	        try 
		    {
		    	long startTime=System.currentTimeMillis();
		        long lines = Files.lines(Paths.get(new File("src\\DATA.txt").getPath())).count();
		        long endTime=System.currentTimeMillis();
		        System.out.println("所消耗时间为:"+ (endTime-startTime)+"ms"  );
		    }
		    catch (IOException e)
		       {
		         System.out.println("No File Found");
		       }
	        
	        JFreeChart chart = ChartFactory.createBarChart3D(
	                   "单词频数",
	                   "单词",//X轴的标签 
	                   "频数",//Y轴的标签 
	                   dataset, //图标显示的数据集合
	                   PlotOrientation.VERTICAL, //图像的显示形式（水平或者垂直）
	                   false,//是否显示子标题 
	                   false,//是否生成提示的标签 
	                   false); //是否生成URL链接
	        
	        //处理主标题的乱码
            chart.getTitle().setFont(new Font("黑体",Font.BOLD,18));

            //获取图表区域对象
            CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();

            //获取X轴的对象
            CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();

            //获取Y轴的对象
            NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot.getRangeAxis();

            //处理X轴上的乱码
            categoryAxis3D.setTickLabelFont(new Font("黑体",Font.BOLD,10));

            //处理X轴外的乱码
            categoryAxis3D.setLabelFont(new Font("黑体",Font.BOLD,10));

            //处理Y轴上的乱码
            numberAxis3D.setTickLabelFont(new Font("黑体",Font.BOLD,10));

            //处理Y轴外的乱码
            numberAxis3D.setLabelFont(new Font("黑体",Font.BOLD,10));

            //自定义Y轴上显示的刻度，以10作为1格
            numberAxis3D.setAutoTickUnitSelection(false);
            NumberTickUnit unit = new NumberTickUnit(1); 
            numberAxis3D.setTickUnit(unit);

            //获取绘图区域对象
            BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();

            //设置柱形图的宽度
            barRenderer3D.setMaximumBarWidth(0.07);

            //在图形上显示数字
            barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            barRenderer3D.setBaseItemLabelsVisible(true);
            barRenderer3D.setBaseItemLabelFont(new Font("宋体",Font.BOLD,10));

            
          

	        
	             
     
//}

  
  
    

}

/*
 * 统计指定单词个数
 */
    

}	 


