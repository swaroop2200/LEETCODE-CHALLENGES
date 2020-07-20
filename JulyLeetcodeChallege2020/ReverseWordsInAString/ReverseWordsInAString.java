/*
LEETCODE - Reverse Words in a String
Approach - simple string approach
*/
class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==1)
            return s.trim();
        StringBuilder sb = new StringBuilder();
        
        /*
            -1st remove the leading and trailing whitespaces
            -2nd replace all inbetween white spaces of any length to a single white space
            -3rd split it based on single white space
        */
        
        String[] split = s.trim().replaceAll("\\s+"," ").split(" ");
        for(int i=split.length-1;i>=0;i--) {
            sb.append(split[i]);
            //last word should not have any white space in the end
            if(i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }
}

// TC - 0(n)
// SC - 0(n)

