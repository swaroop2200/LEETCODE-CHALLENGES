//Leetcode Detect Capital

class Solution {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        int capCount =0;
        for(int i=0;i<len;i++){
            if(Character.isUpperCase(word.charAt(i))){
                capCount++;
            }
        }
        
        if(capCount == 0
          || capCount == len
          || (capCount == 1 && Character.isUpperCase(word.charAt(0))))
            return true;
        
        return false;
    }
}