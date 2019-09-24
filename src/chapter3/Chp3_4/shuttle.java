/*
ID: 15605181
LANG: JAVA
TASK: shuttle
*/
package chapter3.Chp3_4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class shuttle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		shuttle Object=new shuttle();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/shuttle.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/shuttle.out")));
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		int N=Integer.parseInt(bf.readLine());
		for(int i=1;i<=N+1;i++){
			List<Integer> tmpList=new ArrayList<Integer>();
			if(i%2==1){
				int tmp=N+i;
				tmpList.add(tmp);
			for(int j=1;j<i;j++){
				tmp=tmp-2;
				tmpList.add(tmp);
			}
			list.add(tmpList);
			}else{
				int tmp=N+2-i;
				tmpList.add(tmp);
				for(int j=1;j<i;j++){
					tmp+=2;
					tmpList.add(tmp);
				}
				list.add(tmpList);
			}
		}
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		for(int i=0;i<list.size();i++){
			List<Integer> tmpL=list.get(i);
			res.add(tmpL);
		}
		for(int i=list.size()-2;i>=0;i--){
			List<Integer> tmpL=list.get(i);
			res.add(tmpL);
		}
		int count=0;
		for(int i=1;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				if(count%20==0){
					System.out.print(res.get(i).get(j));
					out.print(res.get(i).get(j));
					count++;
				}else{
				System.out.print(" "+res.get(i).get(j));
				out.print(" "+res.get(i).get(j));
				count++;
				}
				if(count%20==0){
					System.out.println();
					out.println();
				}
			}
		}
		if(count%20!=0){
			System.out.println();
			out.println();
		}
		out.close();
	}

}
