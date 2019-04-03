package word;

import java.awt.BorderLayout;
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
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * 统计前K个出现的频次最高的单词
 */
public class Figure extends JFrame {
	private static final long serialVersionUID = 1L;
	static final int DEFAULT_WIDTH = 800;
	 static final int DEFAULT_HEIGHT = 800;
	 private static JTextField text1 ;
	 private static JTextField text2 ;
	 
	 
	 static String line;
	
	public  Figure(){
		JTextArea  result = new JTextArea(CROSSHAIR_CURSOR,CROSSHAIR_CURSOR);
		 text1 = new JTextField();
		 text2 = new JTextField();
		// result = new JTextField();
		 JPanel northPanel = new JPanel();
		 northPanel.setLayout(new GridLayout(8,8));
		 northPanel.add(new JLabel("请输入txt文件",SwingConstants.CENTER));
		 northPanel.add(text1);
		 northPanel.add(new JLabel("请输入前k个单词",SwingConstants.CENTER));
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
		
		
		Scanner in = new Scanner(System.in);
		 String filecontent = "";
              Map<String,Integer> map = new HashMap<String, Integer>();
              String str = "";
              try
       {
            	  //System.out.println("请输入读取文件的文件名：");
            	  s =text1.getText();
          		@SuppressWarnings("resource")
          		BufferedReader br = new BufferedReader(new FileReader(s));
          		String value;
           try
           {
               while ((str = br.readLine()) != null)
               {
               	filecontent = filecontent + str;
               }
           } 
           catch (IOException e) 
           {
               e.printStackTrace();
           }
       }
       catch (FileNotFoundException e)
       {
           e.printStackTrace();
       }
       String []sum = filecontent.split("[^a-zA-Z]+");
       for (int i=0;i<sum.length;i++)
       {
           if (map.get(sum[i]) == null)
           {
               map.put(sum[i],1);
           }
           else 
           {
               int count = map.get(sum[i]);
               map.put(sum[i],++count);
           }
       }
       //利用TreeMap实现Comparator接口
       Comparator<Map.Entry<String, Integer>> valcom = new Comparator<Map.Entry<String,Integer>>() {
	        public int compare(Map.Entry<String, Integer> rst1,Map.Entry<String, Integer> rst2) {
	        	int sortrst=rst2.getValue()-rst1.getValue();
				return sortrst;
				
	        	} 
	        
	        };
				List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
				Collections.sort(ordlist,valcom);
				//Scanner sc = new Scanner(System.in); 
				//System.out.println("请输入要查看的最高词频的个数:"); 
				int k=0;
				w=text1.getText();
		        if(k>0&&k<=ordlist.size())
		        {
		        	//System.out.println("----------词频最高的前"+k+"个单词频数-----------");
					
					for (Map.Entry<String, Integer> entry : ordlist) {
						result.append("单词 "+"%-8s"+ entry.getKey()+ "出现" +"%-3d"+"次"+entry.getValue()+"\n");
					//	System.out.printf("单词 "+"%-8s" + "出现" +"%-3d"+"次 ",entry.getKey(),entry.getValue());	
						//用符号个数来显示模拟柱状图
							//for(int i=entry.getValue();i>0;i--)
							//{
							//	System.out.print("▏");
							//}
							System.out.println();
							//System.out.println(entry.getKey() + ":" + entry.getValue());
							
							if(--k==0)
								break;//k=0,则不再输出后面的词频					
						
					}
					System.out.println("------------------------------------------------");	

		        }
		        else
		        {
		        	//System.out.println("输入有误！请重新输入！");
		        }

		        try 
			    {
			    	long startTime=System.currentTimeMillis();
			        long lines = Files.lines(Paths.get(new File("src\\DATA.txt").getPath())).count();
			        long endTime=System.currentTimeMillis();
			        result.append("所消耗时间为:"+ (endTime-startTime)+"ms");
			       // System.out.println("所消耗时间为:"+ (endTime-startTime)+"ms"  );
			    }
			    catch (IOException e)
			       {
			         System.out.println("No File Found");
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


	public void wcount() {
		// TODO Auto-generated method stub
		
	}

	
}

