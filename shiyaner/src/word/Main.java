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
		 JButton Button1 = new JButton("����1 ͳ��ָ�����ʴ�Ƶ��������ʾ��״ͼ");
		 Panel.add(Button1);
		 JButton Button2 = new JButton("����2 ͳ�ƴ�Ƶ������������ı�");
		 Panel.add(Button2);
		 JButton Button3 = new JButton("����3 ��ѯK������Ƶ����ߵĵ���");
		 Panel.add(Button3);
		 JButton Button4 = new JButton("����4 ͳ���ı����������ַ�ͳ����");
		 Panel.add(Button4);
		 JButton Button5 = new JButton("���ӹ���1 �����ڽ�֮��Ĵ�Ƶ������ı�");
		 Panel.add(Button5);
		 JButton Button6 = new JButton("����6 �˳�");
		 Panel.add(Button6);
		 
		 //*******************************************************
		 Button1.addActionListener(new ActionListener()
		    {
		    	public void actionPerformed(ActionEvent event)
		    	{
		    		StatisticalWord frame = new StatisticalWord();
					//frame.setBounds(200,300,500,800);
					frame.setTitle("ͳ��ָ�����ʴ�Ƶ��������ʾ��״ͼ");
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
					frame.setTitle("ͳ�ƴ�Ƶ������������ı�");
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
		    		frame.setTitle("��ѯK������Ƶ����ߵĵ���");
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
					frame.setTitle("ͳ���ı����������ַ�ͳ����");
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
					frame.setTitle("�����ڽ�֮��Ĵ�Ƶ������ı�");
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
		    		System.exit(0);//��ֹ��ǰ����
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
				frame.setTitle("Ӣ���ı���Ƶͳ��");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
				
				
			});
		}
	

/*public class Main { 
	
	
	
	
     public static void main(String[] args) { 
    	 
    	System.out.println("\n********************���� �˵�*********************"); 
     	System.out.println("*              ����ѡ�                           \t\t\t\t\t"); 
   	    System.out.println("*  ����1-----ͳ�ƴ�Ƶ��������ʾ���\t\t"); 
    	System.out.println("*  ����2-----ͳ��ָ�����ʴ�Ƶ��������ʾ��״ͼ\t\t\t"); 
    	System.out.println("*  ����3-----��ѯK������Ƶ����ߵĵ���"); 
    	System.out.println("*  ����4-----ͳ���ı����������ַ�ͳ����"); 
    	System.out.println("*************************************************\n"); 
  
    	Scanner sc = new Scanner(System.in);  
        System.out.println("�����빦�ܺ�:");       
       
       
       
       String opt=sc.next();//�û�����������Ǹ������͵� 
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
     		System.out.println("�����������������룡"); 
     		main(null); 
     		break; 
     		 
     	} 
     	 
     } 
     */
     //����1 
     public static void optWordList()
     { 
     	WordList WordList= new WordList(); 
     	WordList.wcount(); 
 	  }     
    
     //����2 
     public static void optStatisticalWord()
     { 
    	 StatisticalWord StatisticalWord= new StatisticalWord(); 
    	 StatisticalWord.StatisticalWord();  
     } 
    
     //����3
    public static void optFigure()
    {   
    	Figure Figure= new Figure(); 
    	Figure.wcount(); 
 	} 
  
   
   //����4
   public static void optTest()
   {   
	   Test Test= new Test(); 
	   Test.wcount(); 
	} 
  
 } 
