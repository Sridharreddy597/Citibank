package com.bcj.geeksforgeeks.secondLargest;

public class SecondLargest {
	
	static int firtlargest, secondlargest;
	public static void main(String[] args) {
		
		 System.out.println(findSecondLargest(new int[] {45, 51, 28, 75, 49, 42}));
		 
	        System.out.println(findSecondLargest(new int[] {985, 521, 975, 831, 479, 861}));
	 
	        System.out.println(findSecondLargest(new int[] {9459, 9575, 5692, 1305, 1942, 9012}));
	 
	        System.out.println(findSecondLargest(new int[] {47498, 14526, 74562, 42681, 75283, 45796}));
		
		
	}

	private static int  findSecondLargest(int[] arr) {
		
		for(int i=0;i<arr.length;i++){
			
			if(arr[i]>firtlargest){
				secondlargest=firtlargest;
				firtlargest=arr[i];
		}
			else if (arr[i]<firtlargest && arr[i]>secondlargest){
				secondlargest=arr[i];
				
			}
		
	}
		return secondlargest;

}

}