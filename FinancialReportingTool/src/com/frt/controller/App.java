package com.frt.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

	static int j;

	static void methodA(int i) {
		boolean b;
		do {
			b = i < 10 | methodB(4); /* Line 9 *///b=true|true
			b = i < 10 || methodB(8); /* Line 10 */
		} while (!b);
	}

	static boolean methodB(int i) {
		j += i;
		return true;
	}

	public static void main(String[] args) {

		methodA(0);
		System.out.println("j = " + j);
		/*
		 * List<String> list = new ArrayList<>(); list.add("Juhi");
		 * list.add("Nehal"); list.add("Vishal"); list.add("Juhi"); for(String
		 * name:list){ System.out.println(name); System.out.println(); }
		 * 
		 * Set<String> set = new HashSet<>(list); for(String name1:set){
		 * System.out.println(name1); }
		 */
		/*
		 * int numbers[] = {23,5,23,1,7,12,3,34,0};
		 * 
		 * bubbleSort(numbers);
		 * 
		 * for(int num:numbers){ System.out.println(num); }
		 */

	}

	/*
	 * public static void bubbleSort(int array[]){ int temp; int n =
	 * array.length; for(int i=0; i < n ;i++){ for(int j=1; j<n-1; j++){
	 * if(array[j-1]>array[j]){ temp = array[j-1]; array[j-1] = array[j];
	 * array[j] = temp; } } } }
	 */

}
