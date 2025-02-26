class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    public void dfs(int[][] isConnected, boolean visited[], int node) {
        visited[node] = true;
        for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {
            if(isConnected[node][neighbour] == 1 && !visited[neighbour]){
                    dfs(isConnected,visited,neighbour);
            }
        }

    }
}