package com.jp.practice;

import java.util.Stack;

public class Graph {

	private int adjecentMatrix[][];
	private int numberOfVertices;
	private static final int MATRIX_SIZE = 10;
	private Vertex vertices[];

	Graph() {
		this.numberOfVertices = 0;
		vertices = new Vertex[MATRIX_SIZE];
		adjecentMatrix = new int[MATRIX_SIZE][MATRIX_SIZE];
		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				adjecentMatrix[i][j] = 0;
			}
		}

	}

	public void addEdge(int source, int destination) {
		adjecentMatrix[source][destination] = 1;
		adjecentMatrix[destination][source] = 1;
	}

	public void addVertex(char label) {
		vertices[numberOfVertices++] = new Vertex(label);
	}

	public int getUnvisitedVertices(int index) {

		for (int i = 0; i < MATRIX_SIZE; i++) {
			if (adjecentMatrix[index][i] == 1 && vertices[i].wasVisted == false) {
				return i;
			}
		}

		return -1;
	}

	public void depthFirstSearch() {
		Stack stack = new Stack();
		vertices[0].wasVisted = true;
		System.out.print(vertices[0].label + " ");
		stack.push(0);
		while (!stack.isEmpty()) {
			int adj = getUnvisitedVertices((int) stack.peek());
			if (adj == -1) {
				stack.pop();
			} else {
				vertices[adj].wasVisted = true;
				System.out.print(vertices[adj].label + " ");
				stack.push(adj);
			}
		}

	}

	static class Vertex {
		char label;
		boolean wasVisted;

		Vertex(char label) {
			this.label = label;
			this.wasVisted = false;
		}
	}
}
