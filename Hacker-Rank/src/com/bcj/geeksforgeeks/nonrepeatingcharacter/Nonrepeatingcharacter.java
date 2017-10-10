package com.bcj.geeksforgeeks.nonrepeatingcharacter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Nonrepeatingcharacter { static char c ;
public static void main(String[] args) {
    String str= "geeksforgeeks";
   System.out.println(getNonRepeatingCharacter(str));
  }
  public static char  getNonRepeatingCharacter(String str){
    Map<Character, Integer>  map= new HashMap<>();
    
   
   for(char ch: str.toCharArray()){
     if(!map.containsKey(ch))
   map.put(ch,1);
     else {
          map.put(ch,(map.get(ch))+1);
     }
   
   }
    
   for(char c  : str.toCharArray()){
	      if(map.get(c)==1)
	    	  return c;
	     
	        }
	  
  
return (Character) null;
  
  }
}
