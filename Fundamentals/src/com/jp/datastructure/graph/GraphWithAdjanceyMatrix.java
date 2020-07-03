package com.jp.datastructure.graph;

import java.util.LinkedList;
import java.util.List;

public class GraphWithAdjanceyMatrix {

	private List<Edge> edges[];
	public GraphWithAdjanceyMatrix(int totalVertex) {
		edges = new LinkedList[totalVertex];
		for (int i = 0; i < totalVertex; i++) {
			edges[i] = new LinkedList<Edge>();
		}
	}

	static class Vertex{
		String label;
		public Vertex() {
			this.label=label;
		}
	}
	static class Edge {
		int start;
		int weight;

		public Edge(int start, int weight) {
			this.start = start;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(" +start + "," + weight+")";
		}
	}

	@Override
	public String toString() {
		String result="";
		for(int i=0;i<edges.length;i++) {
			result+=i+" --> "+edges[i]+"\n";
		}
		return result;
	}
	public void addEdge(int start,int end,int weight) {
		edges[start].add(0,new Edge(end, weight));
	}
	public static void main(String[] args) {
		
		GraphWithAdjanceyMatrix graph=new GraphWithAdjanceyMatrix(6);
		graph.addEdge(0, 1, 12);
		graph.addEdge(0, 2, 5);
		graph.addEdge(1, 2, 12);
		graph.addEdge(1, 3, 5);
		graph.addEdge(2, 4, 12);
		graph.addEdge(2, 5, 5);
		graph.addEdge(3, 5, 12);
		graph.addEdge(3, 4, 5);
		graph.addEdge(3, 6, 12);
		graph.addEdge(5, 6, 5);
		graph.addEdge(3, 5, 12);
		graph.addEdge(4, 3, 5);
		graph.addEdge(4, 5, 12);
		graph.addEdge(4, 6, 5);
		System.out.println(graph);
	}
}
