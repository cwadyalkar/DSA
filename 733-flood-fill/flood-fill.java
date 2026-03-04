class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int original = image[sr][sc];
       if(original == color) return image;
        dfs(image,color,sr,sc,original);
        return image;
    }
    public void dfs(int image[][],int color,int i,int j,int original){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != original){
            return;
        }
        image[i][j] = color;
        dfs(image,color,i-1,j,original);
        dfs(image,color,i,j+1,original);
        dfs(image,color,i+1,j,original);
        dfs(image,color,i,j-1,original);

    }

}