/*
ID: 15605181
LANG: JAVA
TASK: milk3
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


public class milk3 {

	public List<Integer> myPour(int first,int next,List<Integer> counts,List<Integer> contain ){
		if(counts.get(first)==0)
			return null;
		int tmpAll=contain.get(first)+contain.get(next);
		if(tmpAll<=counts.get(next))
		{
			contain.set(next, tmpAll);
			contain.set(first, 0);
		}
		else{
			contain.set(next, counts.get(next));
			contain.set(first, tmpAll-counts.get(next));
		}
		return contain;
	}
	
	public boolean myExist(List<List<Integer>> history,List<Integer> list){
		for(int i=0;i<history.size();i++){
			if(myEqual(list,history.get(i)))
				return true;
		}
		return false;
	} 
	
	public boolean myEqual(List<Integer> list1,List<Integer> list2){
		if(list1.size()!=list2.size())
			return false;
		for(int i=0;i<list1.size();i++){
			if(list1.get(i)!=list2.get(i))
				return false;
		}
		return true;
	}
	
	public boolean IsAdd(List<Integer> list,int num){
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i)==num)
				return false;
		}
		return true;
	}
	public void myOrder(List<Integer> list){
		for(int i=list.size()-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(list.get(j)>list.get(j+1)){
					int tmp=list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
			}
		}
	}
	
	public void myPrintln(List<Integer> list) throws IOException{
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/milk3.out")));
		int i=0;
		for(;i<list.size()-1;i++){
		//	System.out.print(list.get(i)+" ");
			out.print(list.get(i)+" ");
		}
		//System.out.println(list.get(i));
		out.println(list.get(i));
		out.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        milk3 Object=new milk3();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/milk3.in"));
		
		String line=bf.readLine();
		String[] nums=line.split(" ");
		List<Integer> res=new ArrayList<Integer>();
		List<Integer> counts=new ArrayList<Integer>();
		List<Integer> contain=new ArrayList<Integer>();
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		List<List<Integer>> history=new ArrayList<List<Integer>>();
		for(int i=0;i<nums.length;i++){
			counts.add(Integer.parseInt(nums[i]));
		}
		contain.add(0);
		contain.add(0);
		contain.add(counts.get(2));
		list.add(contain);
		history.add(contain);
		while(list.size()!=0){
			List<Integer> tmp=list.get(0);
			if(Object.IsAdd(res, tmp.get(2))&&(tmp.get(0)==0))
			   res.add(tmp.get(2));
			list.remove(0);
			contain=tmp;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					if(j!=i)
					{
					List<Integer> tmplist=new ArrayList<Integer>();
					tmplist.add(contain.get(0));
					tmplist.add(contain.get(1));
					tmplist.add(contain.get(2));
						List<Integer> GeneCotain=Object.myPour(i, j, counts, tmplist);
						if(!Object.myExist(history, GeneCotain)){
							history.add(GeneCotain);
							list.add(GeneCotain);
						}
					}
				}
			}
		}
		Object.myOrder(res);
		Object.myPrintln(res);
	}

}
