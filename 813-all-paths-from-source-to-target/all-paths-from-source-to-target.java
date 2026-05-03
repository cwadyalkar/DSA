class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int src = 0;
        int target = graph.length - 1;
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(src);
        dfs(graph, path, ansList, src, target);
        return ansList;
    }

    public void dfs(int graph[][], List<Integer> path, List<List<Integer>> ansList, int src, int target) {
        if (src == target) {
            ansList.add(new ArrayList<>(path));
            return;
        }
        for (int neighbour : graph[src]) {
            path.add(neighbour);
            dfs(graph, path, ansList, neighbour, target);
            path.remove(path.size() - 1);
        }
    }
}