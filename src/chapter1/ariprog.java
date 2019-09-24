/*
ID: 15605181
LANG: JAVA
TASK: ariprog
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


public class ariprog {

	public int[] exist=new int[125001];
	public boolean IsValid(int a,int b,int num){
		for(int i=0;i<num;i++){
			if(exist[a]==0)
				return false;
			a+=b;
		}
		return true;
	}
	public void mySort(List<Integer> listA,List<Integer> listB){
		for(int i=listB.size()-1;i>=1;i--){
			for(int j=0;j<i;j++){
				if(listB.get(j)>listB.get(j+1)){
					int tmp=listB.get(j);
					listB.set(j, listB.get(j+1));
					listB.set(j+1, tmp);
					tmp=listA.get(j);
					listA.set(j, listA.get(j+1));
					listA.set(j+1, tmp);
				}
				else if(listB.get(j)==listB.get(j+1)){
					if(listA.get(j)>listA.get(j+1)){
						int tmp=listB.get(j);
						listB.set(j, listB.get(j+1));
						listB.set(j+1, tmp);
						tmp=listA.get(j);
						listA.set(j, listA.get(j+1));
						listA.set(j+1, tmp);
					}
				}
			}
		}
	}
	
	public void InitExist(int PQ,int[] exist){
		for(int i=0;i<=PQ;i++){
			for(int j=0;j<=PQ;j++)
				exist[i*i+j*j]=1;
		}
	}
	public void myPrint(List<Integer> listA,List<Integer> listB) throws IOException{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./txt/ariprog.out")));
		for(int i=0;i<listA.size();i++){
			System.out.println(listA.get(i)+" "+listB.get(i));
			out.println(listA.get(i)+" "+listB.get(i));
		}
		if(listA.size()==0){
			out.println("NONE");
			//System.out.println("NONE");
		}
		out.close();
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		  ariprog Object=new ariprog();
		  List<Integer> listA=new ArrayList<Integer>();
		  List<Integer> listB=new ArrayList<Integer>();
        BufferedReader bf = new BufferedReader(new FileReader("./txt/ariprog.in"));
        
        int num=Integer.parseInt(bf.readLine());
        int PQ=Integer.parseInt(bf.readLine());
        int B=0;
        if(num!=1)
         B=PQ*PQ*2/(num-1);
        else B=2*PQ*PQ;
        int A=PQ*PQ-num+1;
        int Max=2*PQ*PQ;
        int flag=0;
         Object.InitExist(PQ, Object.exist);
        for(int a=0;a<=A;a++){
        	for(int b=1;b<=B;b++){
        			//I=I-Max;
        	  if(Object.IsValid(a,b,num))
        	  {
        		  listA.add(a);
              listB.add(b);
        	  }
        		
        		
        		
        	}
        }
        
        Object.mySort(listA, listB);
        Object.myPrint(listA, listB);
	}

}
