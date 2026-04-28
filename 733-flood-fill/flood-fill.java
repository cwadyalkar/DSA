class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if(originalColor == newColor) return image;
        dfs(image,sr,sc,newColor,originalColor);
        return image;

    }
    public void dfs(int[][] image, int row, int col,int newColor,int originalColor){
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length){
            return;
        }
        if(image[row][col] != originalColor){
            return;
        } 
        image[row][col] = newColor;
        dfs(image,row-1,col,newColor,originalColor);
        dfs(image,row,col+1,newColor,originalColor);
        dfs(image,row+1,col,newColor,originalColor);
        dfs(image,row,col-1,newColor,originalColor);
    }
}