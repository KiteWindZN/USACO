/*
ID: 15605181
LANG: JAVA
TASK: game1
*/
package chapter3.Chp3_3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class game1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new FileReader("./txt/game1.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/game1.out")));
		int num=Integer.parseInt(bf.readLine());
		int[] integers=new int[num];
		int[][] sum=new int[num][num];
		int[][] f=new int[num][num];
		int index=0;
		String line=bf.readLine();
		while(line!=null){
			String[] nums=line.split(" ");
			for(int i=0;i<nums.length;i++){
				integers[index++]=Integer.parseInt(nums[i]);
			}
			line=bf.readLine();
		}
		for(int i=0;i<num;i++){
			for(int j=i;j<num;j++){
				for(int k=i;k<=j;k++){
					sum[i][j]+=integers[k];
				}
			}
		}
		
		for(int i=num-1;i>=0;i--){
			for(int j=i;j<num;j++){
				if(i==j){
					f[i][j]=integers[i];
				}
				else{
					f[i][j]=Math.max(sum[i+1][j]-f[i+1][j]+integers[i], sum[i][j-1]-f[i][j-1]+integers[j]);
				}
			}
		}
		
		int player1=f[0][num-1];
		int player2=sum[0][num-1]-player1;
		System.out.println(player1+" "+player2);
		out.println(player1+" "+player2);
		out.close();
	}

}
