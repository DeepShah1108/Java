package DSA.graph;

public class FloydWarshallAlgorithm {

    public static void main(String[] args) {
        int n = 5, distanceThreshold = 2;
        int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
        // floydWarshall(n, edges, distanceThreshold);
        System.out.println(floydWarshall(n, edges, distanceThreshold));
    }

    static int floydWarshall(int n, int[][] graph, int distanceThreshold) {
        int[][] dist = new int[n][n];
        int m = graph.length;

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                dist[i][j] = 10001;
                dist[i][i] = 0;
            }
        }

        for (int i = 0; i < graph.length; i++) {
            int src = graph[i][0];
            int dest = graph[i][1];
            int wt = graph[i][2];
            dist[src][dest] = wt;
            dist[dest][src] = wt;
        }

        printGraph(dist);

        for (int middle = 0; middle < n; middle++) {
            for (int src = 0; src < n; src++) {
                for (int dest = 0; dest < n; dest++) {
                    dist[src][dest] = Math.min(dist[src][dest], dist[src][middle] + dist[middle][dest]);
                }
            }
        }

        System.out.println();
        printGraph(dist);

        int totalCity = n;
        int cityNo = -1;

        for (int src = 0; src < n; src++) {
            int count_src = 0;
            for (int dest = 0; dest < n; dest++) {
                if (dist[src][dest] <= distanceThreshold) {
                    count_src++;
                }
            }

            if (count_src <= totalCity) {
                totalCity = count_src;
                cityNo = src;
            }
        }

        return cityNo;
    }

    static void printGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }

            System.out.println();
        }
    }

    // static void floydWarshall(int n, int[][] edges, int distanceThreshold) {

    // }
}
