package com.kchopra.github.solutions.Sorting;
/**
 * @author kunalchopra
 */
import com.kchopra.github.solutions.Sorting.*;

public class SortTester {

	public static void main(String[] args) {
		int[] numbers1 = {4, 12, 6, 8, 2, 16, 34, 66, 14, 18 };
	
		QuickSort qsort = new QuickSort();
		qsort.sort(numbers1);
		for (int num: numbers1) 
			System.out.print(num+" ");
		System.out.println();
		
		MergeSort mSort = new MergeSort();
		int[] numbers = {4, 2, 6, 8, 22, 16, 34, 66, 14, 18 };
		System.out.println("Before MergeSort:");
		for (int num: numbers) 
			System.out.print(num+" ");
		System.out.println();
				
		mSort.sort(numbers);
		
		System.out.println("After MergeSort:");
		for (int num: numbers) 
			System.out.print(num+" ");
		System.out.println();	
	}
}





