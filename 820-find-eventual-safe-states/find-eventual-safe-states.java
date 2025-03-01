class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int n = graph.length;
        for (int i = 0; i < n; i++) {
            if (dfs(graph, i, map)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean dfs(int[][] graph, int node, HashMap<Integer, Boolean> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        map.put(node, false);

        for (int neighbour : graph[node]) {
            if (!dfs(graph, neighbour, map)) {
                return false;
            }
        }
        map.put(node, true);
        return true;
    }
}