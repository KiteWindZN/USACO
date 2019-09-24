/*
ID: 15605181
LANG: JAVA
TASK: wormhole
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


public class wormhole {

	
	public void find_Next_Right(int[] next_right,List<Integer> corX,List<Integer> corY){
		for(int i=1;i<corX.size();i++){
			for(int j=1;j<corX.size();j++){
				//System.out.println(corY.get(i));
				//System.out.println(corY.get(i));
				if((corY.get(i)-corY.get(j))==0){
					
					if((corX.get(i)<corX.get(j)&&(next_right[i]==0||corX.get(next_right[i])>corX.get(j))))
						next_right[i]=j;
				}
			}
			
		}
	}
	
	public boolean IsCycle(int[] next_right,int[] partner){
		int pos=0;
		for(int i=0;i<next_right.length;i++){
			pos=i;
			for(int j=0;j<next_right.length;j++){
				pos=next_right[partner[pos]];
				
			}
			if(pos!=0) return true;
		}
		return false;
	}
	
	public int solve(int[] next_right,int[] partner){
		int i,total=0;
		for(i=1;i<partner.length;i++){
			if(partner[i]==0) break;
		}
		
		if(i==partner.length){
			if(IsCycle(next_right,partner))
				return 1;
			else return 0;
		}
			
		for(int j=i+1;j<partner.length;j++){
			if(partner[j]==0){
				partner[i]=j;
				partner[j]=i;
				total+=solve(next_right,partner);
				partner[i]=0;
				partner[j]=0;
			}
		}
		return total;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
      wormhole Object=new wormhole();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/wormhole.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/wormhole.out")));
		List<Integer> X=new ArrayList<Integer>();
		List<Integer> Y=new ArrayList<Integer>();
		X.add(0);
		Y.add(0);
		int Num=Integer.parseInt(bf.readLine());
		int[] next_right=new int [Num+1];
		int[] partner=new int [Num+1];
		
		String line=bf.readLine();
		int res=0;
		while(line!=null){
			String[] nums=line.split(" ");
			X.add(Integer.parseInt(nums[0]));
			Y.add(Integer.parseInt(nums[1]));
			line=bf.readLine();
		}
		
		Object.find_Next_Right(next_right, X, Y);
		res=Object.solve(next_right, partner);
		//System.out.println(res);
		out.println(res);
		out.close();
	}

}
