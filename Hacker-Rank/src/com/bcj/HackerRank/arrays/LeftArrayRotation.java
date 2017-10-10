package com.bcj.HackerRank.arrays;

import java.util.Scanner;

public class LeftArrayRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		arrayLeftRotation(a, k);
		printArray(a, a.length);

	}

	private static void arrayLeftRotation(int[] a, int k) {
		for (int i = 0; i < k; i++)
			rotateArray(a);

	}

	private static void rotateArray(int[] a) {
		int temp = a[0];
		for (int l = 0; l < a.length - 1; l++)
			a[l] = a[l + 1];
		a[a.length - 1] = temp;

	}
	static void printArray(int arr[], int size)
	{
	  int i;
	  for(i = 0; i < size; i++)
	    System.out.println(arr[i]+" ");
	}
	
}