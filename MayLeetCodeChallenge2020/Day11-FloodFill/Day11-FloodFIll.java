/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" 
the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color 
as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), 
and so on. Replace the color of all of the aforementioned pixels with the newColor.
At the end, return the modified image.
Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
*/


/* SIMPLE DFS MOVE IN ALL 4 DIRECTIONS */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int val = image[sr][sc];
        //if new and old colors are the same then just return coz there is no need to change anything
        if(val==newColor)
            return image;
        //from that pixel spread out and change the colors
        dfs(image,rows,cols,sr,sc,val,newColor);
        return image;
        
        
    }
    
    public void dfs(int[][] image,int rows, int cols, int sr, int sc, int val, int newColor){
        if(isSafe(image,val,sr,sc,rows,cols)){
            image[sr][sc]=newColor;//change to the new color
            //recursively recur for the same in all 4 directions
            dfs(image,rows,cols,sr-1,sc,val,newColor);//top
            dfs(image,rows,cols,sr,sc+1,val,newColor);//right
            dfs(image,rows,cols,sr+1,sc,val,newColor);//down
            dfs(image,rows,cols,sr,sc-1,val,newColor);//left
            }
    
    }
    public boolean isSafe(int[][] image,int val, int i,int j,int rows,int cols){
        //checking boundary & also if its the pixel that has to be changed
        return i>=0 && i<rows && j>=0 && j<cols && image[i][j]==val;
    }
}

TC-O(N), where NN is the number of pixels in the image. We might process every pixel
SC-O(N), the size of the implicit call stack when calling dfs.