/*
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.

*/

//USING BINARY SEARCH TO FIND THE CLOSEST UPPER BOUND
class Solution {
    private int[] w;
    public Solution(int[] w1) {
        w=new int[w1.length];
        w[0]=w1[0];
        for(int i=1;i<w.length;i++) {
            w[i]=w[i-1]+w1[i];
        }
    }
    
    public int pickIndex() {
        int i = new Random().nextInt(w[w.length-1])+1;
        int left = 0;
        int right = w.length-1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(w[mid] == i)
                return mid;
            if(w[mid] < i)
                left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

TC=0(log N)
SC=0(N)