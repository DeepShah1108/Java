package DSA.graph;

public class AM {
    public static void main(String[] args) {
        int V = 6;
        int[][] graph = new int[V + 1][V + 1];
        insert(5, 3, graph);
        printGraph(graph);
    }

    static void insert(int src, int dest, int[][] graph) {
        graph[src][dest] = 1;
        graph[dest][src] = 1;
    }

    static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }
}
