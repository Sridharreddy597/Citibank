package com.bcj.HackerRank.anagram;

import java.util.Scanner;

public class MakingAnagrams {
	public static int numberNeeded(String first, String second) {

        
        int offset = (int)'a';
        int[] charArray1= new int[26];
        int[] charArray2= new int[26];
        int num=0;
        for(char ch: first.toCharArray()){
            int value= (int)ch-'a';
            charArray1[value]++;
            
        }
        for(char ch1 : second.toCharArray()){
            int value2=(int) ch1-'a';
            charArray2[value2]++;
        }
            
        for(int i =0; i<26;i++){
            num= num+ Math.abs(charArray1[i]-charArray2[i]);
        }
        return num;
	  }

	  public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    String a = in.next();
	    String b = in.next();
	    System.out.println(numberNeeded(a, b));
	  }
}