package com.jp.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

	private Map<Vertex, List<Vertex>> vertecs = new HashMap<Vertex, List<Vertex>>();

	public void addVertex(String label) {
		vertecs.putIfAbsent(new Vertex(label), new ArrayList<>());
	}

	public void removeVertex(String label) {
		Vertex vertex = new Vertex(label);
		vertecs.values().stream().forEach(e -> e.remove(vertex));
		vertecs.remove(new Vertex(label));
	}

	public void addEdge(String source, String destination) {
		Vertex sourceVertex = new Vertex(source);
		Vertex destinationVertex = new Vertex(destination);
		vertecs.get(sourceVertex).add(destinationVertex);
		vertecs.get(destinationVertex).add(sourceVertex);

	}

	public void removeEdge(String source, String destination) {
		Vertex sourceVertex = new Vertex(source);
		Vertex destinationVertex = new Vertex(destination);
		List<Vertex> sourceList = vertecs.get(sourceVertex);
		List<Vertex> destinationList = vertecs.get(destinationVertex);
		if (sourceList != null) {
			sourceList.remove(destinationVertex);
		}
		if (destinationList != null) {
			destinationList.remove(sourceVertex);
		}

	}

	public List<Vertex> getAdjecentVerteces(String label) {
		return vertecs.get(new Vertex(label));
	}

	public static Set<String> depthFirstSearch(Graph graph, String root) {
		Set<String> isVisited = new LinkedHashSet<String>();
		Stack<String> stack = new Stack<String>();
		stack.push(root);
		System.out.println(root);
		while (!stack.isEmpty()) {
			String vertex = stack.pop();
				for (Vertex v : graph.getAdjecentVerteces(vertex)) {
					if (!isVisited.contains(vertex)) {
					stack.push(v.label);
					System.out.println(v.label);
					isVisited.add(vertex);
				}
			}

		}
		return isVisited;
	}

	public static Set<String> breadthFirstSearch(Graph graph, String root) {
		Set<String> isVisited = new LinkedHashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(root);
		System.out.println(root);
		isVisited.add(root);
		while (!queue.isEmpty()) {
			String vertex = queue.poll();
			for (Vertex v : graph.getAdjecentVerteces(vertex)) {
				if (!isVisited.contains(v.label)) {
					queue.add(v.label);
					System.out.println(v.label);
					isVisited.add(v.label);
				}
			}
		}

		return isVisited;
	}

	class Vertex {
		String label;

		Vertex(String label) {
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
	}

	@Override
	public String toString() {
		String result = "";
		Set<Map.Entry<Vertex, List<Vertex>>> allVertex = vertecs.entrySet();
		for (Map.Entry<Vertex, List<Vertex>> v : allVertex) {
			result += v.getKey() + "--> " + v.getValue() + "\n";
		}
		return result;
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("One");
		graph.addVertex("Two");
		graph.addVertex("Three");
		graph.addVertex("Four");
		graph.addVertex("Fifth");
		graph.addEdge("One", "Three");
		graph.addEdge("One", "Two");
		graph.addEdge("Three", "Four");
		graph.addEdge("Two", "Four");
		graph.addEdge("Three", "Fifth");
		graph.addEdge("Two", "Fifth");
		System.out.println("Graph created...");
		System.out.println(graph);
		System.out.println("............................");
		System.out.println(breadthFirstSearch(graph, "One"));
		System.out.println("............................");
		depthFirstSearch(graph,"Two");
	}
}
