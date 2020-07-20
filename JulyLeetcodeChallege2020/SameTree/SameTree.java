LEETCODE - 100. Same Tree
APPROACH - Simple tree recursion

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
        if(p.val!=q.val) return false;
        
        if(!isSameTree(p.left,q.left)) return false; // in case the LST is false, return false
        return isSameTree(p.right, q.right);
    }
}

// TC - 0(n) - wrst case going to each node 
// SC - 0(n) - if tree is skewed , then height is maximum
