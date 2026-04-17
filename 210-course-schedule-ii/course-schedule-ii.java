import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            result[index++] = cur;

            for (int next : graph.get(cur)) {
                if (--indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return index == numCourses ? result : new int[0];
    }
}