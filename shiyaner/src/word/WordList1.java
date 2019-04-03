package word;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

/*
 统计文件中单词出现的频数并输出到文件
 */
public class WordList {

	
	static ArrayList<String> Eword=new ArrayList(){{add("the");add("on");
	add("a");add("about");add("above");add("across");add("after");
	add("against");add("along");add("among");add("around");add("as");
	add("at");add("before");add("behind");add("below");add("beside");
	add("between");add("beyond");add("but");add("by");add("down");
	add("during");add("except");add("for ");add("from");add("in");
	add("inside ");add("I");add("you");add("he");add("she");
	add("it");add("we");add("they");add("me");add("you");
	add("him");add("her");add("it");add("us");add("them");add("my");
	add("your");add("his");add("its");add("our");add("their");add(" mine");
	add("yours");add(" hers");add("ours");add("theirs");add("myself");add("yourself ");
	add("himself ");add("herself");add("itself");add("ourselves ");add("yourselve");add("this");
	add("that");add("that");add("these");add("those");add("such");add("some");
	add("who");add("whom");add("whose");add("what");add("whichever");add("whose");
	add("one");add("some");add("any");add("each");add("every");add("none");
	add("no");add("many");add("much");add("few");add("little");add("a few");
	add("behave");add("fee of");add("cheat");add("chef in");add("choice");add("compare");
	}}; 
	// 统计文件中单词出现的频数
	public void wcount(){
		Scanner in = new Scanner(System.in);
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
				//List<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
				ArrayList<Map.Entry<String, Integer>> ordlist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
				int i,j;
			    for(j=0;j<ordlist.size();j++) 
			    {  
			        for(i=0;i<Eword.size();i++)
			        {
			            if(Eword.get(i).equals(ordlist.get(j).getKey()))
			            {
			                ordlist.remove(j);
			                break;                  
			            }
			        }
			   } 
			    
				// 用sort函数来排序
				Collections.sort(ordlist,valcom);
			
				System.out.println("该文件中共有"+ordlist.size()+"个不同的单词！");
				
				System.out.println("----------按照单词出现频次降序排序---------------");
				
				for (Map.Entry<String, Integer> entry : ordlist) 
					//System.out.println("单词 "+entry.getKey() + " 出现 " + entry.getValue()+" 次 ");
					System.out.printf("单词 "+"%-8s" + "出现 " +"%-3d"+" 次 |\n",entry.getKey(),entry.getValue());	
					
				System.out.println("------------------------------------------------");	
				
				
				//将词频统计结果输出到指定文件results.txt中
				try {
					
					FileWriter fw= new FileWriter("src\\results.txt");
					BufferedWriter bw= new BufferedWriter(fw); 
					for (Map.Entry<String, Integer> entry : ordlist) {
						
						bw.write(entry.getKey() + ":" + entry.getValue());	
						bw.newLine();
					}
					bw.flush();
					bw.close();
					System.out.println("词频统计结果已输出到result.txt文件！");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try 
			    {
			    	long startTime=System.currentTimeMillis();
			        long lines = Files.lines(Paths.get(new File("src\\DATA.txt").getPath())).count();
			        //System.out.println("Total number of lines : " + lines);
			        long endTime=System.currentTimeMillis();
			        System.out.println("所消耗时间为:"+ (endTime-startTime)+"ms"  );
			    }
			    catch (IOException e)
			       {
			         System.out.println("No File Found");
			       }
	}
	
}
