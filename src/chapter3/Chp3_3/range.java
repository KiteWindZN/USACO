/*
ID: 15605181
LANG: JAVA
TASK: range
*/
package chapter3.Chp3_3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class range {

	public boolean IsValid(int x,int y,int num,int width,int[][] area){
		if((width+x)>num||(width+y)>num){
			return false;
		}
		for(int i=0;i<width;i++){
			for(int j=0;j<width;j++){
				if(area[i+x][j+y]==0){
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
      range Object=new range();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/range.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/range.out")));
		int Num=Integer.parseInt(bf.readLine());
		int[][] area=new int[Num+1][Num+1];
		int[][] dp=new int[Num+1][Num+1];
		int[] res=new int[Num+1];
		for(int i=1;i<=Num;i++){
			String line=bf.readLine();
			for(int j=1;j<=Num;j++){
				area[i][j]=line.charAt(j-1)-'0';
			}
		}
		
		for(int i=1;i<=Num;i++){
			for(int j=1;j<=Num;j++){
				if(area[i][j]==0)
					dp[i][j]=0;
				else{
					dp[i][j]=Math.min(dp[i][j-1], Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
				}
				if(dp[i][j]>1)
					res[dp[i][j]]++;
			}
		}
		
		for(int i=2;i<=Num;i++){
			int re=0;
			for(int j=i;j<=Num;j++){
				re+=res[j];
			}
			if(re!=0){
			  System.out.println(i+" "+re);
			  out.println(i+" "+re);
			}
		}
		out.close();
	}

}
