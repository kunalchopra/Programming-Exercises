package com.kchopra.github.solutions.Graphs;
/**
 * @author kunalchopra
 */
import com.kchopra.github.solutions.Graphs.*;

public class Tester {

	public static void main(String[] args) {
		
		Graph myGraph = new Graph();
		
		myGraph.addVertex(2);
		myGraph.addVertex(3);
		myGraph.addVertex(5);
		myGraph.addVertex(8);
		myGraph.addVertex(6);
		myGraph.addVertex(10);
		
		myGraph.addEdge(2, 3);
		myGraph.addEdge(3, 5);
		myGraph.addEdge(2, 5);
		myGraph.addEdge(5, 8);
		myGraph.addEdge(5, 6);
		myGraph.addEdge(6, 10);
		myGraph.addEdge(8, 10);

		// should visit 5 once
		System.out.println(myGraph.dfs(2, 8));//should find
		myGraph.unVisitVertices();
		System.out.println(myGraph.dfs(5, 10));//different origin point; should find
		myGraph.unVisitVertices();
		System.out.println(myGraph.dfs(2, 12));//should not find
	}

}
