/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt.
Example 1:
Input: 16
Output: true
Example 2:
Input: 14
Output: false
*/

/* use binary search technique */

class Solution {
    public boolean isPerfectSquare(int num) {
        long n = num;
        long high = num;
        long low = 1;
        
        while(low<=high){
            long mid=low+(high-low)/2;
            long square = mid*mid;
            if(square==n){
                return true;
            }if(square>n){
                high=mid-1;
            }else if(square<n){
                low=mid+1;
            }
        }
        return false;
    }
}

TC = 0(log(n))
SC = 0(1)