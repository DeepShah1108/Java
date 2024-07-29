package DSA.graph;

import java.util.*;

public class al_apna {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        boolean[] vis = new boolean[V];

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        printGraph(graph);

        bfs(0, graph);

        printAllPaths(0, 2, vis, "");
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
    }

    static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                System.out.println(e.src + " " + e.dest);
            }
            System.out.println();
        }
    }

    static void bfs(int src, ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        vis[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                vis[curr] = true;
                System.out.print(curr + " ");
            }

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                q.add(e.dest);
            }
        }
    }

    static void printAllPaths(int src, int dest, boolean[] vis, String path) {
        if (src == dest) {
            System.out.println(path);
            return;
        }

    }
}
