class Solution {
    static class Cell {
        int x, y, effort;

        public Cell(int x, int y, int effort) {
            this.x = x;
            this.y = y;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
         int row = heights.length;
        int col = heights[0].length;

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int[][] dist = new int[row][col];

        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.effort));
        queue.offer(new Cell(0, 0, 0));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (x == row - 1 && y == col - 1) {
                return current.effort;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < row && ny < col) {
                    int newEffort = Math.max(current.effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (newEffort < dist[nx][ny]) {
                        dist[nx][ny] = newEffort;
                        queue.offer(new Cell(nx, ny, newEffort));
                    }
                }
            }
        }

        return 0;

    }
}