class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int degree[] = new int[n];
        for(int road[] : roads){
            int u = road[0];
            int v = road[1];
            degree[u]++;
            degree[v]++;
        }
        Arrays.sort(degree);
        long ans = 0;
        for(int i = 0;i < n;i++){
            ans += (long) degree[i] * (i + 1);
            
        }

        return ans;
    }
}