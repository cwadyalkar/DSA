class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean visited[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int courses[] : prerequisites) {
            int u = courses[0];
            int v = courses[1];
            graph.get(v).add(u);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(graph, i, visited, recStack)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> graph, int node, boolean visited[], boolean recStack[]) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(graph, neighbour, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbour]) {
                return true;
            }
        }
        recStack[node] = false;
        return false;

    }
}