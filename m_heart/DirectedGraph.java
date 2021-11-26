import java.util.Scanner;

public class DirectedGraph {
    public static void main(String[] args) {
        // create a scanner
        Scanner sc = new Scanner(System.in);

        // ask the user to input pair of vertices to the edges of directed graph
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        // compute for the in-degree and out-degree of each vertex
        int[] inDegree = new int[vertices];
        int[] outDegree = new int[vertices];
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter the edge: ");
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            inDegree[v2]++;
            outDegree[v1]++;
        }

        // display the in-degree of each vertex
        System.out.println("In-degree of each vertex: ");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + ": " + inDegree[i]);
        }

        // display the out-degree of each vertex
        System.out.println("Out-degree of each vertex: ");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + ": " + outDegree[i]);
        }

        // close the scanner
        sc.close();

        // sample input for directed graph:
        // In-degree of each vertex: 5
        // Out-degree of each vertex: 6
        // 0 1
        // 0 2
        // 1 2
        // 2 3
        // 3 4
        // 4 0

        // sample output:
        // In-degree of each vertex:
        // 0: 1
        // 1: 1
        // 2: 2
        // 3: 1
        // 4: 1
        // Out-degree of each vertex:
        // 0: 2
        // 1: 1
        // 2: 1
        // 3: 1
        // 4: 1
    }
}