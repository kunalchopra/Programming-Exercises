package com.kchopra.github.solutions.Trees;
/**
 * @author kunalchopra
 */
import com.kchopra.github.solutions.Trees.*;

import java.util.LinkedList;
import java.util.ArrayList;

public class Trees {

	public static void main(String[] args) {
		// Binary Search Tree Test
		BinarySearchTree treeBST = new BinarySearchTree();
		System.out.println("Reading size..."+ treeBST.getSize());
		treeBST.insert(20);
		treeBST.insert(8);
		treeBST.insert(22);
		treeBST.insert(4);
		treeBST.insert(12);
		treeBST.insert(14);
		treeBST.insert(10);
		
		System.out.println("Reading size..."+ treeBST.getSize());
		System.out.println("Pre-order traversal");
		treeBST.preOrderTraversal(treeBST.getRoot());
		System.out.println("In-order traversal");
		
		treeBST.inOrderTraversal(treeBST.getRoot());
		System.out.println("Minimum value in the tree..."+treeBST.getMinimum(treeBST.getRoot()).value);
		System.out.println("Minimum value in the tree..."+treeBST.getMaximum(treeBST.getRoot()).value);
	
		ArrayList<LinkedList<TreeNode>> list = treeBST.createListPerLevel();
		for (int i=0; i < list.size(); i++) {
			System.out.println("Level "+i);
			for (int j=0; j < list.get(i).size(); j++) {
				System.out.print(" "+list.get(i).get(j).value);
			}
			System.out.println();
		}
		System.out.println("Lease Common Ancestor of 4 and 14 is:");
		System.out.println(treeBST.getLeastCommonAncestor(treeBST.getRoot(), 4, 14).value);
		System.out.println("Pre-order traversal");
		treeBST.preOrderTraversal(treeBST.getRoot());
		
	}

}
