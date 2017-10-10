package com.bcj.HackerRank.Hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String magazine[] = new String[m];
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			magazine[magazine_i] = in.next();
		}
		String ransom[] = new String[n];
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			ransom[ransom_i] = in.next();
		}
		if (getRansom(m, n, magazine, ransom))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private static boolean getRansom(int m, int n, String[] magazine, String[] ransom) {
		if (m < n)
			return false;
		Map<String, Integer> magMap = getStringsinMap(magazine);
		Map<String, Integer> ransomMap = getStringsinMap(ransom);
		for (String key : ransomMap.keySet()) {
			if (!magMap.containsKey(key))
				return false;
			if (magMap.get(key) < ransomMap.get(key))
				return false;
		}
		return false;
	}

	private static Map<String, Integer> getStringsinMap(String[] stringArray) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : stringArray)
			if (!map.containsKey(str))
				map.put(str, 1);
			else
				map.put(str, map.get(str) + 1);
		return map;

	}

}