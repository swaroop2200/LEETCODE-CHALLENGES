//LEETCODE - Course Scedule II
//approach - topological sorting
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        int[] topRes = new int[numCourses];

        //filling the adjList and the indegree aray
        for (int i=0;i<prerequisites.length;i++) {
            int d = prerequisites[i][0];
            int s = prerequisites[i][1];
            List<Integer> l = adjList.getOrDefault(s, new ArrayList<>());
            l.add(d);
            adjList.put(s,l);
            //updating the indegree array
            indegree[d]++;
        }

        // find all elements whos indegree is zero and put it in the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (indegree[i]==0)
                q.add(i);
        }

        int count = 0; //to keep trck of the no of elements put into the result

        //do the actual toplogical sorting
        while (!q.isEmpty()) {
            int e = q.poll();
            topRes[count++]=e;
            //decreasing the indegree for the dest elements
            List<Integer> l = adjList.get(e);
            if(l!=null) { //l=null will come for last elements
                for(int i : l) {
                    indegree[i]--;
                    if(indegree[i]==0) {
                        q.add(i);
                    }
                }
            }
        }

        if(count==numCourses)
            return topRes;
        else
            return new int[0];
    }
}


//tc - 0(V+E)
//sc - 0(V)