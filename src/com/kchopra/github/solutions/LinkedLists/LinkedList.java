package com.kchopra.github.solutions.LinkedLists;
/**
 * @author kunalchopra
 */
import java.lang.Iterable;
import java.util.Iterator;

import java.util.HashSet;

import com.kchopra.github.solutions.LinkedLists.ListNode;

public class LinkedList<T> implements Iterable<ListNode<T>> {

	private int size;
	public ListNode<T> head;
	public ListNode<T> tail;
	
	public LinkedList() {
		size = 0;
		head = tail = null;
	}
	
	 public Iterator<ListNode<T>> iterator() {
	        return new CustomListIterator();
     }
	
	 private class CustomListIterator implements Iterator<ListNode<T>> {
		 ListNode<T> curr = head;
		 @Override
		 public boolean hasNext() {
		    if (curr != null)
		      return true;
		    else
		      return false;
		  }
		 
		  @Override
		  public ListNode<T> next() {
			ListNode<T> node = curr;
			curr = curr.next;
		    return node;
		  }
		 
		  @Override
		  public void remove() {
		      // Optional: Not implemented
			  return;
		  }
	 }
	
	
	
	public ListNode<T> addNode(T value) {
		ListNode<T> node = new ListNode<T>(value);
		if (head == null) { //insert head
			head = node;
			head.next = null;
			tail = head;
		} else {
			tail.next = node;
			node.next = null;
			tail = node;
		}
		size++;
		return node;
	}
	
	// This will delete only the first occurrence
	public boolean deleteNode(T value) {
		ListNode<T> node = head;
		ListNode<T> prev = null;
		
		//Head is a match
		if ((node.value).equals(value)) {
			head = node.next;
			size--;
			return true;
		}
		//others
		while (node != null) {
			if ((node.value).equals(value)) {
				prev.next = node.next;
				node = null;
				size--;
				return true;
			}
			prev = node;
			node = node.next;
		}
		// No element with passed value
		return false;
	}
	
	public void traverse() {
		ListNode<T> node = head;
		StringBuilder str = new StringBuilder();
		
		while (node != null) {
			str.append(node.value+"->");
			node = node.next;
		}
		str.append("end");
		System.out.println(str);
	}
	
	public void removeDuplicates() {
		ListNode<T> node = head;
		ListNode<T> prev = null;
		HashSet<T> map = new HashSet<T>();
		
		while (node != null) {
			if (map.contains(node.value)) {
				prev.next = node.next;
			} else {
				map.add(node.value);
				prev = node;
			}
			node = node.next;
		}
	}
	
	public ListNode<T> findNthfromEnd(int num) {
		ListNode<T> runner1 = head;
		ListNode<T> runner2 = head;
		
		//Move runner2 'num' nodes apart from runner1
		//Then iterate until runner2 reaches to end of list
		//At this point, runner1 is at Nth node from end
		for (int i=1; i <=num ; i++) {
			runner2 = runner2.next;
		}
		while (runner2 != null) {
			runner1 = runner1.next;
			runner2 = runner2.next;
		}
		return runner1;
	}
	
	// Pass the node that needs to be removed from the list
	public void removeNode (ListNode<T> node) {
		ListNode<T> next = node.next;
		node.value = next.value;
		node.next = next.next;
		next = null;
	}
	
	// Reverse the (entire) linked list
	public void reverse () {
		reverseList(head, null);
	}
	
	private void reverseList (ListNode<T> node, ListNode<T> prev) {
		
		if (node.next == null) { //base case; last elem in list; new head
			node.next = prev;
			head = node;
			return;
		} else { //recursion
			reverseList(node.next, node);
		}
		//what to do at each recursive calls
		node.next = prev;
		return;
	}
}




