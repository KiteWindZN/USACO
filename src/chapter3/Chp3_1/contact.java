package chapter3.Chp3_1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class contact {
    char[] myChar=new char[200000];
    Map<String,Integer> map=new HashMap<String,Integer>();
    char[] seeds={'0','1'};
    List<String> list=new ArrayList<String>();
    int A=0;
    int B=0;
    int N=0;
    int index=0;
	public void myReader() throws IOException{
		BufferedReader bf=new BufferedReader(new FileReader("./txt/contact.in"));
		String line=bf.readLine();
		String[] nums=line.split(" ");
		A=Integer.parseInt(nums[0]);
		B=Integer.parseInt(nums[1]);
		N=Integer.parseInt(nums[2]);
		
		
		line=bf.readLine();
		while(line!=null){
			for(int i=0;i<line.length();i++){
				myChar[index++]=line.charAt(i);
			}
			line=bf.readLine();
		}
	}
	public void InitMap(){
		for(int i=0;i<list.size();i++){
			map.put(list.get(i), 0);
		}
	}
	
	public void InitList(){
		for(int i=A;i<=B;i++){
			createList(0,i,"");
		}
	}
	
	public void createList(int count,int len,String tmpS){
		if(count==len)
			list.add(tmpS);
		else{
			for(int i=0;i<=1;i++){
				tmpS=tmpS+seeds[i];
				createList(count+1,len,tmpS);
				tmpS=tmpS.substring(0, tmpS.length()-1);
			}
		}
	}
	

	public void Solve(){
		for(int i=0;i<index;i++){}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		contact Object=new contact();
		
		
	}

}
