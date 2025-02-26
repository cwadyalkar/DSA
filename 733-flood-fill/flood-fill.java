class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int color = image[sr][sc];


        if(color != newColor){
            dfs(image,rows,cols,sr,sc,color,newColor);

        }
        return image;
    }

    public void dfs(int[][]image,int rows,int cols, int sr, int sc, int color,int newColor){
        if(sr < 0 || sr >= rows || sc < 0 || sc >= cols || image[sr][sc] != color){
            return ;
        }
        image[sr][sc] = newColor;
        dfs(image,rows,cols,sr+1,sc,color,newColor);
        dfs(image,rows,cols,sr-1,sc,color,newColor);
        dfs(image,rows,cols,sr,sc+1,color,newColor);
        dfs(image,rows,cols,sr,sc-1,color,newColor);

    }
}