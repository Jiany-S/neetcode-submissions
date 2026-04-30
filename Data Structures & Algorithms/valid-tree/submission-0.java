class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // must have exactly n-1 edges

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, graph, visited)) {
            return false;
        }

        return visited.size() == n; // must visit all nodes
    }

    private boolean dfs(int node, int parent, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(node)) return false; // cycle detected
        visited.add(node);

        for (int nei : graph.get(node)) {
            if (nei == parent) continue; // skip the edge back to parent
            if (!dfs(nei, node, graph, visited)) {
                return false;
            }
        }

        return true;
    }
}
