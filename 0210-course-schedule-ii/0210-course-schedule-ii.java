import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
     
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            adj.get(b).add(a);
            inDegree[a]++;
        }

      
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }


        int[] order = new int[numCourses];
        int idx = 0;

 
        while (!q.isEmpty()) {
            int node = q.poll();
            order[idx++] = node;

        
            for (int nei : adj.get(node)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if (idx == numCourses) {
            return order;
        }
        return new int[0];
    }
}