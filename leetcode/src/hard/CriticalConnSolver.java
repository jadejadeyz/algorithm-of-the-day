package hard;

import java.util.*;

public class CriticalConnSolver {
    public int time = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (n == 1)
            return new ArrayList<>();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> edge: connections) {
            graph.putIfAbsent(edge.get(0), new ArrayList<>());
            graph.putIfAbsent(edge.get(1), new ArrayList<>());
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        boolean[] states = new boolean[n];
        int[] dtime = new int[n];
        int[] lowtime = new int[n];
        int[] degree = new int[n];
        int[] parent = new int[n];
        boolean[] isRoot = new boolean[n];

        for (int i = 0; i < n; i++) {
            states[i] = false;
            dtime[i] = 0;
            lowtime[i] = 0;
            degree[i] = 1;
            isRoot[i] = false;
            parent[i] = -1;
        }

        Set<List<Integer>> critical = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (states[i] == false) {// white, undiscovered
                degree[i] = 0;
                isRoot[i] = true;
                dfs(graph, i, degree, dtime, lowtime, states, parent);
            }
        }

        for (int i = 0; i < n; i++) {
            if (isArticulation(graph, i, degree, lowtime, dtime, parent, isRoot)) {
                for (Integer u: graph.get(i)) {
                    if (parent[u] == i && (isArticulation(graph, u, degree, lowtime, dtime, parent, isRoot) || graph.get(u).size() == 1)) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(Math.min(i, u));
                        pair.add(Math.max(i, u));
                        critical.add(pair);
                    }
                }
            }
        }

        List<List<Integer>> criticalConns = new ArrayList<>();
        for (List<Integer> edge: critical)
            criticalConns.add(edge);

        return criticalConns;
    }

    public boolean isArticulation(Map<Integer, List<Integer>> graph, int v, int[] degree,
                                  int[] lowtime, int[] dtime, int[] parent, boolean[] isRoot) {
        if (isRoot[v])
            return degree[v] > 1;

        for (Integer u: graph.get(v)) {
            if (parent[u] == v && lowtime[u] >= dtime[v])
                return true;
        }
        return false;
    }

    public void dfs(Map<Integer, List<Integer>> g, int v, int[] degree,
                    int[] dtime, int[] lowtime, boolean[] states, int[] parent) {
        time++;
        dtime[v] = time;
        states[v] = true; // be grayed
        for (Integer u: g.get(v)) {
            if (states[u] == false) { // u is v's descendent;
                parent[u] = v;
                dfs(g, u, degree, dtime, lowtime, states, parent);
                degree[v]++;
            }
        }
        if (degree[v] == 1) { // DF tree's leaf nodes
            for (Integer u : g.get(v)) {
                if (u != parent[v] && dtime[u] < dtime[v]) // track back edges
                    lowtime[v] = Math.min(dtime[u], dtime[v]);
            }
            if (lowtime[v] == 0)
                lowtime[v] = dtime[v];
        }
        else {
            lowtime[v] = dtime[v];
            for (Integer u: g.get(v)) {
                if (parent[u] == v) { // tree edge, check child nodes
                    lowtime[v] = Math.min(lowtime[u], lowtime[v]);
                }
                else if (u != parent[v] && dtime[u] < dtime[v]){ // back edge
                    lowtime[v] = Math.min(dtime[u], lowtime[v]);
                }
            }
        }

        time++;
    }
}
