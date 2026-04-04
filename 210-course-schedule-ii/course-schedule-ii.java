class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int indegree[] = new int[numCourses];
        int result[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int edge[] : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            indegree[u]++;
            graph.get(v).add(u);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index] = node;
            index++;
            for (int neighbour : graph.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0)
                    queue.offer(neighbour);
            }
        }
        if(index != numCourses) return new int[0];
        return result;
    }
}