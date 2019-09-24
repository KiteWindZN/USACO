/*
ID: 15605181
LANG: JAVA
TASK: camelot
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

public class camelot {

	class point
	{
	    public int x,y;
	    point(int x1,int y1){
	    	x=x1;
	    	y=y1;
	    }
	};
	 
	 int[] dx = {1,1,2,2,-1,-1,-2,-2};
	 int[] dy = {2,-2,1,-1,2,-2,1,-1};
	 int[] kx = {1,1,1,-1,-1,-1,0,0};
	 int[] ky = {-1,0,1,-1,0,1,-1,1};
	int n, m, best, tot, tot2;
	List<point> situ=new ArrayList<point>(), kingSitu=new ArrayList();
	int[][][][] dis=new int[31][31][31][31];
	int[][] sum=new int[31][31], disKing=new int[31][31];
	int[][] vis=new int[31][31];
	List<point> q=new ArrayList<point>();
	
	public void init() throws IOException{
		BufferedReader bf=new BufferedReader(new FileReader("./txt/camelot.in"));
		String line=bf.readLine();
		String[] nums=line.split(" ");
		n=Integer.parseInt(nums[0]);
		m=Integer.parseInt(nums[1]);
		line=bf.readLine();
		while(line!=null){
			String[] nums1=line.split(" ");
			for(int i=0;i<nums1.length;i++){
				point tmpP=new point(Integer.parseInt(nums1[i+1]),nums1[i].charAt(0)-'A'+1);
				situ.add(tmpP);
				i++;
				tot++;
			}
			line=bf.readLine();
		}
	}
	
		
	
public void bfs(int x,int y){
		
		dis[x][y][x][y]=0;
		vis[x][y]=1;
		point p1=new point(x,y);
		q.add(p1);
		while(q.size()>0){
			for(int i=0;i<8;i++){
				int tx=q.get(0).x+dx[i];
				int ty=q.get(0).y+dy[i];
				
				if(tx>=1&&ty>=1&&tx<=n&&ty<=m&&vis[tx][ty]==0){
					point tmpP=new point(tx,ty);
					q.add(tmpP);
					vis[tx][ty]=1;
					int tmp11=dis[x][y][q.get(0).x][q.get(0).y]+1;
					dis[x][y][tx][ty]=tmp11;
				}
			}
			q.remove(0);
		}
	} 
	
	public void InitKing(){
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				disKing[i][j]=Math.max(Math.abs(situ.get(0).x-i), Math.abs(situ.get(0).y-j));
			}
		}
	}
	
public void solve(){
	for(int i=1;i<31;i++){
		for(int j=1;j<31;j++){
			for(int h=1;h<31;h++){
				for(int g=1;g<31;g++){
					dis[i][j][g][h]=0;
				}
			}
		}
	}
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			{
				for(int h=1;h<31;h++){
					for(int g=1;g<31;g++){
						vis[h][g]=0;
					}
				}
			bfs(i,j);
			}
		}
	}
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			for(int k=1;k<tot;k++){
				int tmp=dis[situ.get(k).x][situ.get(k).y][i][j];
				sum[i][j]+=tmp;
			}
		}
	}
	
	for(int i=-2;i<=2;i++){
		for(int j=-2;j<=2;j++){
			if(situ.get(0).x+i>=1&&situ.get(0).y+j>=1&&situ.get(0).x+i<=n&&situ.get(0).y+j<=m){
				point tmpP=new point(situ.get(0).x+i,situ.get(0).y+j);
				kingSitu.add(tmpP);
				tot2++;
			}
		}
	}
	
	best=Integer.MAX_VALUE/2;
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			best=Math.min(best, sum[i][j]+disKing[i][j]);
		}
	}
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			for(int k=1;k<tot;k++){
				for(int t=0;t<tot2;t++){
					int tmp1=sum[i][j]-dis[i][j][situ.get(k).x][situ.get(k).y]+
							dis[situ.get(k).x][situ.get(k).y][kingSitu.get(t).x][kingSitu.get(t).y]
									 +dis[kingSitu.get(t).x][kingSitu.get(t).y][i][j]+disKing[kingSitu.get(t).x][kingSitu.get(t).y];
					best=Math.min(best, tmp1);
				}
			}
		}
	}
}
	
	public void println() throws IOException{
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/camelot.out")));
		System.out.println(best);
		out.println(best);
		out.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		camelot Object=new camelot();
		
		Object.init();
		Object.InitKing();
		Object.solve();
		Object.println();
	}

}
