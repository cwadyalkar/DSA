class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        int indegre[] = new int[numCourses];
        int order[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());

        }
        for (int pre[] : prerequisites) {
            int courses = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(courses);
            indegre[courses]++;

        }
        for (int i = 0; i < numCourses; i++) {
            if (indegre[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[count++] = node;

            for (int neighbour : adj.get(node)) {
                indegre[neighbour]--;
                if (indegre[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return count == numCourses ? order : new int[0];

    }
}