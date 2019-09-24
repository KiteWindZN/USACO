/*
ID: 15605181
LANG: JAVA
TASK: ratios
*/
package chapter3.Chp3_2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ratios {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new FileReader("./txt/ratios.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/ratios.out")));
		int[] a=new int[3];
		int[] b=new int[3];
		int[] c=new int[3];
		int[] res=new int[3];
		int a1=0,b1=0,c1=0;
		
		int res1=Integer.MAX_VALUE;
		
		int[] tmp=new int[3];
		int tmp1,tmp2,tmp3;
		String line=bf.readLine();
		int index=0;
		int[] zero=new int[3];
		while(line!=null){
			String[] nums=line.split(" ");
			if(index==0)
			{
				for(int i=0;i<3;i++){
					res[i]=Integer.parseInt(nums[i]);
					if(res[i]==0){
						zero[i]=1;
					}
				}
			}
			if(index==1)
			{
				for(int i=0;i<3;i++){
					a[i]=Integer.parseInt(nums[i]);
					if(zero[i]==1&&a[i]!=0){
						a[0]=0;
						a[1]=0;
						a[2]=0;
					}
				}
			}
			if(index==2)
			{
				for(int i=0;i<3;i++){
					b[i]=Integer.parseInt(nums[i]);
					if(zero[i]==1&&b[i]!=0){
						b[0]=0;
						b[1]=0;
						b[2]=0;
					}
				}
			}
			if(index==3)
			{
				for(int i=0;i<3;i++){
					c[i]=Integer.parseInt(nums[i]);
					if(zero[i]==1&&c[i]!=0){
						c[0]=0;
						c[1]=0;
						c[2]=0;
					}
				}
			}
			line=bf.readLine();
			index++;
		}
		
		int[] mytmp=new int[3];
		int[] mydiv=new int[3];
		
		for(int i=0;i<100;i++){
			for(int j=0;j<100;j++){
				for(int h=0;h<100;h++){
					if(h==0&&i==0&&j==0)
						continue;
					for(int g=0;g<3;g++){
						tmp[g]=i*a[g]+j*b[g]+h*c[g];
					}
					for(int g=0;g<3;g++)
						if(zero[g]==0){
							mydiv[g]=tmp[g]/res[g];
							mytmp[g]=tmp[g]%res[g];
						}
					if(mytmp[0]==0&&(mytmp[1]==0&&(mytmp[2]==0))){
					    tmp1=mydiv[0];
					    tmp2=mydiv[1];
					    tmp3=mydiv[2];
					
					    if(tmp1==0&&tmp2==0&&tmp3==0||(tmp1>=1||tmp2>=1||tmp3>=1))
					     {
					    	for(int g=0;g<3;g++){
					    		if(mytmp[g]!=0)
					    			if(res1>tmp1){
									    res1=tmp1;
									    a1=i;
									    b1=j;
									    c1=h;
								      }
					    	}
						    
					     }
				    }
				}
			}
		}
		if(zero[0]==1)a1=0;
		if(zero[1]==1)b1=0;
		if(zero[2]==1)c1=0;
		System.out.println(a1+" "+b1+" "+c1+" "+res1);
		out.println(a1+" "+b1+" "+c1+" "+res1);
		out.close();
		
	}

}
