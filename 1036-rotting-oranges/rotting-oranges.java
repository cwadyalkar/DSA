class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        int timing = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        int direction[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currDir[] = queue.poll();
                int row = currDir[0];
                int col = currDir[1];

                for (int dir[] : direction) {
                    int newRow = dir[0] + row;
                    int newCol = dir[1] + col;

                    if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] == 1) {
                        queue.offer(new int[] { newRow, newCol });
                        grid[newRow][newCol] = 2;
                        freshCount--;
                    }
                }
            }
            timing++;
        }

        return freshCount == 0 ? timing : -1;
    }
}