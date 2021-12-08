import java.util.Scanner;

public class UndirectedGraph {
    public static void main(String[] args) {
        // create a scanner
        Scanner sc = new Scanner(System.in);

        // ask the user to input pair of vertices to the edges of undirected graph
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();
        
        // compute the degree of each vertex
        int[] degree = new int[vertices];
        for (int i = 0; i < edges; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            degree[v1]++;
            degree[v2]++;
        }

        // print the degree of each vertex
        for (int i = 0; i < vertices; i++) {
            System.out.println("Degree of vertex " + i + " is " + degree[i]);
        }

        // close the scanner
        sc.close();

        // sample input and output for the above problem:
        // Enter the number of vertices: 5
        // Enter the number of edges: 6
        // 0 1
        // 0 2
        // 0 3
        // 1 2
        // 1 3
        // 2 3
        // Degree of vertex 0 is 3
        // Degree of vertex 1 is 3
        // Degree of vertex 2 is 3
        // Degree of vertex 4 is 0
    }
}