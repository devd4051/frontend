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
		
		char min = input1.charAt(0);
		int minIndex = 0;
		for(int i = 1 ; i < input1.length() ; i++){
			if(input1.charAt(i) < min){
				min = input1.charAt(i);
				minIndex = i;
			}
		}
		
		String result = generateString(minIndex, input1, false);
		subs.add(result);
		
		Anamoly anamoly = getNextAnamoly(minIndex, input1);
		while(anamoly.isAnamoly()){
			String updatedString = anamoly.getUpdatedString();
			result = generateString(anamoly.getAnamolyIndex(), anamoly.getUpdatedString(), anamoly.isAnamoly());
			subs.add(result);
			
			anamoly = getNextAnamoly(minIndex, updatedString);
		}
		
		for(String res : subs){
			System.out.println(res);
		}
		
		return null;
	}
	
	private static String generateString(int startIndex,String updatedString,boolean anamoly){
		StringBuilder builder = new StringBuilder();
		if(anamoly){
			builder.append(updatedString.substring(0, startIndex));
			startIndex--;
		}else{
			builder.append(updatedString.charAt(startIndex));
		}
		
		boolean exit = false;
		char max = ' ';
		for(int i = startIndex ; i < updatedString.length() - 1 ; i++){
			for(int j = i + 1 ; j < updatedString.length() ; j++){
				if(j==updatedString.length()-1){
					exit = true;
				}
				if(updatedString.charAt(i) <= updatedString.charAt(j) && max >= updatedString.charAt(j)){
					max = updatedString.charAt(j);
					builder.append(updatedString.charAt(j));
					break;
				}
			}
			if(exit){
				break;
			}
		}
		
		/*for(int i = startIndex ; i < updatedString.length() - 1 ; i++){
			if(updatedString.charAt(i) <= updatedString.charAt(i+1)){
				builder.append(updatedString.charAt(i+1));
			}
		}*/
		
		return builder.toString();
	}

	private static Anamoly getNextAnamoly(int startIndex,String lastUpdatedString){
		StringBuilder builder = new StringBuilder(lastUpdatedString);
		Anamoly anamoly = new Anamoly();
		for(int i = startIndex ; i < lastUpdatedString.length() - 1 ; i++){
			if(lastUpdatedString.charAt(i) > lastUpdatedString.charAt(i+1)){
				builder.deleteCharAt(i);
				anamoly.setAnamoly(true);
				anamoly.setAnamolyIndex(i);
				anamoly.setUpdatedString(builder.toString());
				break;
			}
		}
		return anamoly;
	}
	
	private static class Anamoly{
		
		private String updatedString;
		
		private int anamolyIndex;
		
		private boolean anamoly;

		public String getUpdatedString() {
			return updatedString;
		}

		public void setUpdatedString(String updatedString) {
			this.updatedString = updatedString;
		}

		public int getAnamolyIndex() {
			return anamolyIndex;
		}

		public void setAnamolyIndex(int anamolyIndex) {
			this.anamolyIndex = anamolyIndex;
		}

		public boolean isAnamoly() {
			return anamoly;
		}

		public void setAnamoly(boolean anamoly) {
			this.anamoly = anamoly;
		}
		
	}
}
