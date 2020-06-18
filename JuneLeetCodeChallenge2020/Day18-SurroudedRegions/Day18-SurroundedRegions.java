
/*

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.


*/

class Solution {
    
    public void dfs(char[][] board,int i,int j,int rows,int cols){
        if(i<0 || i>=rows || j<0 || j>=cols)
            return;

        if(board[i][j]=='O'){
            board[i][j]='1';
            dfs(board,i-1,j,rows,cols);
            dfs(board,i,j+1,rows,cols);
            dfs(board,i+1,j,rows,cols);
            dfs(board,i,j-1,rows,cols);
        }
    }
    public void solve(char[][] board) {
        if(board==null || board.length==0)
            return;
        int rows = board.length;
        int cols = board[0].length;
        //for first row and last row
        for(int i=0;i<cols;i++){
            dfs(board,0,i,rows,cols);
            dfs(board,rows-1,i,rows,cols);
        }
        
        //for first col and last col
        for(int i=1;i<rows;i++){
            dfs(board,i,0,rows,cols);
            dfs(board,i,cols-1,rows,cols);
        }
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='1'){
                    board[i][j]='O';
                }
                
            }
        }
    }
}

TC-0(MN)
SC-0(MN)