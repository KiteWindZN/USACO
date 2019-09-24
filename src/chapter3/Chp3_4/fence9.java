/*
ID: 15605181
LANG: JAVA
TASK: fence9
*/
package chapter3.Chp3_4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class fence9 {

	public static int gcd(int x,int y){
		if(x>y) {
			int tmp=x;
			x=y;
			y=tmp;
	    }
		if(x==0)
			return y;
		return gcd(y%x,x);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        fence9 Object=new fence9();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/fence9.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/fence9.out")));
		String line=bf.readLine();
		String[] nums=line.split(" ");
		int n=Integer.parseInt(nums[0]);
		int m=Integer.parseInt(nums[1]);
		int p=Integer.parseInt(nums[2]);
		int s=m*p/2;
		int b=Object.gcd(n, m);
		if(n!=p) b+=Object.gcd(Math.abs(n-p), m);
		else b+=m;
		b+=p;
		fence9.gcd(10, 15);
		System.out.println(s+1-b/2);
		out.println(s+1-b/2);
		out.close();
	}

}
