class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int direction[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else{
                    mat[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()){
            int size = queue.size();
           int currDir[] = queue.poll();
                int currRow = currDir[0];
                int currCol = currDir[1];
                for(int dir[] : direction){
                    int newRow = dir[0] + currRow;
                    int newCol = dir[1] + currCol;

                    if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && mat[newRow][newCol] == -1){
                        mat[newRow][newCol] = mat[currRow][currCol] + 1;
                        queue.offer(new int[]{newRow,newCol});
                    }
                }
        }
        return mat;
    }
}