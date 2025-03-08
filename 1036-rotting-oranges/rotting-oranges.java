class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length; 
        int m = grid[0].length; 
        int freshCount = 0; 
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (freshCount == 0) return 0;

        int time = 0;
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; 

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] rottenLoc = queue.poll();
                int row = rottenLoc[0];
                int col = rottenLoc[1];

                for (int[] dir : directions) {
                    int nrow = row + dir[0];
                    int ncol = col + dir[1];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                        queue.offer(new int[]{nrow, ncol});
                        grid[nrow][ncol] = 2; 
                        freshCount--; 
                        rotted = true; 
                    }
                }
            }

            if (rotted) time++;
        }

        return (freshCount == 0) ? time : -1;
    }
}