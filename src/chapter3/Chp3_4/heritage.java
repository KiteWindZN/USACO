/*
ID: 15605181
LANG: JAVA
TASK: heritage
*/
package chapter3.Chp3_4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class heritage {

	char[] post=new char[2000];
	int myIndex=0;
	public void Init(String line){
		myIndex=line.length();
	}
	public void solve(String lineIn,String linePre){
		if(lineIn.length()<=0||linePre.length()<=0)
			return;
		
		char ch=linePre.charAt(0);
		int index=0;
		for(int i=0;i<lineIn.length();i++){
			if(lineIn.charAt(i)==ch){
				post[--myIndex]=ch;
				index=i;
				String lineP1=linePre.substring(1, index+1);
				String lineP2=linePre.substring(index+1, linePre.length());
				String lineIn1=lineIn.substring(0, index);
				String lineIn2=lineIn.substring(index+1, lineIn.length());
				solve(lineIn2,lineP2);
				solve(lineIn1,lineP1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		heritage Object=new heritage();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/heritage.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/heritage.out")));
		String line=bf.readLine();
		String line1=bf.readLine();
		Object.Init(line1);
		//int myindex=line.length();
		Object.solve(line,line1);
		for(int i=0;i<line.length();i++){
			System.out.print(Object.post[i]);
			out.print(Object.post[i]);
		}
		System.out.println();
		out.println();
		out.close();
	}

}
