package word;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
 统计文件中单词出现的频数并输出到文件
 */
public class WordList extends JFrame{
	private static final long serialVersionUID = 1L;
	static final int DEFAULT_WIDTH = 800;
	 static final int DEFAULT_HEIGHT = 800;
	 private static JTextField text1 ;
	
	// 统计文件中单词出现的频数
	 public WordList(){
		 JTextArea  result = new JTextArea(CROSSHAIR_CURSOR,CROSSHAIR_CURSOR);
		 text1 = new JTextField();
		
		// result = new JTextField();
		 JPanel northPanel = new JPanel();
		 northPanel.setLayout(new GridLayout(8,10));
		 northPanel.add(new JLabel("请输入txt文件",SwingConstants.CENTER));
		 northPanel.add(text1);
		 
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
		    		String filecontent = "";//用来存放读取到的文件内容信息
		            //用键值对分别存储单词和它出现的次数
		            Map<String,Integer> map = new HashMap<String, Integer>();
		            try 
		            {
		            	//System.out.println("请输入读取文件的文件名：");
		            	 s =text1.getText();
		          		@SuppressWarnings("resource")
		          		BufferedReader br = new BufferedReader(new FileReader(s));
		          		String value;
		                String str = "";
		                try
		                {
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
		            }
		            catch (FileNotFoundException e)
		            {
		                e.printStackTrace();
		            }
		            //arrspilt数组用来统计单词出现的次数
		            String [] arrspilt = filecontent.split("[^a-zA-Z]+");
		            for (int i=0;i<arrspilt.length;i++){

		                //通过键名来获取键值
		                if (map.get(arrspilt[i]) == null){
		                	//统计键值对
		                    map.put(arrspilt[i],1);
		                }else {
		                    int count = map.get(arrspilt[i]);
		                    map.put(arrspilt[i],++count);
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
		    			
		    				System.out.println("该文件中共有"+ordlist.size()+"个不同的单词！");
		    				
		    			/*	System.out.println("----------按照单词出现频次降序排序---------------");
		    				
		    				for (Map.Entry<String, Integer> entry : ordlist) 
		    					//System.out.println("单词 "+entry.getKey() + " 出现 " + entry.getValue()+" 次 ");
		    					System.out.printf("单词 "+"%-8s" + "出现 " +"%-3d"+" 次 |\n",entry.getKey(),entry.getValue());	
		    					
		    				System.out.println("------------------------------------------------");	*/
		    				
		    				
		    		//将词频统计结果输出到指定文件results.txt中
		    				try {
		    					
		    					FileWriter fw= new FileWriter("src\\results.txt");
		    					BufferedWriter bw= new BufferedWriter(fw); 
		    					//for (Map.Entry<String, Integer> entry : ordlist) 
		    					for (Map.Entry<String, Integer> entry : ordlist) {
		    						
		    						bw.write(entry.getKey() + ":" + entry.getValue());	
		    						bw.newLine();
		    					}
		    					bw.flush();
		    					bw.close();   
		    				            
		    				        bw.close();
		    					//System.out.println("词频统计结果已输出到result.txt文件！");
		    				} catch (IOException e) {
		    					// TODO Auto-generated catch block
		    					e.printStackTrace();
		    				}
		    		        long startTime=System.currentTimeMillis();
		          // long lines = Files.lines(Paths.get(new File("src\\DATA.txt").getPath())).count();
		    				long endTime=System.currentTimeMillis();
		    				 result.append("该文件中共有"+ordlist.size()+"个不同的单词！\n"+"所消耗时间为:"+ (endTime-startTime)+"ms\n"+"词频统计结果已输出到result.txt文件！");
		    				//System.out.println("所消耗时间为:"+ (endTime-startTime)+"ms"  );
		    				
		    	 //}
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
