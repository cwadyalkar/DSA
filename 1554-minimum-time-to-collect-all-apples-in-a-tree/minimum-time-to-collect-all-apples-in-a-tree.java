class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return dfs(0, -1, adjList, hasApple);
    }

    public int dfs(int node, int parent, List<List<Integer>> adjList, List<Boolean> hasApple) {
        int totalTime = 0;

        for (int child : adjList.get(node)) {
            if (child == parent) continue;

            int childTime = dfs(child, node, adjList, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }
        }

        return totalTime;
    }
}