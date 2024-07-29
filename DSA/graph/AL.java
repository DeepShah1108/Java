package DSA.graph;

import java.util.*;

public class AL {
    public static void main(String[] args) {
        int V = 4;
        boolean vis[] = new boolean[V];
        ArrayList[] graph = new ArrayList[V + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        insert(0, 1, graph);
        insert(0, 2, graph);
        insert(0, 3, graph);
        insert(1, 2, graph);

        printGraph(graph);

        System.out.println("BFS");
        bfs(0, V, graph);

        System.out.println();

        System.out.println("DFS");
        dfs(V, 0, graph);

        System.out.println("All Paths");
        printAllPaths(0, 2, vis, graph);
    }

    public static void insert(int src, int dest, ArrayList[] graph) {
        graph[src].add(dest);
        graph[dest].add(src);
    }

    static void printGraph(ArrayList[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i);
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(" -> " + graph[i].get(j));
            }
            System.out.println();
        }
    }

    static void dfsUtil(int src, boolean[] vis, ArrayList[] graph) {
        vis[src] = true;
        System.out.print(src + " ");

        Iterator<Integer> it = graph[src].listIterator();

        while (it.hasNext()) {
            int n = it.next();
            if (!vis[n]) {
                dfsUtil(n, vis, graph);
            }
        }
    }

    static void dfs(int V, int src, ArrayList[] graph) {
        boolean[] vis = new boolean[V];
        dfsUtil(src, vis, graph);
    }

    static void bfs(int src, int V, ArrayList[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];

        vis[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            Iterator<Integer> it = graph[curr].listIterator();

            while (it.hasNext()) {
                int n = it.next();
                if (!vis[n]) {
                    vis[n] = true;
                    q.add(n);
                }
            }
        }
    }

    static void printAllPaths(int src, int dest, boolean[] vis, ArrayList<Integer>[] graph) {
        ArrayList<Integer> path = new ArrayList<>();

        path.add(src);

        printAllPAthsUtils(src, dest, vis, path, graph);
    }

    static void printAllPAthsUtils(int src, int dest, boolean[] vis, ArrayList<Integer> path,
            ArrayList<Integer>[] graph) {
        if (src == dest) {
            System.out.println(path);
            return;
        }

        vis[src] = true;

        for (Integer i : graph[src]) {
            if (!vis[src]) {
                path.add(i);
                printAllPAthsUtils(i, dest, vis, path, graph);
                path.remove(i);
            }
        }

        vis[src] = false;
    }
}
