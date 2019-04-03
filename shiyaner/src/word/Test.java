package word;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants; 

  

public class Test extends JFrame{ 

	private static final long serialVersionUID = 1L;
	static final int DEFAULT_WIDTH = 800;
	 static final int DEFAULT_HEIGHT = 800;
	 private static JTextField text1 ;
	 int n=0;
    // 统计数字或者字符出现的次数 
    public static int Pross(String str) { 

        char[] charArray = str.toCharArray(); 
        int all = 0;
        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>(); 
        for (int x = 0; x < charArray.length; x++)
        { 
            if (!tm.containsKey(charArray[x])) 
            { 
                tm.put(charArray[x], 1); 
            } 
            else
            { 
                int count = tm.get(charArray[x]) + 1; 
                tm.put(charArray[x], count); 
                all=all+count;
            } 
          
        } 
       
        return all;
     
    } 
    
    
    public Test() { 
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
    //	Scanner in = new Scanner(System.in);
        BufferedReader br = null; 

        int line = 0; 

        String str = ""; 

        StringBuffer sb  = new StringBuffer(); 

        try { 
        	
        	
          //br = new BufferedReader(new FileReader("src\\\\DATA.txt")); 
        	//System.out.println("请输入读取文件的文件名：");
        	 s =text1.getText();
      		@SuppressWarnings("resource")
      		BufferedReader BR= new BufferedReader(new FileReader(s));
      		String value;

           while ((str = BR.readLine()) != null) { 

                sb.append(str); 

                ++line; 

           } 

            int S=Pross(sb.toString());
            n=S;

          // System.out.println("\n字符统计结果为：" + S); 

        } 
    catch (FileNotFoundException e) 
        { 

            e.printStackTrace(); 

        } catch (IOException e) { 

            e.printStackTrace(); 

        } finally { 

            if (br != null) { 

                try { 

                    br.close(); 
                } catch (IOException e) { 
                    // TODO Auto-generated catch block 
                    e.printStackTrace(); 
                } 
            } 

        } 
        try 
	    {
	    	long startTime=System.currentTimeMillis();
	        long lines = Files.lines(Paths.get(new File("src\\DATA.txt").getPath())).count();
	        long endTime=System.currentTimeMillis();
	        result.append("字符统计结果为：" + n+"\n行数: " + lines+"\n所消耗时间为:"+ (endTime-startTime)+"ms" );
	       
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