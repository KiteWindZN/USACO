/*
ID: 15605181
LANG: JAVA
TASK: spin
*/
package chapter3.Chp3_2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class spin {

	int[] v=new int[6];
	
	int[][] b=new int[6][360];

	public boolean Check(int h){
		int[] e=new int [360];
		for(int i=0;i<5;i++){
			for(int j=0;j<360;j++){
				if(b[i][j]==1){
					int tmp=(j+h*v[i])%360;
					e[tmp]++;
				}
			}
		}
		for(int i=0;i<360;i++){
			if(e[i]==5)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		spin Object=new spin();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/spin.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/spin.out")));
		String line=bf.readLine();
		int ans=-1;
		int index=0;
		while(line!=null){
			String[] nums=line.split(" ");
			Object.v[index]=Integer.parseInt(nums[0]);
			int num=Integer.parseInt(nums[1]);
		
			for(int i=2;i<nums.length-1;i++){
				int t1=Integer.parseInt(nums[i]);
				int t2=Integer.parseInt(nums[i+1]);
				i++;
				for(int j=t1;j<=t2+t1;j++)
				   Object.b[index][j%360]=1;	
			}
			line=bf.readLine();
			index++;
		}
		
		for(int  i=0;i<10000;i++){
			if(Object.Check(i)){
				ans=i;
				break;
			}
		}
		if(ans==-1)
		{
		//	System.out.println("NONE");
			out.println("none");
		}
		else {
			//System.out.println(ans);
			out.println(ans);
		}
		out.close();
	}

}
