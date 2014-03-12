package com.kchopra.github.solutions.Trees;
/**
 * @author kunalchopra
 */
import com.kchopra.github.solutions.Trees.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree {
	public TreeNode root;
	public int size;
	
	public BinarySearchTree() {
		root = null; 
		size = 0;
	}
	
	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
		} else {
			insertNode(root, value);
		}
		size++;
	}
	
	public void insertNode (TreeNode node, int value) {
		if (value <= node.value){
			if (node.leftChild == null)
				node.leftChild = new TreeNode(value);
			else 
				insertNode(node.leftChild, value);
		} else if (value > node.value){
			if (node.rightChild == null)
				node.rightChild = new TreeNode(value);
			else 
				insertNode(node.rightChild, value);
		}
	}
	
	// root, left, right
	public void preOrderTraversal(TreeNode root) {
		System.out.println(root.value);
		if (root.leftChild != null)
			preOrderTraversal(root.leftChild);
		if (root.rightChild != null)
			preOrderTraversal(root.rightChild);
	}
	
	// Will print in sorted order. left, root, right
	public void inOrderTraversal(TreeNode root) {
			if (root.leftChild != null)
				inOrderTraversal(root.leftChild);
			System.out.println(root.value);
			if (root.rightChild != null)
				inOrderTraversal(root.rightChild);
	}

	public TreeNode getMinimum(TreeNode root) {
		while (root.leftChild != null)
			root = root.leftChild;
		return root;
	}
	
	public TreeNode getMaximum(TreeNode root) {
		while (root.rightChild != null)
			root = root.rightChild;
		return root; // this is last node
	}
	
	/*
	 * Least common ancestor of two nodes
	 */
	public TreeNode getLeastCommonAncestor(TreeNode root, int value1, int value2) {
		TreeNode node = root;
		while (node != null) {
			if (node.value > value1 && node.value > value2) {
				node = node.leftChild;
			} 
			else if (node.value <value1 && node.value <value2) {
				node = node.rightChild;
			} 
			else { //this is between both value1 and value2
				return node;
			}
		}
		return null;
	}
	
	/*
	 * Read a node and add its left and right child to a linkedlist
	 * the index of the arraylist is the level 
	 */
	public ArrayList<LinkedList<TreeNode>> createListPerLevel() {
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		int level = 0;
		nodes.add(root);
		list.add(level, nodes);
		
		while (true) {
			nodes = new LinkedList<TreeNode>();
			for (int i=0; i < list.get(level).size(); i++) {
				if (list.get(level).get(i).leftChild != null)
					nodes.add(list.get(level).get(i).leftChild);
				if (list.get(level).get(i).rightChild != null)
					nodes.add(list.get(level).get(i).rightChild);
			}
			
			if (nodes.size() > 0) { //atleast 1 node was found at this level
				list.add(level+1, nodes);//add this to the next level in arraylist
			} else { //all levels traversed
				break;
			}
			level++;
		}
		//We have to do a BFS
		return list;
	}
	
	public TreeNode getRoot() {
		return root;
	}
	
	public int getSize() {
		return size;
	}

}
