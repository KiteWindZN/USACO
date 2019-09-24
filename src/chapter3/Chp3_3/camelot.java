/*
ID: 15605181
LANG: JAVA
TASK: camelot
*/
package chapter3.Chp3_3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class camelot {

	int MAXN=26,MAXM=40;
	int INF=20000;
	int[] DX={-2,-2,-1,-1,+1,+1,+2,+2};
	int[] DY={-1,+1,-2,+2,-2,+2,-1,+1};
	class Node{
		int x;
		int y;
		boolean k;
		Node(int px,int py,boolean pk){
			x=px;
			y=py;
			k=pk;
		}
	}
	
	int N=0;
	int M=0;
	int[][][] dis=new int[MAXN][MAXM][2];
	int[][] kdis=new int[MAXN][MAXM];
	int[][] cost=new int[MAXN][MAXM];
	int[][] kcost=new int[MAXN][MAXM];
	
	boolean[][][] inq=new boolean[MAXN][MAXM][2];
	
	void bfs(int px,int py){
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				dis[i][j][0]=INF;
				dis[i][j][1]=INF;
			}
		}
			List<Node> list=new ArrayList<Node>();
			list.add(new Node(px,py,false));
			dis[px][py][0]=0;
		while(list.size()>0){
			Node u=new Node(list.get(0).x,list.get(0).y,list.get(0).k);
			list.remove(0);
			int tmp1=0;
			if(u.k==true)
				tmp1=1;
			inq[u.x][u.y][tmp1]=false;
			int udis=dis[u.x][u.y][tmp1];
			for(int i=0;i<8;i++){// only knight
				Node v=new Node(u.x+DX[i],u.y+DY[i],u.k);
				if(v.x<0||v.y>=N||v.y<0||v.y>=M) continue;
				if(dis[v.x][v.y][tmp1]>udis+1){
					dis[v.x][v.y][tmp1]=udis+1;
					
					if(!inq[v.x][v.y][tmp1]){
						list.add(v);
						inq[v.x][v.y][1]=true;
					}
				}
				if(!u.k&&dis[u.x][u.y][1]>dis[v.x][v.y][tmp1]+kdis[u.x][u.y]){// with the king
					dis[u.x][u.y][1]=udis+kdis[u.x][u.y];
					//System.out.println(1);
					if(!inq[u.x][u.y][1]){
						list.add(new Node(u.x,u.y,true));
						inq[u.x][u.y][1]=true;
					}
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		camelot Object=new camelot();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/camelot.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/camelot.out")));
		int px=0,py=0;
		String line=bf.readLine();
		String[] num=line.split(" ");
		Object.M=Integer.parseInt(num[0]);
		Object.N=Integer.parseInt(num[1]);
		line=bf.readLine();
		num=line.split(" ");
		px=num[0].charAt(0)-'A';
		py=Integer.parseInt(num[1])-1;// the king
		for(int i=0;i<Object.N;i++){
			for(int j=0;j<Object.M;j++){
				Object.kcost[i][j]=Object.kdis[i][j]=Math.max(Math.abs(px-i), Math.abs(py-j));
			}
		}
		
		line=bf.readLine();
		while(line!=null){
			String[] num1=line.split(" ");
			for(int i=0;i<num1.length;i++){
				px=num1[i].charAt(0)-'A';
				py=Integer.parseInt(num1[i+1])-1;
				i++;
				Object.bfs(px,py);
				for(int j=0;j<Object.N;j++){
					for(int h=0;h<Object.M;h++){
						Object.cost[j][h]+=Object.dis[j][h][0];//only knight
						Object.kcost[j][h]=Math.min(Object.kcost[j][h], Object.dis[j][h][1]-Object.dis[j][h][0]);//minimise the cost of the king
					}
				}
			}
			line=bf.readLine();
		}
		
		int ans=Object.INF;
		for(int i=0;i<Object.N;i++){
			for(int j=0;j<Object.M;j++){
				ans=Math.min(ans, Object.cost[i][j]+Object.kcost[i][j]);
			}
		}
		System.out.println(ans);
		out.println(ans);
		out.close();
	}

}
