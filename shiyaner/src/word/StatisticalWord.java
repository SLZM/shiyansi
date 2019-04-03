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
		 northPanel.add(new JLabel("������txt�ļ�",SwingConstants.CENTER));
		 northPanel.add(text1);
		 northPanel.add(new JLabel("���뵥��",SwingConstants.CENTER));
		 northPanel.add(text2);
		 northPanel.add(new JLabel("���",SwingConstants.CENTER));
		 northPanel.add(result);
		 
		 add(northPanel,BorderLayout.CENTER);
		 
		 JPanel southPanel = new JPanel();
		 JButton insertButton = new JButton("ȷ��");
		 southPanel.add(insertButton);
		 JButton Button1 = new JButton("ȡ��");
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
		    		 String filecontent = "";//������Ŷ�ȡ�����ļ�������Ϣ
		    		 
		           //�ü�ֵ�Էֱ�洢���ʺ������ֵĴ���
		           Map<String,Integer> map = new HashMap<String, Integer>();
		           String str = "";
		    	   try
		    	   {
		    		   //System.out.println("�������ȡ�ļ����ļ�����");
		    		   s =text1.getText();
		    	 		@SuppressWarnings("resource")
		    	 		BufferedReader br = new BufferedReader(new FileReader(s));
		    	 		String value;
		    	       //һ��һ�ж�ȡ
		    	       while ((str = br.readLine()) != null)
		    	       {
		    	       	filecontent = filecontent + str;
		    	       }
		    	   }
		    	   catch (IOException e) 
		    	   {
		    	       e.printStackTrace();
		    	   }
		           //sum��������ͳ�Ƶ��ʳ��ֵĴ���
		           String [] sum = filecontent.split("[^a-zA-Z]+");
		           for (int i=0;i<sum.length;i++){

		          
		               if (map.get(sum[i]) == null){
		               	//ͳ�Ƽ�ֵ��
		                   map.put(sum[i],1);
		               }else {
		                   int count = map.get(sum[i]);
		                   map.put(sum[i],++count);
		               }
		           }
		           //����TreeMapʵ��Comparator�ӿ�
		           Comparator<Map.Entry<String, Integer>> valcom = new Comparator<Map.Entry<String,Integer>>() {

		           	//�Դ�Ƶͳ�ƽ����������
		    	        public int compare(Map.Entry<String, Integer> rst1,Map.Entry<String, Integer> rst2) {
		    	        	//��������
		    	        	int sortrst=rst2.getValue()-rst1.getValue();
		    				return sortrst;					
		    	        	} 
		    	        
		    	        };
		    				
		    	        List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		    			
		    			// ��sort����������
		    			Collections.sort(ordlist,valcom);
		    			
		    			w=text1.getText();
		    	       // Scanner in1 = new Scanner(System.in);
		    	       // System.out.println("��������Ҫͳ�Ƴ����������еĵ���:");
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
		    		        result.append("������ʱ��Ϊ:"+ (endTime-startTime)+"ms");
		    		        //System.out.println("������ʱ��Ϊ:"+ (endTime-startTime)+"ms"  );
		    		    }
		    		    catch (IOException e)
		    		       {
		    		         System.out.println("No File Found");
		    		       }
		    	        
		    	        JFreeChart chart = ChartFactory.createBarChart3D(
		    	                   "����Ƶ��",
		    	                   "����",//X��ı�ǩ 
		    	                   "Ƶ��",//Y��ı�ǩ 
		    	                   dataset, //ͼ����ʾ�����ݼ���
		    	                   PlotOrientation.VERTICAL, //ͼ�����ʾ��ʽ��ˮƽ���ߴ�ֱ��
		    	                   false,//�Ƿ���ʾ�ӱ��� 
		    	                   false,//�Ƿ�������ʾ�ı�ǩ 
		    	                   false); //�Ƿ�����URL����
		    	        
		    	        
		    	        
		    	        //���������������
		                chart.getTitle().setFont(new Font("����",Font.BOLD,18));

		                //��ȡͼ���������
		                CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();

		                //��ȡX��Ķ���
		                CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();

		                //��ȡY��Ķ���
		                NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot.getRangeAxis();

		                //����X���ϵ�����
		                categoryAxis3D.setTickLabelFont(new Font("����",Font.BOLD,10));

		                //����X���������
		                categoryAxis3D.setLabelFont(new Font("����",Font.BOLD,10));

		                //����Y���ϵ�����
		                numberAxis3D.setTickLabelFont(new Font("����",Font.BOLD,10));

		                //����Y���������
		                numberAxis3D.setLabelFont(new Font("����",Font.BOLD,10));

		                //�Զ���Y������ʾ�Ŀ̶ȣ���10��Ϊ1��
		                numberAxis3D.setAutoTickUnitSelection(false);
		                NumberTickUnit unit = new NumberTickUnit(1); 
		                numberAxis3D.setTickUnit(unit);

		                //��ȡ��ͼ�������
		                BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();

		                //��������ͼ�Ŀ��
		                barRenderer3D.setMaximumBarWidth(0.07);

		                //��ͼ������ʾ����
		                barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		                barRenderer3D.setBaseItemLabelsVisible(true);
		                barRenderer3D.setBaseItemLabelFont(new Font("����",Font.BOLD,10));
		                
		                
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
		    		System.exit(1);//��ֹ��ǰ����
		    		
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
		 String filecontent = "";//������Ŷ�ȡ�����ļ�������Ϣ
		 
       //�ü�ֵ�Էֱ�洢���ʺ������ֵĴ���
       Map<String,Integer> map = new HashMap<String, Integer>();
       String str = "";
	   try
	   {
		   System.out.println("�������ȡ�ļ����ļ�����");
	 		String s = in.nextLine();
	 		@SuppressWarnings("resource")
	 		BufferedReader br = new BufferedReader(new FileReader(s));
	 		String value;
	       //һ��һ�ж�ȡ
	       while ((str = br.readLine()) != null)
	       {
	       	filecontent = filecontent + str;
	       }
	   }
	   catch (IOException e) 
	   {
	       e.printStackTrace();
	   }
       //sum��������ͳ�Ƶ��ʳ��ֵĴ���
       String [] sum = filecontent.split("[^a-zA-Z]+");
       for (int i=0;i<sum.length;i++){

      
           if (map.get(sum[i]) == null){
           	//ͳ�Ƽ�ֵ��
               map.put(sum[i],1);
           }else {
               int count = map.get(sum[i]);
               map.put(sum[i],++count);
           }
       }
       //����TreeMapʵ��Comparator�ӿ�
       Comparator<Map.Entry<String, Integer>> valcom = new Comparator<Map.Entry<String,Integer>>() {

       	//�Դ�Ƶͳ�ƽ����������
	        public int compare(Map.Entry<String, Integer> rst1,Map.Entry<String, Integer> rst2) {
	        	//��������
	        	int sortrst=rst2.getValue()-rst1.getValue();
				return sortrst;					
	        	} 
	        
	        };
				
	        List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
			
			// ��sort����������
			Collections.sort(ordlist,valcom);
			
			 
	        Scanner in1 = new Scanner(System.in);
	        System.out.println("��������Ҫͳ�Ƴ����������еĵ���:");
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
		        System.out.println("������ʱ��Ϊ:"+ (endTime-startTime)+"ms"  );
		    }
		    catch (IOException e)
		       {
		         System.out.println("No File Found");
		       }
	        
	        JFreeChart chart = ChartFactory.createBarChart3D(
	                   "����Ƶ��",
	                   "����",//X��ı�ǩ 
	                   "Ƶ��",//Y��ı�ǩ 
	                   dataset, //ͼ����ʾ�����ݼ���
	                   PlotOrientation.VERTICAL, //ͼ�����ʾ��ʽ��ˮƽ���ߴ�ֱ��
	                   false,//�Ƿ���ʾ�ӱ��� 
	                   false,//�Ƿ�������ʾ�ı�ǩ 
	                   false); //�Ƿ�����URL����
	        
	        //���������������
            chart.getTitle().setFont(new Font("����",Font.BOLD,18));

            //��ȡͼ���������
            CategoryPlot categoryPlot = (CategoryPlot)chart.getPlot();

            //��ȡX��Ķ���
            CategoryAxis3D categoryAxis3D = (CategoryAxis3D)categoryPlot.getDomainAxis();

            //��ȡY��Ķ���
            NumberAxis3D numberAxis3D = (NumberAxis3D)categoryPlot.getRangeAxis();

            //����X���ϵ�����
            categoryAxis3D.setTickLabelFont(new Font("����",Font.BOLD,10));

            //����X���������
            categoryAxis3D.setLabelFont(new Font("����",Font.BOLD,10));

            //����Y���ϵ�����
            numberAxis3D.setTickLabelFont(new Font("����",Font.BOLD,10));

            //����Y���������
            numberAxis3D.setLabelFont(new Font("����",Font.BOLD,10));

            //�Զ���Y������ʾ�Ŀ̶ȣ���10��Ϊ1��
            numberAxis3D.setAutoTickUnitSelection(false);
            NumberTickUnit unit = new NumberTickUnit(1); 
            numberAxis3D.setTickUnit(unit);

            //��ȡ��ͼ�������
            BarRenderer3D barRenderer3D = (BarRenderer3D)categoryPlot.getRenderer();

            //��������ͼ�Ŀ��
            barRenderer3D.setMaximumBarWidth(0.07);

            //��ͼ������ʾ����
            barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            barRenderer3D.setBaseItemLabelsVisible(true);
            barRenderer3D.setBaseItemLabelFont(new Font("����",Font.BOLD,10));

            
          

	        
	             
     
//}

  
  
    

}

/*
 * ͳ��ָ�����ʸ���
 */
    

}	 


