package chapter3.Chp3_1;
/*
ID: 15605181
LANG: JAVA
TASK: inflate
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class inflate {

	int totaltime=0;
	int num=0;
	int[] points=new int[10000];
	int[] time=new int[10000];
	double[] value=new double[10000];
	int res=0;
	
	public void ReadFile() throws IOException{
		BufferedReader bf=new BufferedReader(new FileReader("./txt/inflate.in"));
		String line=bf.readLine();
		String[] nums=line.split(" ");
		
		totaltime=Integer.parseInt(nums[0]);
		num=Integer.parseInt(nums[1]);
		line=bf.readLine();
		int i=0;
		while(line!=null){
			String[] nums1=line.split(" ");
			points[i]=Integer.parseInt(nums1[0]);
			time[i]=Integer.parseInt(nums1[1]);
			value[i]=points[i]/(double)time[i];
			i++;
			line=bf.readLine();
		}
	}
	
	public void mySort(){
		for(int i=num-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(value[j]<value[j+1])
				{
					double d=value[j];
					value[j]=value[j+1];
					value[j+1]=d;
					
					int tmp=points[j];
					points[j]=points[j+1];
					points[j+1]=tmp;
					
					tmp=time[j];
					time[j]=time[j+1];
					time[j+1]=tmp;
				}
			}
		}
	}
	
	public void solve(){
		for(int i=0;i<num;i++){
			if(time[i]<totaltime){
				int div=totaltime/time[i];
				res+=div*points[i];
				totaltime%=time[i];
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/inflate.out")));
		inflate Object=new inflate();
		Object.ReadFile();
		Object.mySort();
		Object.solve();
		//System.out.println(Object.res);
		out.println(Object.res);
		out.close();
	}

}
