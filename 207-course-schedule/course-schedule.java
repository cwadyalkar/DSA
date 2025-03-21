class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int indegre[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];
            adj.get(prerequisite).add(course);
            indegre[course]++;

        }
        for (int i = 0; i < numCourses; i++) {
            if (indegre[i] == 0) {
                queue.offer(i);
            }

        }
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(int neighbour : adj.get(node)){
                indegre[neighbour]--;
                if(indegre[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }

        }

        return count == numCourses;
    }
}