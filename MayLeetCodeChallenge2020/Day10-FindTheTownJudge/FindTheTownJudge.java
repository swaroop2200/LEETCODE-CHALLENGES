/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3

*/

/* used basic HASHING - indegree & outdegree method */
/* refer -> techDose https://www.youtube.com/watch?v=ZUP_tIs4VaE&t=427s */

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];
        
        //filling the indegree and out degree method
        for(int[] t : trust){
            outdegree[t[0]]++;
            indegree[t[1]]++;
        }
        
        //finding the town judge
        for(int i=1;i<=N;i++){
            if(outdegree[i]==0 && indegree[i]==N-1){
                return i;
            }
        }
        
        //not found any townjudge 
        return -1;
    }
}


//ALTERNATE VERSION - AS IN NICKWHITE VIDEO
//USE ONLY ON COUNT ARRAY

class Solution {
    public int findJudge(int N, int[][] trust) {
  
        int[] count = new int[N+1];
        
        // a -> b
        for(int[] t : trust){
            //increase count of a coz somebody knowws him
             count[t[1]]++;
            //decrease count of b coz he know somebody
             count[t[0]]--;
         }
        
        for(int i=1;i<=N;i++){
            //find someone who knows no one , but every on knows him
            if(count[i]==N-1){
                return i;
            }
        }
        
        return -1;
    }
}