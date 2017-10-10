package com.bcj.HackerRank.LinkedList;



public class Node {

	
	        int data;
	        Node next;
	   
	
	boolean hasCycle(Node head) {
	     Node fast = head.next;
	    Node slow= head;
	    if(head==null || next==null|| head.next==null ||slow.next==null) return false;
	   
	    while(fast!=null && head.next!=null && slow!=null){
	        if(fast==slow)
	            return true;
	        fast=fast.next.next;
	        slow=slow.next;        
	    }
	return false;    
	}
}
