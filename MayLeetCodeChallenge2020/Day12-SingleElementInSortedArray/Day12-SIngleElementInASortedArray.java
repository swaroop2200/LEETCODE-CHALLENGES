/*
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
*/

/* USING BINARY SEARCH TECHNIQUE - BEST REFER TECH DOSE */
class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        //checking for boundary cases
        if(nums[0]!=nums[1])
            return nums[0];
        else if(nums[nums.length-1]!=nums[nums.length-2])
            return nums[nums.length-1];
        
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            //checking if its the mid element
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            
            //checking if pairs are (evenIndex,oddIndex)
            if((mid%2==0 && nums[mid]==nums[mid+1])||
               (mid%2==1 && nums[mid]==nums[mid-1]))
            {
               low=mid+1; // the unique element is present on the right
            }
            else
            {
                high=mid-1; //the unique element is present on the lef
            }
            
        }
        return -1;
    }
}

TC-0(log(n))
SC-0(1)