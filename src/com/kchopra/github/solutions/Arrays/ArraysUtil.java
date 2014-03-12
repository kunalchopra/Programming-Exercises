package com.kchopra.github.solutions.Arrays;
/**
 * @author kunalchopra
 */
public class ArraysUtil {

	public static void main(String[] args) {
		
		int[] sortedArray = {2,4,5,6,7,8,9,12,13,15};		
		int value = 15;
		boolean found = binarySearch(sortedArray, value);
		
		if (found) 
			System.out.println("Value "+value+" is present in the array");
		
		if (!found) 
			System.out.println("Value "+value+" is NOT present in the array");
		
	}
	
	public static boolean binarySearch(int[] array, int value) {
		boolean found = false;
		found = bSearch(array, value, 0, array.length-1);
		return found;
	}
	
	public static boolean bSearch(int[] array, int value, int left, int right) {
		//base case: when to stop recursion
		if (left > right) {
			return false;
		}
		//what to check and make recursive calls
		int mid = (left+right)/2;
		boolean found = false;
		if (array[mid] == value) {
			return true;
		} else if (array[mid] > value){
			found = bSearch(array, value, 0, mid);
		} else if (array[mid] < value){
			found = bSearch(array, value, mid+1, right);
		}
		// what to return
		return found;
	}

}
