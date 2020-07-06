/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> l = new LinkedList<>();
        int len = digits.length;
        int carry = 1;
        for(int i=len-1; i>=0; i--) {
            int curDigit = digits[i];
            int sum = curDigit + carry;
            l.addFirst(sum%10);
            carry = (sum>9)?1:0;
        }
        //if there is a left over carry 
        if(carry>0)
            l.add(1);
        
        //returning int[]
        return l.stream() 
            .mapToInt(Integer::intValue) 
            .toArray();
    }
}