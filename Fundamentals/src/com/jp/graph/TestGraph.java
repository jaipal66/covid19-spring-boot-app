package com.jp.graph;

public class TestGraph {

	public static void main(String[] args) {
		Graph graph=new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		
		graph.addEdge("A","B", 2);
		graph.addEdge("A","C", 4);
		graph.addEdge("A","D", 6);
		graph.addEdge("B","C", 5);
		graph.addEdge("B","D", 4);
		graph.addEdge("B","E", 3);
		
		System.out.println(graph);
		
		System.out.println(graph.breadthFirstSearch("B"));
		System.out.println(graph.depthFirstSearch("A"));
		System.out.println("Trees : "+graph.countTreesInForest("A"));
	}
}
