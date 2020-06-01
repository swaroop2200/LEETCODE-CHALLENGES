/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.
 
Example 1:
https://assets.leetcode.com/uploads/2019/10/15/untitled-diagram-2.jpg
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:
https://assets.leetcode.com/uploads/2019/10/09/untitled-diagram-1.jpg
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 
Constraints:
1. 2 <= coordinates.length <= 1000
2. coordinates[i].length == 2
3. -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
4. coordinates contains no duplicate point.
   Hide Hint #1  
If there're only 2 points, return true.
 
   Hide Hint #2  
Check if all other points lie on the line defined by the first 2 points.
   
   Hide Hint #3  
Use cross product to check collinearity.
*/


//refer -> https://www.youtube.com/watch?v=f2n9NOkqvZQ&t=199s

//use slope formula (y2-y1)/(x2-x1), but to avoid the division by zero we are doing cross multiplication

//no need of Math.abs() coz id point is on the left or right side the slope will be the same
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length==2)
            return true;
        
        int diffx = (coordinates[1][0]-coordinates[0][0]);
        int diffy = (coordinates[1][1]-coordinates[0][1]);
        
        for(int i=2;i<coordinates.length;i++)
        {
            int curDiffx = (coordinates[i][0]-coordinates[i-1][0]);
            int curDiffy = (coordinates[i][1]-coordinates[i-1][1]);
            if((diffx*curDiffy)!=(diffy*curDiffx)){
                return false;
            }
        }
        
        return true;
        
    }
}

tc = 0(n)
sc = 0(1)