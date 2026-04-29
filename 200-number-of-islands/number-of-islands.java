class Solution {
    int island = 0;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && visited[i][j] == false){
                    dfs(grid,visited,i,j);
                    island++;
                }
            }
        }
        return island;

    }

    public void dfs(char[][] grid, boolean visited[][], int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0'
                || visited[row][col] == true) {
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row - 1, col);
        dfs(grid, visited, row, col + 1);
        dfs(grid, visited, row + 1, col);
        dfs(grid, visited, row, col - 1);

    }
}