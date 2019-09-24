/*
ID: 15605181
LANG: JAVA
TASK: msquare
*/
package chapter3.Chp3_2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class msquare {

	int[][] Init = new int[2][4];
    int[] myP={1,2,1,2,2,1,0};
    
    public int[] test(){
    	int[] k={1,2,3,4,5,6,7,8};
    	int[][] g = { { 7, 6, 5, 4, 3, 2, 1, 0 }, { 3, 0, 1, 2, 5, 6, 7, 4 }, { 0, 6, 1, 3, 4, 2, 5, 7 } };
    	int[] res=new int[8];
    	for(int i=0;i<7;i++){
    		for(int j=0;j<8;j++){
    			int tmp=k[g[myP[i]][j]];
				res[j] = tmp;
    		}
    		for(int j=0;j<8;j++){
    			k[j]=res[j];
    		}
    	}
    	return res;
    }
    
	static class node {
		String ans;
		int[] a = new int[8];
	}

	public int getdata(node q) {
		int  m = 0, k = 1;
		for (int i=0; i < 8; i++) {
			m += k * q.a[i];
			k = (k * 17) % 387723;
		}
		return m;
	}

	public int getdata1(int[] a) {
		int  m = 0, k = 1;
		for (int i=0; i < 8; i++) {
			m += k * a[i];
			k = (k * 17) % 387723;
		}
		return m;
	}

	public boolean isEqual(int[] a ,int[] b){
		for(int i=0;i<8;i++){
			if(a[i]!=b[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		msquare Object = new msquare();
		BufferedReader bf = new BufferedReader(new FileReader("./txt/msquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./txt/msquare.out")));

		int t = 0, goal = 0;
		int[][] g = { { 7, 6, 5, 4, 3, 2, 1, 0 }, { 3, 0, 1, 2, 5, 6, 7, 4 }, { 0, 6, 1, 3, 4, 2, 5, 7 } };
		boolean[] used = new boolean[5000001];
		node h = new node();
		node k = new node();
		
		List<node> listNode = new ArrayList<node>();

		String line = bf.readLine();
		String[] nums = line.split(" ");
		int count = 0;
		for (int i = 0; i < 8; i++) {
		   h.a[i] = Integer.parseInt(nums[i]);
		}
		goal = Object.getdata(h);
		for (int i = 0; i < 8; i++) {
			h.a[i] = i + 1;
		}
		h.ans = "";
		t = Object.getdata(h);
		node N=new node();
		for(int i=0;i<8;i++)
			N.a[i]=h.a[i];
		N.ans=h.ans;
		listNode.add(N);
		used[t] = true;
		if (t==goal)
			k = h;
		else {
			while (listNode.size()>0) {
				
				node tmpN= listNode.get(0);
				for(int i=0;i<8;i++){
					h.a[i]=tmpN.a[i];
			
				}
				h.ans=tmpN.ans;
				listNode.remove(0);
				for (int i = 0; i < 3; i++) {
					k.ans = h.ans + (char) ('A' + i);
					
					for (int j = 0; j < 8; j++){
						int tmp=h.a[g[i][j]];
						k.a[j] = tmp;
					}
					t = Object.getdata(k);
					if (t==goal) 
						break;
					
				if (!used[t]){
					    node myN=new node();
					    for(int g1=0;g1<8;g1++){
						    myN.a[g1]=k.a[g1];
					     }
					   myN.ans=k.ans;
						listNode.add(myN);
					//	System.out.println(listNode.size());
						used[t] = true;
					}
					
				}
				if (t==goal)
					break;
			}
		}
		
		//int[] res=Object.test();
		
	//	int myt=Object.getdata1(res);
	//	if(goal==myt)
	//		System.out.println("OK");
		
		count = k.ans.length();
		//System.out.println(count);
		out.println(count);

		for (int i = 0; i < count; i++) {
		//	System.out.print(k.ans.charAt(i));
			out.print(k.ans.charAt(i));
			if (i % 60 == 59){
			//	System.out.println();
				out.println();
			}
		}
		if (count % 60 != 0) {
		//	System.out.println();
			out.println();
		}
		if(count==0){
			out.println();
		}
		out.close();
	}

}
