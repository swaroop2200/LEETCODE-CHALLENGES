/*
    LEETCODE - Climbing Stair
    Approach - DP (like fibonacci series)
*/

class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1)
            return n;
        //similar to fibonacci number
        int a=0;
        int b=1;
        int sum=0;
        for(int i=0;i<n;i++){
            sum = a+b;
            a=b;
            b=sum;
        }
        return sum;
    }
}

//TC - 0(n)
//SC - 0(1)