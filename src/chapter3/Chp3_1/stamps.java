package chapter3.Chp3_1;
/*
ID: 15605181
LANG: JAVA
TASK: stamps
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class stamps {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
         stamps Object=new stamps();
         BufferedReader bf=new BufferedReader(new FileReader("./txt/stamps.in"));
         PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/stamps.out")));
         String line=bf.readLine();
         String[] nums=line.split(" ");
         int k=Integer.parseInt(nums[0]);
         int n=Integer.parseInt(nums[1]);
         int[] Stamps=new int[n];
         int index=0;
         int Max=0;
         line=bf.readLine();
         while(line!=null){
        	 String[] nums1=line.split(" ");
        	 for(int i=0;i<nums1.length;i++){
        		 int tmp=Integer.parseInt(nums1[i]);
        		 Stamps[index++]=tmp;
        		 if(tmp>Max)
        			 Max=tmp;
        	 }
        	 line=bf.readLine();
         }
        	 int[] a=new int[Max*k+1];
        	 int[] count=new int[Max*k+1];
        	 for(int i=1;i<Max*k+1;i++)
        		 count[i]=Integer.MAX_VALUE;
        	 int i=0;
        	 for(i=1;i<=Max*k;i++){
        		 int flag=0;
        		 for(int j=0;j<n;j++){
        			 while((a[j]+Stamps[j])<i)
        				 a[j]++;
        			 if((a[j]+Stamps[j])==i){
        				 if((count[a[j]]+1)<count[i]&&(count[a[j]]+1)<=k){
        					 count[i]=count[a[j]]+1;
        					 flag=1;
        				 }
        			 }
        		 }
        		 if(flag==0)
        			 break;
        	 }
        	 
        	 //System.out.println(i-1);
        	 out.println(i-1);
        	 out.close();
        
         
	}

}
