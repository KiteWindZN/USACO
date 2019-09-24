/*
ID: 15605181
LANG: JAVA
TASK: rockers
*/
package chapter3.Chp3_4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class rockers {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new FileReader("./txt/rockers.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/rockers.out")));
		String line=bf.readLine();
		String[] nums=line.split(" ");
		int N=Integer.parseInt(nums[0]);
		int T=Integer.parseInt(nums[1]);
		int M=Integer.parseInt(nums[2]);
		line=bf.readLine();
		String[] nums1=line.split(" ");
		int[] time=new int[N+1];
		for(int i=0;i<N;i++){
			time[i+1]=Integer.parseInt(nums1[i]);
		}
		
		int[][][] f=new int[21][21][21];
		for(int i=1;i<=N;i++){
			for(int j=1;j<=M;j++){
				for(int k=0;k<=T;k++){
					f[i][j][k]=f[i-1][j][k];
					if(T>=time[i]){
						if(k>=time[i]){
							f[i][j][k]=Math.max(f[i][j][k], f[i-1][j][k-time[i]]+1);
						}
						if(j>1){
							f[i][j][k]=Math.max(f[i][j][k], f[i-1][j-1][T-time[i]]+1);
						}
					}
				}
			}
		}
		System.out.println(f[N][M][T]);
		out.println(f[N][M][T]);
		out.close();
		
	}

}
