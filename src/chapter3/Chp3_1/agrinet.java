package chapter3.Chp3_1;
/*
ID: 15605181
LANG: JAVA
TASK: agrinet
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class agrinet {

	int[][] dis=new int[100][100];
	int num=0;
	int[] flag=new int[100];
	public void ReadFile() throws NumberFormatException, IOException{
		BufferedReader bf=new BufferedReader(new FileReader("./txt/agrinet.in"));
		num=Integer.parseInt(bf.readLine());
		for(int i=0;i<num;i++){
			
		    String line=bf.readLine();
		    String[] nums=line.split(" ");
		  //  System.out.println(line);
		    int j=0;
		    for(;j<nums.length;j++){
		    	  dis[i][j]=Integer.parseInt(nums[j]);
		   // 	  dis[j][i]=Integer.parseInt(nums[j]);
		      }
		    while(j<num){
		    	line=bf.readLine();
		    	String[] nums1=line.split(" ");
		    	
		    //	System.out.println(line);
		    	 for(int h=0;h<nums1.length;h++)
		    	 {
		    		 dis[i][j]=Integer.parseInt(nums1[h]);
		    		 j++;
			   // 	 dis[j][i]=Integer.parseInt(nums1[j-h]); 
		    	 }
		    	 
		    }
		    
		}
	}
	
	
	
	public int firstEdge(){
		int res=Integer.MAX_VALUE;
		int corX=0;
		int corY=0;
		for(int i=0;i<num;i++){
			for(int j=0;j<i;j++){
				if(dis[i][j]!=0&&dis[i][j]<res)
				{
					res=dis[i][j];
					corX=i;
					corY=j;
				}
			}
		}
		dis[corX][corY]=0;
		dis[corY][corX]=0;
		flag[corX]=1;
		flag[corY]=1;
		return res;
	}
	
	public int nextEdge(){
		int res=Integer.MAX_VALUE;
		int corY=0;
		int corX=0;
		for(int i=0;i<100;i++){
			if(flag[i]==1){
				for(int j=0;j<100;j++){
					if(dis[i][j]!=0&&(dis[i][j]<res)&&(flag[j]==0))
					{
						res=dis[i][j];
						corX=i;
						corY=j;
					}
				}
			}
		}
		dis[corX][corY]=0;
		dis[corY][corX]=0;
		flag[corX]=1;
		flag[corY]=1;
		return res;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
      agrinet Object=new agrinet();
      PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/agrinet.out")));
      int res=0;
		int total=0;
		total=1;
		Object.ReadFile();
		res+=Object.firstEdge();
		while(total!=(Object.num-1)){
			res+=Object.nextEdge();
			total++;
		}
	//	System.out.println(res);
		out.println(res);
		out.close();
	}

}
