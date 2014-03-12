package com.kchopra.github.solutions.LinkedLists;
/**
 * @author kunalchopra
 */
import java.util.Iterator;

import com.kchopra.github.solutions.LinkedLists.*;

public class ListTester {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addNode(2);
		list.addNode(8);
		list.addNode(5);
		list.addNode(4);
		list.addNode(7);
		list.addNode(5);
		ListNode<Integer> node = list.addNode(5); 
		list.addNode(3);
		list.addNode(8);
		list.addNode(7);
		list.addNode(5);
		list.traverse();
		ListNode<Integer> nthNode = list.findNthfromEnd(4);
		System.out.println("4th node from end of the list is: "+nthNode.value);
		
		System.out.println(":::Merging two sorted linked lists:::");
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list1.addNode(2);
		list1.addNode(4);
		list1.addNode(6);
		list1.addNode(8);
		System.out.println("LinkedList #1:");
		list1.traverse();
		
		list2.addNode(1);
		list2.addNode(3);
		list2.addNode(5);
		list2.addNode(7);
		list2.addNode(13);
		list2.addNode(25);
		list2.addNode(44);
		System.out.println("LinkedList #2:");
		list2.traverse();
		
		for (ListNode<Integer> n: list2) {
			System.out.println(n.value);
		}
		
		LinkedList<Integer> mergedList = mergeLists(list1, list2);
		System.out.println(":::Merged list:::");
		mergedList.traverse();
		list.reverse();
		System.out.println("Reversing list...");
		list.traverse();		
		
		list.removeNode(node);
		list.traverse();

		list.deleteNode(2);
		list.deleteNode(3);
		list.deleteNode(7);
		list.traverse();
		
		list.removeDuplicates();
		list.traverse();
	}
	
	public static LinkedList<Integer> mergeLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		LinkedList<Integer> mergeList = new LinkedList<Integer>();
		
		Iterator<ListNode<Integer>> iter1 = list1.iterator();
		Iterator<ListNode<Integer>> iter2 = list2.iterator();
		
		ListNode<Integer> node1;
		ListNode<Integer> node2;
		while (iter1.hasNext()) {
			if (iter2.hasNext()) {
				node1 = iter1.next();
				node2 = iter2.next();
				if (node1.value < node2.value) {
					mergeList.addNode(node1.value);
					mergeList.addNode(node2.value);
				} else { 
					mergeList.addNode(node2.value);
					mergeList.addNode(node1.value);
				}
			} else { //list2 completed.
				mergeList.addNode(iter1.next().value);
			}
		}
		
		// case when list1 had fewer nodes
		while (iter2.hasNext())
			mergeList.addNode(iter2.next().value);
		
		return mergeList;
	}
	

}
