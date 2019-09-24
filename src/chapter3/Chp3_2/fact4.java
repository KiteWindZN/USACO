/*
ID: 15605181
LANG: JAVA
TASK: fact4
*/
package chapter3.Chp3_2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class fact4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf =new BufferedReader(new FileReader("./txt/fact4.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/fact4.out")));
		int num=Integer.parseInt(bf.readLine());
		int res=1;
		while(num>0){
			res*=num;
			while(res%10==0)
				res=res/10;
			res=res%1000;
			num--;
		}
		while(res%10==0)
			res=res/10;
		res=res%10;
		//System.out.println(res);
		out.println(res);
		out.close();
	}

}
