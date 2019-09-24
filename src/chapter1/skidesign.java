/*
ID: 15605181
LANG: JAVA
TASK: skidesign
*/
package chapter1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class skidesign {
	
	public int min(int num1,int num2){
		if(num1>num2)
			return num2;
		return num1;
	}
   public static void main(String[] args) throws NumberFormatException, IOException{
	   skidesign Object=new skidesign();
	   int res=Integer.MAX_VALUE;
    	BufferedReader bf=new BufferedReader(new FileReader("./txt/skidesign.in"));
    	PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/skidesign.out")));
    	int num=Integer.parseInt(bf.readLine());
    	List<Integer> list=new ArrayList<Integer>();
    	
    	String line=bf.readLine();
    	while(line!=null){
    		list.add(Integer.parseInt(line));
    		line=bf.readLine();
    	}
    	int lowest=list.get(0);
    	int highest=list.get(0);
    	for(int i=1;i<num;i++){
    		if(list.get(i)<lowest)
    			lowest=list.get(i);
    		if(list.get(i)>highest)
    			highest=list.get(i);
    	}
    	int len=list.size();
    	
    	
    	for(int i=lowest;i<=highest-17;i++){
    		int tmp=0;
    		for(int j=0;j<len;j++){
    			if(list.get(j)<i) tmp+=(i-list.get(j))*(i-list.get(j));
    			if(list.get(j)>i+17) tmp+=(list.get(j)-i-17)*(list.get(j)-i-17);
    		}
    		res=Object.min(res,tmp);
    	}
    	
    	//System.out.println(res);
      out.println(res);
      out.close();
    	
    }
}
