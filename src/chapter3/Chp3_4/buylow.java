/*
ID: 15605181
LANG: JAVA
TASK: buylow
*/
package chapter3.Chp3_4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class buylow {

	public void solve(int[] arr,int[] dp){
	     int len=arr.length;
	     for(int i=0;i<len;i++){
	    	 int flag=0;
	    	 for(int j=0;j<i;j++){
	    		 if(arr[i]<arr[j]){
	    			 dp[i]=Math.max(dp[i], dp[j]+1);
	    			 flag=1;
	    		 }
	    	 }
	    	 if(flag==0){
	    		 dp[i]=1;
	    	 }
	     }
	}
	
	public void findCount(int[] arr,int[] dp,int[] count){
		int len=arr.length;
      for(int i=0;i<len;i++){
			for(int j=0;j<i;j++){
				if((arr[i]==arr[j])&&(dp[i]==dp[j])){
					dp[i]=0;
			//		arr[i]=0;
				}
			}
		}
	
	
		for(int i=0;i<len;i++){
			if(dp[i]==1){
				count[i]=1;
			}else{ 
				for(int j=0;j<i;j++){
				   if(dp[j]==(dp[i]-1)&&(arr[j]>arr[i])){
					   count[i]+=count[j];
				    }
			    }
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		buylow Object=new buylow();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/buylow.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/buylow.out")));
		String line=bf.readLine();
		int total=Integer.parseInt(line);
		int[] Nums=new int[total];
		int[] dp=new int[total];
		int[] count=new int[total];
		line=bf.readLine();
		int index=0;
		while(line!=null){
			String[] nums=line.split(" ");
			for(int i=0;i<nums.length;i++){
				Nums[index++]=Integer.parseInt(nums[i]);
			}
			line=bf.readLine();
		}
		Object.solve(Nums, dp);
		Object.findCount(Nums, dp, count);
		int max=0;
		for(int i=0;i<Nums.length;i++){
			if(max<dp[i]){
				max=dp[i];
			}
		}
		int counttotal=0;
		//max=49;
		for(int i=0;i<count.length;i++){
			if(dp[i]==max){
			   counttotal+=count[i];
			//   System.out.println(i+" "+dp[i]+" "+Nums[i]+" "+count[i]);
			}
		}
		System.out.println(max+" "+counttotal);
		out.println(max+" "+counttotal);
		out.close();
	}

}
