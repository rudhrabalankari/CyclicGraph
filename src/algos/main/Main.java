package algos.main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	private final int vertices;
	private static int[][] adjacency_matrix;
	private static int[][] adjacency_matrix2;

	public Main(int v) {
		vertices = v;
		adjacency_matrix = new int[vertices + 1][vertices + 1];
		adjacency_matrix2 = new int[vertices + 1][vertices + 1];
	}

	public void makeEdge(int to, int from, int edge) {
		try {
			adjacency_matrix[to][from] = edge;
			adjacency_matrix2[to][from] = 1;
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("The vertices does not exists");
		}
	}

	public int getEdge(int to, int from) {
		try {
			return adjacency_matrix[to][from];
		} catch (ArrayIndexOutOfBoundsException index) {
			System.out.println("The vertices does not exists");
		}
		return -1;
	}

	public static void main(String args[]) {
		int v, e, count = 1, to = 0, from = 0, weight = 0;
		Scanner sc = new Scanner(System.in);
		Main graph;
		CheckCycle graph2;
		TopologicalOrder graph3;

		System.out.println("Enter the number of vertices: ");
		v = sc.nextInt();
		graph = new Main(v);
		graph2 = new CheckCycle();
		System.out.println("Enter the number of edges: ");
		e = sc.nextInt();

		while (count <= e) {
			System.out.println("Enter the edges: to from weight");
			to = sc.nextInt();
			from = sc.nextInt();
			weight = sc.nextInt();
			graph.makeEdge(to, from, weight);
			// 4graph2.addEdge(to-1, from-1);
			count++;
		}
		System.out.println("The adjacency matrix for the given graph is: ");
		System.out.print("  ");
		for (int i = 1; i <= v; i++)
			System.out.print(i + " ");
		System.out.println();

		for (int i = 1; i <= v; i++) {
			System.out.print(i + " ");
			for (int j = 1; j <= v; j++)
				System.out.print(graph.getEdge(i, j) + " ");
			System.out.println();
		}
		System.out.println(Arrays.deepToString(adjacency_matrix2));
		graph2.dfs(adjacency_matrix2, 1);
		if (graph2.flag) {
			System.out.println("Graph contains cycle");
		} else {
			System.out.println("Graph doesn't contain cycle and the topological order is:");
			graph3 = new TopologicalOrder(v);
			graph3.topologicalSort();
		}

		sc.close();

		System.out.println("======================");

		SingleSourceShortestPath sp = new SingleSourceShortestPath();
		sp.dijkstra(adjacency_matrix, 1);
		sp.printMatrixTree();

	}

}
