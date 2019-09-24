/*
ID: 15605181
LANG: JAVA
TASK: pprime
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


public class pprime {

	public boolean IsPalind(int num){
		if(num<10)
			return true;
		String tmpS=""+num;
		int head=0;
		int tail=tmpS.length()-1;
		while(head<tail){
			if(tmpS.charAt(head)!=tmpS.charAt(tail))
				return false;
			head++;
			tail--;
			
		}
		return true;
	}
	
	public boolean IsPrime(int num){
		double q=Math.sqrt(num);
		for(int i=2;i<=q;i++){
			if(num%i==0)
				return false;
		}
		return true;
	}
	public void myOrder(List<Integer> list){
		for(int i=list.size()-1;i>0;i++){
			for(int j=0;j<i;j++){
				if(list.get(j)<list.get(j+1)){
					int tmp=list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1,tmp);
				}
			}
		}
	}
	
	public void IsOk(int[] res){
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<=9;i++){//1,2
			int tmp1=i;
			int tmp2=10*i+i;
			res[tmp1]=1;
			res[tmp2]=1;
			list.add(tmp1);
			list.add(tmp2);
		}
		
		for(int i=0;i<=9;i++){//3,4
			for(int j=0;j<=9;j++){
				int tmp1=i*100+j*10+i;
				int tmp2=i*1000+j*100+j*10+i;
				res[tmp1]=1;
				res[tmp2]=1;
				list.add(tmp1);
				list.add(tmp2);
			}
		}
		for(int i=0;i<=9;i++){//5,6
			for(int j=0;j<=9;j++){
				for(int z=0;z<9;z++){
				   int tmp1=i*10000+j*1000+z*100+j*10+i;
				   int tmp2=i*100000+j*10000+z*1000+z*100+j*10+i;
				   res[tmp1]=1;
				   res[tmp2]=1;
				   list.add(tmp1);
					list.add(tmp2);
				}
			}
		}
		for(int i=0;i<=9;i++){//7,8
			for(int j=0;j<=9;j++){
				for(int z=0;z<9;z++){
					for(int h=0;h<9;h++){
				      int tmp1=i*1000000+j*100000+z*10000+h*1000+z*100+j*10+i;
				      int tmp2=i*10000000+j*1000000+z*100000+h*10000+h*1000+z*100+j*10+i;
				      res[tmp1]=1;
				      res[tmp2]=1;
				      list.add(tmp1);
						list.add(tmp2);
					}
				}
			}
		}
		for(int i=0;i<=9;i++){//9,10
			for(int j=0;j<=9;j++){
				for(int z=0;z<9;z++){
					for(int h=0;h<9;h++){
						for(int g=0;g<9;g++){
				        int tmp1=i*100000000+j*10000000+z*1000000+h*100000+g*10000+h*1000+z*100+j*10+i;
				        int tmp2=i*1000000000+j*100000000+z*10000000+h*1000000+g*100000+g*10000+h*1000+z*100+j*10+i;
				        res[tmp1]=1;
				        res[tmp2]=1;
				        list.add(tmp1);
						  list.add(tmp2);
						}
					}
				}
			}
		}
	}
	public void myPrint(List<Integer> list) throws IOException{
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/pprime.out")));
		for(int i=0;i<list.size();i++){
			//System.out.println(list.get(i));
			out.println(list.get(i));
		}
		out.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		pprime Object=new pprime();
       BufferedReader bf=new BufferedReader(new FileReader("./txt/pprime.in"));
       
       String line=bf.readLine();
       String[] nums=line.split(" ");
       List<Integer> list=new ArrayList<Integer>();
       int start=Integer.parseInt(nums[0]);
       int end=Integer.parseInt(nums[1]);
         if(start%2==0)
        	 start+=1;
       for(int i=start;i<=end; ){
    	   if(Object.IsPalind(i)&&Object.IsPrime(i)){
    		   list.add(i);
    		   }
    	   i=i+2;
       }
       Object.myPrint(list);
	}

}
