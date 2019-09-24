/*
ID: 15605181
LANG: JAVA
TASK: job
*/
package chapter3.Chp3_4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class job {

	public void mySort(int[] arr){
		for(int i=arr.length-1;i>=0;i-- ){
			for(int j=0;j<i;j++){
				if(arr[j]>arr[j+1]){
					int tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      job Object=new job();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/job.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/job.out")));
		
		String line=bf.readLine();
		String[] nums=line.split(" ");
		int totalJob=Integer.parseInt(nums[0]);
		int[] time1=new int[totalJob];
		int[] time2=new int[totalJob];
		int numA=Integer.parseInt(nums[1]);
		int[] timeA=new int[numA];
		int[] costA=new int[numA];
		int numB=Integer.parseInt(nums[2]);
		int[] timeB=new int[numB];
		int[] costB=new int[numB];
		
		int resA=0;
		int resB=0;
		line=bf.readLine();
		int index=0;
		while(line!=null){
			String[] nums1=line.split(" ");
			for(int i=0;i<nums1.length;i++){
				if(index<numA){
					costA[index++]=Integer.parseInt(nums1[i]);
				}
				else{
					costB[index-numA]=Integer.parseInt(nums1[i]);
					index++;
				}
			}
			line=bf.readLine();
		}
		
		for(int i=0;i<totalJob;i++){
			int min=Integer.MAX_VALUE;
			int selected=0;
			for(int j=0;j<numA;j++){
				if(min>(timeA[j]+costA[j]))
				{
					min=timeA[j]+costA[j];
					selected=j;
				}
			}
			timeA[selected]+=costA[selected];
			resA=Math.max(resA, timeA[selected]);
			time1[i]=timeA[selected];
		}
	  
		for(int i=0;i<totalJob;i++){
			int min=Integer.MAX_VALUE;
			int selected=0;
			for(int j=0;j<numB;j++){
				if(min>timeB[j]+costB[j]) {
					min=timeB[j]+costB[j];
					selected=j;
				}
			}
			timeB[selected]+=costB[selected];
			time2[i]=timeB[selected];
		}
		 Object.mySort(time2);
		 Object.mySort(time1);
		 for(int i=0;i<totalJob;i++){
			 if(resB<(time1[i]+time2[totalJob-1-i]))
				 resB=time1[i]+time2[totalJob-1-i];
		 }
		 System.out.println(resA+" "+resB);
		 out.println(resA+" "+resB);
		 out.close();
	}

}
