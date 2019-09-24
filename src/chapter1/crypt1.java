package chapter1;
/*
ID: 15605181
LANG: JAVA
TASK: crypt1
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class crypt1 {

	public int GenerateNum(List<Integer> list){
		int res=0;
		for(int i=0;i<list.size();i++){
			
			for(int j=0;j<list.size();j++){
				for(int x=0;x<list.size();x++){
					int tmp=list.get(i)*100+list.get(j)*10+list.get(x);
					
					for(int y=0;y<list.size();y++){
						
						if(tmp*list.get(y)>=1000) continue;
						for(int z=0;z<list.size();z++){
							if(tmp*list.get(z)>=1000) continue;
							int tmp2=list.get(y)*10+list.get(z);
							int tmp1=tmp*tmp2;
							if(tmp1>=10000)
								continue;
							else {
								if(IsExist(list,tmp1)&&(tmp1>=1000)){
									if(IsExist(list,tmp*list.get(z))&&IsExist(list,tmp*list.get(y))){
									//System.out.print("tmp="+tmp+"  "+"yz="+tmp2+"  ");
									//System.out.println("tmp1="+tmp1);
								   res++;
								   }
								}
								}
						}
					}
				}
			}
		}
		return res;
	}
	public boolean IsExist(List<Integer> list,int num){
		int flag=0;
		while(num!=0){
			int t=num%10;
			for(int i=0;i<list.size();i++)
			{
				if((t-list.get(i))==0)
				{
					flag=1;
					break;
				}
			}
			if(flag==0)
				return false;
			num=num/10;
			flag=0;
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		crypt1 Object=new crypt1();
		int res=0;
      BufferedReader bf=new BufferedReader(new FileReader("./txt/crypt1.in"));
      PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("./txt/crypt1.out")));
       int num=Integer.parseInt(bf.readLine());
       String line=bf.readLine();
       String[] nums=line.split(" ");
       List<Integer> list=new ArrayList<Integer>();
       for(int i=0;i<nums.length;i++){
    	   list.add(Integer.parseInt(nums[i]));
       }
       res=Object.GenerateNum(list);
       //System.out.println(res);
       out.println(res);
       out.close();
	}

}
