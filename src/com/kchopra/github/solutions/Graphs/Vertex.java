package com.kchopra.github.solutions.Graphs;
/**
 * @author kunalchopra
 */
public class Vertex {
	
	private boolean visited;
	private int value;
	
	public Vertex (int value) {
		this.value = value;
		this.visited = false;
	}
	
	public void visit() {
		System.out.println("Visiting vertex: "+ this.value);
		this.visited = true;
	}
	
	public void unVisit() {
		this.visited = false;
	}
	
	public boolean isVisited() {
		return visited;
	}
	
	public int getValue() {
		return this.value;
	}

}
