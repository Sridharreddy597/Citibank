package com.bcj.geeksforgeeks.repeatedstring;

public class RepeatedString {
	
	
	public static void main(String[] args) {
				System.out.println(findFirstRepeatedString("geeksforgeeks"));
	}
	public static  char  findFirstRepeatedString(String str){
		char ch[] = str.toCharArray();
		for(int i=0; i<ch.length;i++){
		
			for(int j=i;j<ch.length;j++){
				if(ch[i]==ch[j])
					return ch[i];
				break;
				
			}
		
		
		}
		
		
		
		
		return 0;
		
	}

}
