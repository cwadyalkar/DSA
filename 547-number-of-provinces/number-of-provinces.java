class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                dfs(i,visited,isConnected);
                provinces++;
            }
        }
        return provinces;

    }
    public void dfs(int src, boolean visited[],int[][] isConnected){
        visited[src] = true;
        for(int i = 0;i < isConnected.length;i++){
            if(isConnected[src][i] == 1 && !visited[i]){
                dfs(i,visited,isConnected);
            }
        }
        
    }
}