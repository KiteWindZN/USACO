package chapter3.Chp3_4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class lgame {

	public void findValid(int[] flag,String[] dict,int[] start,int total,List<String> list){
		for(int i=0;i<flag.length;i++){
			if(flag[i]==1){
				int st=start[i];
				int end=0;
				if(i!=25){
					end=start[i+1]-1;
				}
				else end=total-1;
				Search(dict,st,end,list,flag);
			}
		}
	}
	public void Search(String[] dict,int start,int end,List<String> list,int[] flag){
		for(int i=start;i<=end;i++){
			String str=dict[i];
			int myflag=0;
			for(int j=0;j<str.length();j++){
				if(flag[str.charAt(j)-'a']==0){
					myflag=1;
					break;
				}
			}
			if(myflag==0)
				list.add(str);
		}
	}
	
	public void sub(List<String> list,int[][] myCount,int[] count){
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.get(i).length();j++){
				myCount[i][list.get(i).charAt(j)-'a']++;
			}
			for(int j=0;j<26;j++){
				if(myCount[i][j]>count[j])
				{
					list.remove(i);
					Arrays.fill(myCount[i], 0);
					i--;
					break;
				}
			}
		}
	}
	
	public int getValue(String str){
		int v=0;
		int[] value={};
		for(int i=0;i<str.length();i++){
			v+=value[str.charAt(i)-'a'];
		}
		return v;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		lgame Object=new lgame();
		BufferedReader bf=new BufferedReader(new FileReader("./txt/lgame.in"));
		BufferedReader bf1=new BufferedReader(new FileReader("./txt/lgame.dict"));
		String[] dict=new String[40000];
		List<String> list=new ArrayList<String>();
		char ch='a';
		int[] flag=new int[26];
		int[] count=new int[26];
		String line=bf.readLine();
		for(int i=0;i<line.length();i++){
			flag[line.charAt(i)-'a']=1;
			count[line.charAt(i)-'a']++;
		}
		line=bf1.readLine();
		int index=0;
		int total=0;
		int[] start=new int[26];
		start[0]=0;
		while(!line.equals(".")){
			dict[total++]=line;
			if(ch!=line.charAt(0)){
				ch=line.charAt(0);
				start[++index]=total;
			}
			line=bf1.readLine();
		}
		
		Object.findValid(flag, dict, start, total, list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		int[][] myCount=new int[list.size()][26];
		Object.sub(list, myCount, count);
		
		
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		
		int[] value=new int[list.size()];
		List<List<String>> res=new ArrayList<List<String>>();
		List<String> tmpL=new ArrayList<String>();
		int[][] secCount=new int[list.size()][26];
		int myIndex=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).length()>=5){
				value[i]=Object.getValue(list.get(i));
			}
			else{
				String str=list.get(i);
				tmpL.add(str);
				secCount[myIndex]=myCount[i];
			}
		}
	}

}
