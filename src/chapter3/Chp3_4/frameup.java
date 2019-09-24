/*
ID: 15605181
LANG: JAVA
TASK: frameup
*/
package chapter3.Chp3_4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class frameup {

	int H=0;
	int W=0;
	int n=0;
	int MAXN=50;
	int[] Hash=new int[MAXN];
	int[] ind=new int[MAXN];
	int[] visited=new int[MAXN];
	int[] ans=new int[MAXN];
	
	public void myRead(int[][] cor,char[][] CharSet) throws IOException{
		BufferedReader bf=new BufferedReader(new FileReader("./txt/frameup.in"));
		String line=bf.readLine();
		String[] nums=line.split(" ");
		H=Integer.parseInt(nums[0]);
		W=Integer.parseInt(nums[1]);
		line=bf.readLine();
		int index=0;
	
		while(line!=null){
			for(int i=0;i<line.length();i++){
				CharSet[index][i]=line.charAt(i);
				if(line.charAt(i)!='.'){
					int tmp=line.charAt(i)-'A';
					if(Hash[tmp]==0) {
						Hash[tmp]=1;
						n++;
					}
					cor[tmp][0]=Math.min(cor[tmp][0], index);
					cor[tmp][1]=Math.min(cor[tmp][1], i);
					cor[tmp][2]=Math.max(cor[tmp][2], index);
					cor[tmp][3]=Math.max(cor[tmp][3], i);
				}
			}
			index++;
			line=bf.readLine();
		}
	}
	
	public void buildGraph(int[][] cor,char[][]CharSet,int[][] matrix){
		for(int i=0;i<26;i++){
			int left_x=cor[i][0];
			int left_y=cor[i][1];
			int right_x=cor[i][2];
			int right_y=cor[i][3];
			char ch=(char)(i+'A');
			for(int j=left_x;j<=right_x;j++){
				char tmpChar=CharSet[j][left_y];
				int tmp1=tmpChar-'A';
				if(CharSet[j][left_y]!=ch&&matrix[i][tmp1]==0){
					matrix[i][tmp1]=1;
					ind[tmp1]++;
				}
				char tmpChar1=CharSet[j][right_y];
				int tmp2=tmpChar1-'A';
				if(CharSet[j][right_y]!=ch&&matrix[i][tmp2]==0){
					matrix[i][tmp2]=1;
					ind[tmp2]++;
				}
			}
			for(int j=left_y;j<=right_y;j++){
				char tmpChar=CharSet[left_x][j];
				int tmp1=tmpChar-'A';
				if(CharSet[left_x][j]!=ch&&matrix[i][tmp1]==0){
					matrix[i][tmp1]=1;
					ind[tmp1]++;
				}
				char tmpChar1=CharSet[right_x][j];
				int tmp2=tmpChar1-'A';
				if(CharSet[right_x][j]!=ch&&matrix[i][tmp2]==0){
					
					matrix[i][tmp2]=1;
					ind[tmp2]++;
				}
			}
		}
	}
	
	public String Solve(int[][] matrix){
		String str="";
		while(str.length()<5){
			for(int i=0;i<5;i++){
				int flag=0;
				for(int j=0;j<5;j++){
					if(matrix[j][i]==0){
						flag++;
					}
				}
				if(flag==5){
					str=(char)(i+'A')+str;
					for(int j=0;j<5;j++){
						matrix[j][i]=2;
					}
					for(int j=0;j<5;j++){
						matrix[i][j]=0;
					}
					break;
				}
			}
		}
		return str;
	}
	public void Init(int[][] cor){
		for(int i=0;i<MAXN;i++){
			cor[i][0]=50;
			cor[i][1]=50;
			cor[i][2]=-1;
			cor[i][3]=-1;
		}
	}
	
	void dfs1(int[][] matrix,List<String> list,int x,int d)
	{
	 
	     ans[d]=x;
	     visited[x]=1;
	     if(d>=n-1){
	    	 String str="";
	             for(int i=0;i<n;i++)
	                   str+=(char)(ans[i]+'A'-1);
	            list.add(str);
	             return;
	             }
	     if(ind[x]==0){
	                   for(int i=0;i<26;i++)
	                           if(matrix[x][i]==1)ind[i]--;  
	 
	                   for(int i=0;i<26;i++)
	                           if(ind[i]==0&&visited[i]==0&&Hash[i]==1){
	                                         dfs(matrix,list,i,d+1);
	                                         visited[i]=0;
	                                         }
	 
	                   for(int i=0;i<26;i++)
	                           if(matrix[x][i]==1)ind[i]++;  
	                   }
	 
	 
	}
	
	public void dfs(int[][] matrix,List<String> list,int x,int d){
		ans[d]=x;
		visited[x]=1;
		if(d>=n-1){
			String str="";
			for(int i=0;i<n;i++){
				str+=(char)(ans[i]+'A');
			}
			list.add(str);
			return;
		}
		if(ind[x]==0){
			for(int i=0;i<26;i++){
				if(matrix[x][i]==1) ind[i]--;
			}
			for(int i=0;i<26;i++){
				if(ind[i]==0&&visited[i]==0&&Hash[i]==1){
					dfs(matrix,list,i,d+1);
					visited[i]=0;
				}
			}
			for(int i=0;i<26;i++){
				if(matrix[x][i]==1) ind[i]++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/frameup.out")));
		frameup Object=new frameup();
		int[][] cor=new int[Object.MAXN][4];
		char[][] CharSet=new char[30][30];
		int[][] matrix=new int[26][26];
		Object.Init(cor);
		Object.myRead(cor, CharSet);
		
		Object.buildGraph(cor, CharSet, matrix);
		List<String> list=new ArrayList<String>();
		for(int i=0;i<26;i++){
			Arrays.fill(Object.visited, 0);
			if(Object.Hash[i]==1)
				Object.dfs(matrix, list, i, 0);
		}
		for(int i=0;i<list.size();i++){
		   String str=list.get(i);
		   out.println(str);
		   System.out.println(str);
		}
		out.close();
		
	}

}
