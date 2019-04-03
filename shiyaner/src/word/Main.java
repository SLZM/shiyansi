package word;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main extends JFrame {
	/**
	 * 
	 */
	 static final int DEFAULT_WIDTH = 1200;
	 static final int DEFAULT_HEIGHT = 1200;
	
	
	
	public Main (){
		 JPanel Panel = new JPanel();
		 Panel.setLayout(new GridLayout(6,10));
		 JButton Button1 = new JButton("功能1 统计指定单词词频个数且显示柱状图");
		 Panel.add(Button1);
		 JButton Button2 = new JButton("功能2 统计词频个数并输出到文本");
		 Panel.add(Button2);
		 JButton Button3 = new JButton("功能3 查询K个出现频次最高的单词");
		 Panel.add(Button3);
		 JButton Button4 = new JButton("功能4 统计文本的行数和字符统计数");
		 Panel.add(Button4);
		 JButton Button5 = new JButton("附加功能1 除代冠介之外的词频输出到文本");
		 Panel.add(Button5);
		 JButton Button6 = new JButton("功能6 退出");
		 Panel.add(Button6);
		 
		 //*******************************************************
		 Button1.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent event)
		    	{
		    		StatisticalWord frame = new StatisticalWord();
					//frame.setBounds(200,300,500,800);
					frame.setTitle("统计指定单词词频个数且显示柱状图");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
		    		optStatisticalWord(); 
		    	}
		    });

		 add(Panel,BorderLayout.CENTER);
		 pack();
		 
		 //*******************************************************
		 Button2.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent event)
		    	{
		    		WordList frame = new WordList();
					//frame.setBounds(200,300,500,800);
					frame.setTitle("统计词频个数并输出到文本");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					optWordList();
		    	}
		    });

		 add(Panel,BorderLayout.CENTER);
		 pack();
		 
		 //*******************************************************
		 Button3.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent event)
		    	{
		    		Figure frame = new Figure();
					//frame.setBounds(200,300,500,800);
		    		frame.setTitle("查询K个出现频次最高的单词");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					optFigure();
		    	}
		    });

		 add(Panel,BorderLayout.CENTER);
		 pack();
		 
		 //*******************************************************
		 Button4.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent event)
		    	{
		    		Test frame = new Test();
					//frame.setBounds(200,300,500,800);
					frame.setTitle("统计文本的行数和字符统计数");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					optTest();
		    	}
		    });

		 add(Panel,BorderLayout.CENTER);
		 pack();
		 
		 //*******************************************************
		 Button5.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent event)
		    	{
		    		WordList frame = new WordList();
					//frame.setBounds(200,300,500,800);
					frame.setTitle("除代冠介之外的词频输出到文本");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					optWordList();
		    	}
		    });

		 add(Panel,BorderLayout.CENTER);
		 pack();
		 
		 //*******************************************************
		 Button6.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent event)
		    	{
		    		System.exit(0);//终止当前程序
		    	}
		    });

		 add(Panel,BorderLayout.CENTER);
		 pack();
		 
		 
		 
		

	}
	
	 public static void main(String[] args)
		{
			EventQueue.invokeLater(() ->
			{
				Main frame = new Main();
				frame.setTitle("英文文本词频统计");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				
				
			});
		}
	

/*public class Main { 
	
	
	
	
     public static void main(String[] args) { 
    	 
    	System.out.println("\n********************功能 菜单*********************"); 
     	System.out.println("*              功能选项：                           \t\t\t\t\t"); 
   	    System.out.println("*  功能1-----统计词频个数并显示结果\t\t"); 
    	System.out.println("*  功能2-----统计指定单词词频个数且显示柱状图\t\t\t"); 
    	System.out.println("*  功能3-----查询K个出现频次最高的单词"); 
    	System.out.println("*  功能4-----统计文本的行数和字符统计数"); 
    	System.out.println("*************************************************\n"); 
  
    	Scanner sc = new Scanner(System.in);  
        System.out.println("请输入功能号:");       
       
       
       
       String opt=sc.next();//用户的输入可能是各种类型的 
       Main m=new Main(); 
        
   	switch(opt){ 
   	
   	case "1":  
  		m.optWordList(); 
    		main(null); 
    		break;
    		
   	case "2": 
     	m.optStatisticalWord(); 
     		main(null); 
     		break; 
     		
     	
   	case "3":  
    		m.optFigure(); 
     		main(null); 
     		break;
     		

   	case "4":  
		m.optTest(); 
 		main(null); 
 		break;
 		
   	
 		
 		
     	default:  
     		System.out.println("输入有误，请重新输入！"); 
     		main(null); 
     		break; 
     		 
     	} 
     	 
     } 
     */
     //功能1 
     public static void optWordList()
     { 
     	WordList WordList= new WordList(); 
     	WordList.wcount(); 
 	  }     
    
     //功能2 
     public static void optStatisticalWord()
     { 
    	 StatisticalWord StatisticalWord= new StatisticalWord(); 
    	 StatisticalWord.StatisticalWord();  
     } 
    
     //功能3
    public static void optFigure()
    {   
    	Figure Figure= new Figure(); 
    	Figure.wcount(); 
 	} 
  
   
   //功能4
   public static void optTest()
   {   
	   Test Test= new Test(); 
	   Test.wcount(); 
	} 
  
 } 
