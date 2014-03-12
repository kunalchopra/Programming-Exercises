package com.kchopra.github.solutions.Interviews;

/**
 * @author kunalchopra
 */
import com.kchopra.github.solutions.Trees.TreeNode;
import com.kchopra.github.solutions.Trees.BinarySearchTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ArrayList;

public class Set1 {

	public static void main(String[] args) {
		int[] array = {2, 2, 4, 6, 8, 5, 3, 12, 1, 10};
		int[] array2 = {2, 2, 4, -6, 8, 5, 3, -12, 1, 10};
		int sum = 12; 
		
		arrayPairSum(array, sum);
		System.out.println("Largest continous sum in array: " + largestContinousSum(array2));
		
		System.out.println("First non-repeated character in PPMAMANSEN is: "+firstNonRepeated("PPMAMANSEN"));
		
		System.out.println(":::Printing permutations for ABC:::");
		permutations("ABC");
		
		System.out.println("hello and ollleh are anagrams? "+isAnagram("hello", "ollleh"));
		System.out.println("hello and olleh are anagrams? "+isAnagram("hello", "olleh"));
		System.out.println("hellO and olleh are anagrams? "+isAnagram("hellO", "olleh"));
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(8);
		bst.insert(22);
		bst.insert(4);
		bst.insert(12);
		bst.insert(10);
		bst.insert(14);
		printTreeLevels(bst);
		
		System.out.println("Call atoi(\"-1234\") - result as in int is: "+atoi("-1234"));
		System.out.println("Call itoa(\"-1234\") - result as in int is: "+itoa(-1234));
		
		int[][] matrix = {{1,2,3,4},
						  {5,6,7,8},
						  {9,10,11,12},
						  {13,14,15,16}};
		System.out.println("Original square matrix: ");
		printMatrix(matrix);
		rotateClockwise(matrix);
		System.out.println("After rotating 90 degree clockwise: ");
		printMatrix(matrix);
		
		System.out.println("Factorial:: 3! = "+factorial(3));
		System.out.println("Fibanacci:: 8th number = "+fibonacci(8));
	}
	
	/**
	 *  Given an integer array, output all pairs that sum up to a specific value k.
	 */
	public static void arrayPairSum(int[] array, int sum) {
		HashSet<Integer> numbers = new HashSet<Integer>();
		for (int number: array) {
			if (numbers.contains(sum - number)) {
				System.out.println("Pair: ("+number+", "+(sum-number)+")");
			} else {
				numbers.add(number);
			}
		}
	}
	
	/**
	 *  Given an array of integers (positive and negative) find the largest continuous sum.
	 *  CATCH: It can be the largest negative sum as well. e.g. -30
	 */
	public static int largestContinousSum(int[] array) {
		int length = array.length;
		int currSum;
		int currMax = currSum = array[0];
		for (int i=1; i < length; i++) {
			if (array[i] > currSum+array[i])
				currSum = array[i];
			else 
				currSum = currSum+array[i];
			
			if (currSum > currMax)
				currMax = currSum;
		}
		return currMax;
	}
	
	/**
	 *  Find the first non-repeated (unique) character in a given string. 
	 *  Time complexity: O(N)
	 */
	public static String firstNonRepeated(String str) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int length = str.length();
		int value;
		for (int i=0; i < length; i++) {
			value = map.get(str.substring(i, i+1)) == null ? 0 : map.get(str.substring(i, i+1))+1;
			map.put(str.substring(i, i+1), value);
		}
		for (int j=0; j < length; j++) {
			if (map.get(str.substring(j, j+1)) == 0) 
				return str.substring(j, j+1);
		}
		
		return null; //Case: No unique characters in string
	}
	
	/**
	 *  Generate all permutations of a given string.
	 */
	public static void permutations(String str) {
		permutations("", str);
	}
	
	// Overloaded function
	public static void permutations(String prefix, String str) {
		int length = str.length();
		//Base case
		//No chars left to process, print current permutation
		if (length == 0) { 
			System.out.println(prefix);
			return;
		}
		//Add first character (from left) to the prefix which are remaining in the unprocessed string
		//recursively call permutations until prefix has all characters (1 complete permutation) 
		//and print the results
		for (int i=0; i < length; i++) {
			permutations(prefix+str.substring(i, i+1), str.substring(0,i)+str.substring(i+1));
		}
	}
	
	/**
	 *  Given two strings, check if theyÕre anagrams or not. 
	 *  Two strings are anagrams if they are written using the same exact letters, 
	 *  ignoring space, punctuation and capitalization. Each letter should have 
	 *  the same count in both strings. 
	 *  For example, ÔEleven plus twoÕ and ÔTwelve plus oneÕ are meaningful anagrams of each other. 
	 *  Time complexity: O(N) - 2 linear scans
	 *  Alternative implementation: Sort strings and compare - time complexity: O(Nlogn)
	 */
	public static boolean isAnagram(String str1, String str2) {
		//If different lengths, cannot be anagrams
		if (str1.length() !=  str2.length())
			return false;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int value;
		int length = str1.length();
		for (int i=0; i < length; i++) {
			value = map.get(str1.substring(i, i+1)) == null ? 1 : map.get(str1.substring(i, i+1))+1;
			map.put(str1.substring(i, i+1), value);
		}
		for (int j=0; j < length; j++) {
			if (map.get(str2.substring(j, j+1)) == null) { //Char not in str1
				return false;
			} else {
				//Decrease the count
				map.put(str1.substring(j, j+1), map.get(str1.substring(j, j+1))-1); 
				//If count is less than 0 that means this char has more occurrences in str2
				if (map.get(str1.substring(j, j+1)) < 0)
					return false;
			}
		}
		return true;
	}
	
	/**
	 *  Convert a given string to number.
	 *  HINT: use '0' ascii value to compute 
	 *  TODO: No checks for invalid characters, doesn't work for decimal type
	 */
	public static int atoi(String str) {
		int number = 0;
		int length = str.length();
		int digit = 1; //starting from unit's place
		int firstIndex = 0; //Index till which string should be processed (1 in case of negatives)
		boolean isNegative = false;
		
		//Invalid string
		if (length == 0) 
			return -1;
		
		//Check if negative number
		if (str.charAt(0) == '-') {
			firstIndex = 1;
			isNegative = true;
		}
		// Read character from end of the string (i.e. starting from units place)
		// Assign this to running sum.
		// Increase digit's place by multiply by 10
		// Keep on adding to running sum as (charValue * digit's place value)
		// return sum
		for (int i=length-1; i >= firstIndex; i--) {
			number += (str.charAt(i) - '0') * (digit);
			digit *= 10;
		}
		
		if (isNegative) 
			number = number * -1;
		
		return number;
	}
	
	/**
	 *  Convert a given number to string.
	 *  TODO: Doesn't work for decimal type
	 */
	public static String itoa(int number) {
		String str = "";
		boolean isNegative = false;
		int digit = 10;
		int num = 0;
		
		if (number < 0) {
			isNegative = true;
			number = number * -1;
		}
		
		// Read digit starting at the unit's place
		// Append this to the current string
		// Decrease the number by dividing by 10 to retrieve next digit in following loop
		while (number != 0) {
			num = (number % digit);
			str = (char) (num + '0') + str;
			number = number/digit;
		}
		
		if (isNegative)
			str = "-" + str;
		
		return str.toString();
	}
	
	/**
	 *  Given a binary tree of integers, print it in level order. 
	 *  The output will contain space between the numbers in the same level, 
	 *  and new line between different levels. 
	 */
	public static void printTreeLevels(BinarySearchTree bst) {
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		TreeNode node = bst.getRoot();
		int level = 0;
		//Level0
		nodes.add(node);
		list.add(level, nodes);
		
		while (true) {
			nodes = new LinkedList<TreeNode>();
			for (int i=0; i < list.get(level).size(); i++) {
				node = list.get(level).get(i);
				if (node.leftChild != null) 
					nodes.add(node.leftChild);
				if (node.rightChild != null) 
					nodes.add(node.rightChild);
			}
			if (nodes.size() > 0) { //atleast one node was added at this level
				list.add(level+1, nodes);
				level++;
			} else {
				break;
			}
		}
		for (int i=0; i < list.size(); i++) {
			System.out.println("Nodes at tree level "+i);
			for (TreeNode n: list.get(i)) {
				System.out.print(n.value+"  ");
			}
			System.out.println();
		}
	}
	
	/**
	 *  Generate the Factorial for N.
	 */
	public static int factorial(int number) {
		if (number < 0)
			return -1;//Invalid number
		
		if (number <= 1)
			return 1;
		
		return number * factorial(number-1);
	}
	
	/**
	 *  Generate the nth Fibonacci number.
	 */
	public static int fibonacci(int number) {		
		if (number < 1)
			return -1; //Invalid number
		else if (number == 1)
			return 0;
		else if (number == 2) 
			return 1;
		else {
			return fibonacci(number-1) + fibonacci(number-2);
		}
	}
	
	/**
	 *  Rotate matrix clockwise 90 degrees in place.
	 */
	public static void rotateClockwise(int[][] matrix) {
		int temp;
		int length;
		for (int i=0; i < matrix.length/2; i++) {
			length = matrix[i].length;
			for (int j=0; j < (length+1)/2; j++) { //length+1 for cases with odd number 
				temp = matrix[i][j];
				matrix[i][j] = matrix[length-j-1][i];
				matrix[length-j-1][i] = matrix[length-i-1][length-j-1];
				matrix[length-i-1][length-j-1] = matrix[j][length-i-1];
				matrix[j][length-i-1] = temp;
			}
			
		}
	}
	
	/**
	 *  :::Util Functions:::
	 */
	public static void printMatrix(int[][] matrix) {
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	
}

