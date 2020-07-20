//LEETCODE - 67.Add Binary
//https://leetcode.com/problems/add-binary/


class Solution {
    
    public static String rev(String s){ 
        return new StringBuilder(s).reverse().toString(); 
    } 
    public String addBinary(String a, String b) {
        //first reverse the 2 strings
        a = rev(a);
        b = rev(b);
        StringBuilder str = new StringBuilder();
        int i=0;
        int carry = 0;
        //doing the actual addition
        while(i<a.length() || i<b.length()) {
            int sum = 0;
            sum += carry;
            if(i<a.length()) {
                sum += Character.getNumericValue(a.charAt(i)); 
            }
            if(i<b.length()) {
                sum+=Character.getNumericValue(b.charAt(i));
            }
            i++;
            
            if(sum==0) {
                carry = 0;
                str.append("0");
            } else if(sum == 1) {
                carry = 0;
                str.append("1");
            } else if(sum == 2) {
                carry = 1;
                str.append("0");
            } else {
                carry = 1;
                str.append("1");
            }
        }
        //add 1 if there is an extra carry 
        if(carry == 1)
            str.append("1");
        //return the reversed result
        return str.reverse().toString();
    }
}

tc - 0(n) - length of longest string
sc - 0(1)