class Solution {
    public int findJudge(int n, int[][] trust) {
        int len = trust.length;
        if (len < n - 1) return -1; 
        
        int inDegree[] = new int[n + 1];
        int outDegree[] = new int[n + 1];

        for (int i = 0; i < len; i++) {
            int a = trust[i][0]; 
            int b = trust[i][1];

            outDegree[a]++;
            inDegree[b]++; 
        }

        for (int i = 1; i <= n; i++) { 
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1; 
    }
}
