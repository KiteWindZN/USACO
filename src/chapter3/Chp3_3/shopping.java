/*
ID: 15605181
LANG: JAVA
TASK: shopping
*/
package chapter3.Chp3_3;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class shopping {

	int tt=0;
	int[] nn=new int[6];
	
	public int Ord(int x){
		for(int i=1;i<=tt;i++){
			if(x==nn[i])
				return i;
		}
		tt++;
		nn[tt]=x;
		return tt;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        shopping Object=new shopping();
		int[][][][][] dp=new int[6][6][6][6][6];
		int[] price=new int[150];
		int[][] c=new int[150][6];
		int[] t=new int[6];
		int[] p=new int[6];
		int s=0;
		Scanner bf=new Scanner(new File("./txt/shopping.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/shopping.out")));
		s=bf.nextInt();
		for(int i=1;i<=s;i++){
			int n=bf.nextInt();
			for(int j=1;j<=n;j++){
				c[i][Object.Ord(bf.nextInt())]=bf.nextInt();
			}
			price[i]=bf.nextInt();
		}
		int b=bf.nextInt();
		for(int i=1;i<=b;i++){
			int cc=bf.nextInt();
			t[Object.Ord(cc)]=bf.nextInt();
			p[Object.Ord(cc)]=bf.nextInt();
			s++;
			price[s]=p[Object.Ord(cc)];
			c[s][Object.Ord(cc)]=1;
		}
		
		for(int i1=0;i1<=t[1];i1++)
			for(int i2=0;i2<=t[2];i2++)
				for(int i3=0;i3<=t[3];i3++)
					for(int i4=0;i4<=t[4];i4++)
						for(int i5=0;i5<=t[5];i5++){
							int tmp=i1*p[1]+i2*p[2]+i3*p[3]+i4*p[4]+i5*p[5];
							dp[i1][i2][i3][i4][i5]=tmp;
							for(int i=1;i<=s;i++){
								int t1=Math.max(i1-c[i][1], 0);
								int t2=Math.max(i2-c[i][2], 0);
								int t3=Math.max(i3-c[i][3], 0);
								int t4=Math.max(i4-c[i][4], 0);
								int t5=Math.max(i5-c[i][5], 0);
								if(dp[t1][t2][t3][t4][t5]+price[i]<dp[i1][i2][i3][i4][i5]){
									dp[i1][i2][i3][i4][i5]=dp[t1][t2][t3][t4][t5]+price[i];
								}
							}	
						}
		System.out.println(dp[t[1]][t[2]][t[3]][t[4]][t[5]]);
		out.println(dp[t[1]][t[2]][t[3]][t[4]][t[5]]);
		out.close();
	}

}
