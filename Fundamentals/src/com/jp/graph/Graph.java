package com.jp.graph;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Graph {

	private Map<Vertex, List<Edge>> vertices = new TreeMap<Vertex, List<Edge>>(new VertexComparator());

	public void addVertex(String name) {
		vertices.putIfAbsent(new Vertex(name), new LinkedList<Edge>());
	}

	public void addEdge(String start, String end, int weight) {
		Vertex source = new Vertex(start);
		Vertex destination = new Vertex(end);
		vertices.get(source).add(new Edge(end, weight));
		vertices.get(destination).add(new Edge(start, weight));
	}

	class VertexComparator implements Comparator<Vertex> {
		@Override
		public int compare(Vertex first, Vertex second) {
			return first.label.compareTo(second.label);
		}
	}

	static class Vertex {
		String label;

		Vertex(String label) {
			this.label = label;
		}

		@Override
		public boolean equals(Object vertex) {
			if (vertex == null)
				return false;
			else
				return true;
		}

		public int hashCode() {
			int prime = 31;
			prime = prime * 31 + this.label.hashCode();
			return prime;
		}

		@Override
		public String toString() {
			return this.label;
		}
	}

	static class Edge {
		String source;
		int weight;

		Edge(String source, int weight) {
			this.source = source;
			this.weight = weight;
		}

		public String toString() {
			String result;
			result = "( " + this.source + " " + this.weight + " )";
			return result;
		}
	}

	@Override
	public String toString() {
		String result = "";
		for (Map.Entry<Vertex, List<Edge>> entry : vertices.entrySet()) {
			result += entry.getKey() + " --> " + entry.getValue() + "\n";
		}
		return result;
	}

	public List<Edge> getAdjecentEdges(String label) {
		return vertices.get(new Vertex(label));
	}

	public Set<String> breadthFirstSearch(String label) {
		Set<String> isVisited = new LinkedHashSet<>();
		Queue<String> queue = new LinkedList<>();

		queue.add(label);
		System.out.println(label);
		isVisited.add(label);
		while (!queue.isEmpty()) {
			String temp = queue.poll();
			for (Edge vertex : this.getAdjecentEdges(temp)) {
				
				if (!isVisited.contains(vertex.source)) {
					queue.add(vertex.source);
					System.out.println(vertex.source);
					isVisited.add(vertex.source);
				}
			}
		}
		return isVisited;
	}

	public Set<String> depthFirstSearch(String label) {
		Set<String> isVisited = new LinkedHashSet<>();
		Stack<String> stack = new Stack<String>();
		stack.push(label);
		System.out.println(label);
		isVisited.add(label);
		while (!stack.isEmpty()) {
			String temp = stack.pop();
			for (Edge edge : this.getAdjecentEdges(temp)) {
				if (!isVisited.contains(edge.source)) {
					stack.push(edge.source);
					System.out.println(edge.source);
					isVisited.add(edge.source);
				}
			}
		}
		return isVisited;

	}

	public int countTreesInForest(String label) {
		int count = 0;
		Set<String> isVisited = new LinkedHashSet<>();
		Stack<String> stack = new Stack<String>();
		stack.push(label);
		isVisited.add(label);
		while (!stack.isEmpty()) {
			String temp = stack.pop();
			for (Edge edge : this.getAdjecentEdges(temp)) {
				if (!isVisited.contains(edge.source)) {
					stack.push(edge.source);
					isVisited.add(edge.source);
					count++;
				}
			}
		}
		
		return count;
	}
}
