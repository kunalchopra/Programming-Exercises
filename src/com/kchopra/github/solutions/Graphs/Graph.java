package com.kchopra.github.solutions.Graphs;
/**
 * @author kunalchopra
 */
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Stack;

import com.kchopra.github.solutions.Graphs.Vertex;

public class Graph {
	private int noVertices;
	private Map<Integer, Vertex> vertices;
	private Map<Integer, LinkedList<Integer>> adj;
	
	public Graph() {
		this.noVertices = 0;
		vertices = new HashMap<Integer, Vertex>();
		adj = new HashMap<Integer, LinkedList<Integer>>();
	}
	
	public int getTotalVertices() {
		return noVertices;
	}
	
	public void addVertex(int value) {
		Vertex node = new Vertex(value);
		vertices.put(value, node);
		adj.put(value, new LinkedList<Integer>());
		noVertices++;
	}
	
	public void addEdge(int value1, int value2) {
		(adj.get(value1)).add(value2);
	}
	
	public boolean dfs(int origin, int value) {
		Stack<LinkedList<Integer>> stack = new Stack<LinkedList<Integer>>();
		Vertex currVertex;

		currVertex = vertices.get(origin);
		currVertex.visit();
		
		LinkedList<Integer> adjList;
		adjList = adj.get(currVertex.getValue());
		
		stack.push(adjList);
		while (!stack.isEmpty()) {
			// get next adjacency list from stack
			adjList = stack.pop();
			// iterate through adjacency list and visit each unvisited vertex
			for (int vertex: adjList) {
				//get vertex object from map
				currVertex = vertices.get(vertex);
				
				if (!currVertex.isVisited()) {
					currVertex.visit();
					if (currVertex.getValue() == value) {
						System.out.println("FOUND "+value);
						return true;
					} 
					//push adjacency list of each vertex on top of stack
					stack.push(adj.get(currVertex.getValue()));
				} else {
					System.out.println("SKIP: "+ currVertex.getValue()+" already visited");
				}
			}
		}
		return false;
	}
	
	public void unVisitVertices() {
		for (Map.Entry<Integer, Vertex> entry: vertices.entrySet()) {
			entry.getValue().unVisit();
		}
	}
	

}
