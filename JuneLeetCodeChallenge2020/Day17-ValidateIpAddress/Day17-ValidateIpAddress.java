/*

Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.

IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;

Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.

IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).

However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.

Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.

Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:
Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.

*/


class Solution {
    public String validIPAddress(String IP) {
        if(IP==null || IP.length()==0) return "Neither";
        if(IP.contains("."))        return validateIPV4(IP);
        if(IP.contains(":"))        return validateIPV6(IP);
        
        return "Neither";
    }
    
    public String validateIPV4(String IP){
        
        //checking for leading and trailing "."
        if(IP.charAt(0)=='.' || IP.charAt(IP.length()-1)=='.')
            return "Neither";
        
        String[] tokens = IP.split("\\.");
        
        //checking the number of tokens
        if(tokens.length!=4)
            return "Neither";
        
        //go through each character
        for(String token : tokens)
        {
            //if empty or long or 0xx toekn return false
            if(token.length()==0 || token.length()>3 || (token.charAt(0)=='0' && token.length()>1))
                return "Neither";
            
            //check each character is a digit
            for(int i=0;i<token.length();i++){
                char ch = token.charAt(i);
                if(Character.isDigit(ch)==false)
                    return "Neither";
            }
            
            //cheking is greater than 255
            if(Integer.parseInt(token)>255)
                return "Neither";
            
        }
          return "IPv4";
    }
    
     public String validateIPV6(String IP){
        
        //checking for leading and trailing "."
        if(IP.charAt(0)==':' || IP.charAt(IP.length()-1)==':')
            return "Neither";
        
        String[] tokens = IP.split(":");
        
        if(tokens.length!=8)
            return "Neither";
        
        //go through each character
        for(String token : tokens)
        {
            //if empty or long  return false
            if(token.length()==0 || token.length()>4)
                return "Neither";
            
            //checking if each character is hexadecimal
            for(int i=0;i<token.length();i++){
                char c = token.charAt(i);
                if(!(c>='0' && c <='9') && !(c>='a' && c <='f') && !(c>='A' && c <='F') ) return "Neither";
            }
            
           
  
        }
          return "IPv6";
    }
    
    
}

TC-O(n)
sc-O(n)