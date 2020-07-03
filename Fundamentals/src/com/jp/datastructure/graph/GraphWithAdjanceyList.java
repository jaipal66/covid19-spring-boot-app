package com.jp.datastructure.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GraphWithAdjanceyList {

	private Map<Vertex, List<Edge>> vertecs = new TreeMap<Vertex, List<Edge>>(new VertexComparator());

	public void addVertex(String label) {
		vertecs.putIfAbsent(new Vertex(label), new LinkedList<Edge>());
	}

	static class Vertex  {
		String label;

		public Vertex(String label) {
			this.label = label;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			int hash = 31;
			hash = hash * this.label.hashCode();
			return hash;
		}

		@Override
		public String toString() {
			return this.label;
		}

		/*@Override
		public int compareTo(Vertex o) {
			return (this.label < o.label) ? -1 : (this.label > o.label) ? 1 : 0;
		}*/
	}

	public class VertexComparator implements Comparator<Vertex> {
		@Override
		public int compare(Vertex o1, Vertex o2) {
			return o1.label.compareTo(o2.label);
		}

	}

	static class Edge {
		String start;
		int weight;

		public Edge(String start, int weight) {
			this.start = start;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(" + start + "," + weight + ")";
		}
	}

	@Override
	public String toString() {
		String result = "";
		Set<Map.Entry<Vertex, List<Edge>>> allVertex = vertecs.entrySet();
		for (Map.Entry<Vertex, List<Edge>> v : allVertex) {
			result += v.getKey() + " --> " + v.getValue() + "\n";
		}
		return result;
	}

	public void addEdge(String start, String end, int weight) {
		Vertex sourceVertex = new Vertex(start);
		Vertex destinationVertex = new Vertex(end);
		vertecs.get(sourceVertex).add(new Edge(end, weight));
		vertecs.get(destinationVertex).add(new Edge(start, weight));
	}

	public static void main(String[] args) {

		GraphWithAdjanceyList graph = new GraphWithAdjanceyList();
		graph.addVertex("Jaipal");
		graph.addVertex("Deepak");
		graph.addVertex("Vaibhav");
		graph.addVertex("Reshma");
		graph.addVertex("Deepika");
		graph.addEdge("Jaipal", "Vaibhav", 5);
		graph.addEdge("Jaipal", "Deepak", 6);
		graph.addEdge("Deepak", "Deepika", 8);
		graph.addEdge("Deepak", "Vaibhav", 9);
		graph.addEdge("Reshma", "Deepika", 10);
		graph.addEdge("Reshma", "Deepak", 11);
		System.out.println("Graph created...");
		System.out.println(graph);
	}
}
