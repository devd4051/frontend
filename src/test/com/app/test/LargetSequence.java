package com.app.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargetSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String ip1 = in.nextLine().trim();
		String output = longestIncreasingSequence(ip1);
		System.out.println(output);
		in.close();
	}
	
	private static String longestIncreasingSequence(String input1){
		List<String> subs = new ArrayList<String>();
		
		System.out.println(subs);
		
		return null;
	}
	
	private static boolean isIncreasingSequence(String sequence){
		for(int i = 0 ; i < sequence.length() && (i+2) <= sequence.length() ; i++){
			String sub1 = sequence.substring(i, i+1);
			String sub2 = sequence.substring(i+1,i+2);
			if(sub2.compareTo(sub1) < 0){
				return false;
			}
		}
		return true;
	}

}
