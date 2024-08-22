package graph;


	import java.util.*;
	public class Graph {

	    private int vertices;
	    private LinkedList<Integer>[] adjList;

	    // Constructor
	    public Graph(int vertices) {
	        this.vertices = vertices;
	        adjList = new LinkedList[vertices];
	        for (int i = 0; i < vertices; i++) {
	            adjList[i] = new LinkedList<>();
	        }
	    }

	    // Add an edge to the graph
	    public void addEdge(int source, int destination) {
	        adjList[source].add(destination);
	        adjList[destination].add(source);  // Uncomment this line for an undirected graph
	    }

	    // BFS traversal from a given source
	    public void BFS(int start) {
	        boolean[] visited = new boolean[vertices];
	        LinkedList<Integer> queue = new LinkedList<>();

	        visited[start] = true;
	        queue.add(start);

	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            System.out.print(node + " ");

	            for (int neighbor : adjList[node]) {
	                if (!visited[neighbor]) {
	                    visited[neighbor] = true;
	                    queue.add(neighbor);
	                }
	            }
	        }
	    }

	    // DFS traversal from a given source
	    public void DFS(int start) {
	        boolean[] visited = new boolean[vertices];
	        DFSUtil(start, visited);
	    }

	    // Helper method for DFS
	    private void DFSUtil(int node, boolean[] visited) {
	        visited[node] = true;
	        System.out.print(node + " ");

	        for (int neighbor : adjList[node]) {
	            if (!visited[neighbor]) {
	                DFSUtil(neighbor, visited);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Graph graph = new Graph(5);

	        graph.addEdge(0, 1);
	        graph.addEdge(0, 4);
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 3);
	        graph.addEdge(1, 4);
	        graph.addEdge(2, 3);
	        graph.addEdge(3, 4);

	        System.out.println("BFS Traversal:");
	        graph.BFS(0);

	        System.out.println("\nDFS Traversal:");
	        graph.DFS(0);
	    }
	}


