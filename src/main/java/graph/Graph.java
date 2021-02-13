package graph;

import java.util.ArrayList;
import java.util.LinkedList;

class Graph {

    // A utility function to add an edge in an
    // undirected graph
    static void addEdge(ArrayList<LinkedList<Integer>> adj,
                        int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(ArrayList<LinkedList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex " + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    // Driver Code
    public static void main(String[] args) {
   /*     // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<LinkedList<Integer>> adj
                = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);*/
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7,8, 9, 10}, 0, 10, 6));
    }

    public static int binarySearch(int[] elements, int low, int high, int target) {
        if (low > high)
            return -1;
        int mid = low + ((high - low) / 2);
        if (target == elements[mid]) {
            return mid;
        } else if (target > elements[mid]) {
            binarySearch(elements, mid + 1, high, target);
        } else if (target < elements[mid]) {
            binarySearch(elements, low, mid - 1, target);
        }
        return -1;
    }
}
