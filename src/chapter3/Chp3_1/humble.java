package chapter3.Chp3_1;
/*
ID: 15605181
LANG: JAVA
TASK: humble
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class humble {

	public void mySort(int[] list,int k){
		for(int i=k-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(list[j]>list[j+1]){
					int tmp=list[j];
					list[j]=list[j+1];
					list[j+1]=tmp;
				}
			}
		}
	}
	public int min(int m1,int m2){
		if(m1<m2)
			return m1;
		return m2;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		humble Object=new humble();
      BufferedReader bf=new BufferedReader(new FileReader("./txt/humble.in"));
      PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/humble.out")));
      String line=bf.readLine();
      String[] nums=line.split(" ");
      int[] last=new int[100000];
      int k=Integer.parseInt(nums[0]);
      int[] primes=new int[k];
      int n=Integer.parseInt(nums[1]);
      int[] hum=new int[n+1];
      line=bf.readLine();
      String[] nums1=line.split(" ");
      for(int i=0;i<k;i++){
    	  primes[i]=Integer.parseInt(nums1[i]);
      }
      hum[0]=1;
      int min=Integer.MAX_VALUE;
      Object.mySort(primes, k);
      for(int i=1;i<=n;i++){
        int ans=min;
    	  for(int j=0;j<k;j++){
    		  while(hum[last[j]]*primes[j]<=hum[i-1]) last[j]++;
    		  if(ans>hum[last[j]]*primes[j])
    			  ans=hum[last[j]]*primes[j];
    	  }
    	 hum[i]=ans;
      }
      
     // System.out.println(hum[n]);
      out.println(hum[n]);
      out.close();
      
	}

}
