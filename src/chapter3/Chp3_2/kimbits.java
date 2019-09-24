/*
ID: 15605181
LANG: JAVA
TASK: kimbits
*/
package chapter3.Chp3_2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class kimbits {
	
	public boolean Count_1(String s,int L){
		int res=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='1'){
				res++;
				if(res>L)
					return false;
			}
		}
		return true;
	}
	
	public int inValid(int len,int b){
		int res=1;
		int sub=b-len;
		int i1=1;
		int i2=1;
		int sub1=sub;
		for(int i=0;i<sub;i++){
			i1*=(len-1);
			i2*=sub;
			len--;
			sub--;
		}
		res=i1/i2;
		return res;
	}
	public static void main(String[] args) throws IOException {
		
      kimbits Object=new kimbits(); 
      BufferedReader bf=new BufferedReader(new FileReader("./txt/kimbits.in"));
      PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/kimbits.out")));
      String line=bf.readLine();
      String[] nums=line.split(" ");
      int N=Integer.parseInt(nums[0]);
      int L=Integer.parseInt(nums[1]);
      int I=Integer.parseInt(nums[2]);
      String res="";
      int index=0;
      int begin=1;
      int b=0;
      while(begin<I){
    	  begin*=2;
    	  b++;
      }
      I=I-begin/2;
      index=begin/2-1;
      
      while(I>0){
    	  String binaryStr = java.lang.Integer.toBinaryString(index);
       if(Object.Count_1(binaryStr,L)){
    		  I--;
    		  if(I==0){
    			  res=binaryStr;
    		  }
    	  }
    	  index++;
      }
      while(res.length()<N)
    	  res='0'+res;
      System.out.println(res);
      out.println(res);
      out.close();
	}

}
