package algos.main;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SingleSourceShortestPath {

	ArrayList<String> sssp = new ArrayList<>();
	int[][] graph;
	private int src;
	static int V;

	int minDistance(int dist[], Boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	void constructPath(int parent[], int j) {
		if (parent[j] == -1)
			return;

		constructPath(parent, parent[j]);
		sssp.add(j + "");

	}

	void constructSolution(int dist[], int n, int parent[]) {
		int src = this.src;
		for (int i = 1; i < V; i++) {
			constructPath(parent, i);
			sssp.add(",");
		}
	}

	void dijkstra(int graph[][], int src) {
		SingleSourceShortestPath.V = graph.length;
		this.src = src;
		this.graph = graph;
		int dist[] = new int[V];
		Boolean sptSet[] = new Boolean[V];
		int parent[] = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			parent[0] = -1;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet);

			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					parent[v] = u;
					dist[v] = dist[u] + graph[u][v];

				}
		}

		constructSolution(dist, V, parent);
	}

	public void printMatrixTree() {
		int[][] matrixTree = new int[V][V];

		for (int i = 0; i < sssp.size() - 1; i++) {

			if (sssp.get(i).equals(",") || sssp.get(i + 1).equals(",")) {

				continue;

			} else {
				matrixTree[Integer.parseInt(sssp.get(i))][Integer
						.parseInt(sssp.get(i + 1))] = this.graph[Integer.parseInt(sssp.get(i))][Integer
								.parseInt(sssp.get(i + 1))];
			}
		}

		System.out.println(" Shortest Path Tree ");

		for (int i = 0; i < matrixTree.length; i++) {
			System.out.print("\n");
			for (int j = 0; j < matrixTree.length; j++)

				System.out.print(matrixTree[i][j] + "  ");

		}

	}

}
