/*
ID: 15605181
LANG: JAVA
TASK: numtri
*/
package chapter1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class numtri {

	
	
	public void Myprint(int res) throws IOException{
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/numtri.out")));
	//	System.out.println(res);
		out.println(res);
		out.close();
	}
	public void FindMax(int n,List<List<Integer>> list,List<Integer> res,int tmpres,int index){
		if(n==list.size()-1){
			//tmpres+=list.get(n).get(index);
			if(index<n){
			  int tmp=max(list.get(n).get(index),list.get(n).get(index+1));
			  tmpres+=tmp;
			  res.set(0, max(tmpres,res.get(0)));
			}
			
		}
		else{
			tmpres+=list.get(n).get(index);
			FindMax(n+1,list,res,tmpres,index);
			tmpres-=list.get(n).get(index);
			if(index<n)
			tmpres+=list.get(n).get(index+1);
//			if(tmpres==0)
//				return;
			FindMax(n+1,list,res,tmpres,index+1);
			
		}
		
	}
	
	
	public int max(int m1,int m2){
		if(m1>m2)
			return m1;
		return m2;
	}
	
	public int BestSolution(int[][] best,int n){
		//
		int res=0;
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<=i;j++){
				best[i][j]+=max(best[i-1][j-1],best[i-1][j]);
			}
		}
		for(int i=0;i<n;i++)
		{
			res=max(res,best[n][i]);
		}
		return res;
	}
	public int myRead(int[][] best) throws NumberFormatException, IOException{
		BufferedReader bf=new BufferedReader(new FileReader("./txt/numtri.in"));
		int num=Integer.parseInt(bf.readLine());
		String line=bf.readLine();
		int j=0;
		while(line!=null){
			String[] nums=line.split(" ");
			for(int i=0;i<nums.length;i++){
				int tmp=Integer.parseInt(nums[i]);
				best[j][i]=tmp;
			}
			j++;
			line=bf.readLine();
		}
		return num;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		numtri Object=new numtri();
		int[][] best=new int[1009][1009];
		//int num=0;
		int res=0;
		BufferedReader bf=new BufferedReader(new FileReader("numtri.in"));
		int num=Integer.parseInt(bf.readLine());
		String line=bf.readLine();
		int j=1;
		while(line!=null){
			String[] nums=line.split(" ");
			for(int i=0;i<nums.length;i++){
				int tmp=Integer.parseInt(nums[i]);
				best[j][i+1]=tmp;
			}
			j++;
			line=bf.readLine();
		}
		//num=Object.myRead(best);
		res=Object.BestSolution(best, num);
		Object.Myprint(res);
		
	}

}
