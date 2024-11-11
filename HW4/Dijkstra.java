
//DO NOT CHANGE ANY EXISTING CODE IN THIS FILE
//DO NOT CHANGE THE NAMES OF ANY EXISTING FUNCTIONS
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;

class Pair implements Comparable<Pair> {
	int vertex;
	int dist;

	public Pair(int vertex, int dist) {
		this.vertex = vertex;
		this.dist = dist;
	}

	@Override
	public int compareTo(Pair node2) {
		if (this.dist < node2.dist)
			return -1;
		if (this.dist > node2.dist)
			return 1;
		return 0;
	}
}

public class Dijkstra {
	private static ArrayList<ArrayList<Pair>> buildAjacencyList(int[][] mat, int n) {
		ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>(n + 1);
		for (int i = 0; i < n + 1; i++) {
			adjList.add(new ArrayList<Pair>());
		}

		for (int i = 0; i < mat.length; i++) {
			adjList.get(mat[i][0]).add(new Pair(mat[i][1], mat[i][2]));
			adjList.get(mat[i][1]).add(new Pair(mat[i][0], mat[i][2]));
		}
		return adjList;
	}

	public static int[][] Dijkstra_alg(int n, int e, int[][] mat, int s) {
		// create adjacency list first
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		ArrayList<ArrayList<Pair>> adjList = buildAjacencyList(mat, n);
		int[] dist = new int[n + 1];
		int[] visited = new int[n + 1];
		int[] usp = new int[n + 1];
		int[] parent = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = 0;
			usp[i] = 1;
		}

		dist[s] = 0;
		parent[s] = -1;
		pq.add(new Pair(s, 0));

		while (!pq.isEmpty()) {
			Pair p = pq.remove();
			ArrayList<Pair> adjacents = adjList.get(p.vertex);
			visited[p.vertex] = 1;
			for (int i = 0; i < adjacents.size(); i++) {
				Pair v = adjacents.get(i);
				if (visited[v.vertex] != 1) {
					if (dist[p.vertex] + v.dist < dist[v.vertex]) {
						dist[v.vertex] = dist[p.vertex] + v.dist;
						parent[v.vertex] = p.vertex;
						pq.add(new Pair(v.vertex, dist[v.vertex]));
					} else if (dist[p.vertex] + v.dist == dist[v.vertex] && parent[v.vertex] != p.vertex) {
						usp[v.vertex] = 0;
					}
				}
			}
		}

		int[][] ans = new int[n][2];
		for (int i = 0; i < n; i++) {
			ans[i][0] = dist[i + 1];
			ans[i][1] = usp[i + 1];
		}
		return ans;
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(DijkstraTest.class);
		if (result.wasSuccessful())
			System.out.println("All test cases passed");

		for (Failure failure : result.getFailures()) {
			System.out.println("failure : " + failure.toString());
		}
	}
}