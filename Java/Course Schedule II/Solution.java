/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/118/trees-and-graphs/848/
 * Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]

Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.

   Hide Hint #1  
This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
   Hide Hint #2  
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
   Hide Hint #3  
Topological sort could also be done via BFS.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
   // 01
   public static int[] findOrder(int numCourses, int[][] prerequisites) {
      if (prerequisites == null || prerequisites.length == 0) {
         int[] a = new int[numCourses];
         for (int i = 0; i < numCourses; i++) {
            a[i] = i;
         }
         return a;
      }
      Map<Integer, Set<Integer>> course2pres = new HashMap<Integer, Set<Integer>>();
      for (int i = 0; i < prerequisites.length; i++) {
         if (course2pres.containsKey(prerequisites[i][0])) {
            course2pres.get(prerequisites[i][0]).add(prerequisites[i][1]);
         } else {
            Set<Integer> pres = new HashSet<Integer>();
            pres.add(prerequisites[i][1]);
            course2pres.put(prerequisites[i][0], pres);
         }
      }
      Set<Integer> coursesWithPre = course2pres.keySet();
      boolean[] visited = new boolean[numCourses];
      boolean[] visiting = new boolean[numCourses];
      List<Integer> order = new ArrayList<Integer>();
      for (int c : coursesWithPre) {
         if (!visited[c]) {
            if (!dfs(c, course2pres, visited, visiting, order))
               return new int[0];
         }
      }
      int[] arrayOrder = new int[numCourses];
      Set<Integer> nopre = new HashSet<Integer>();
      if (order.size() < numCourses) {
         for (int i = 0; i < numCourses; i++) {
            if (!order.contains(i)) {
               nopre.add(i);
            }
         }
      }
      order.addAll(nopre);
      for (int i = 0; i < arrayOrder.length; i++) {
         arrayOrder[i] = order.get(i);
      }
      return arrayOrder;
   }

   public static boolean dfs(int c, Map<Integer, Set<Integer>> pres, boolean[] visited, boolean[] visiting,
         List<Integer> order) {
      if (visiting[c])
         return false;
      visiting[c] = true;
      if (pres.containsKey(c)) {
         for (int i : pres.get(c)) {
            if (!visited[i]) {
               if (!dfs(i, pres, visited, visiting, order))
                  return false;
            }
         }
      }
      visiting[c] = false;
      visited[c] = true;
      order.add(c);
      return true;
   }

   public void test(int numCourses, int[][] prerequisites, int[] expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("findOrder(%s, %s): %s", numCourses, Arrays.deepToString(prerequisites),
            Arrays.toString(findOrder(numCourses, prerequisites))));
      System.out.println(String.format("Expect: %s", Arrays.toString(expect)));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int numCourses = 2;
      int[][] prerequisites = { { 1, 0 } };
      int[] expect = { 0, 1 };
      sol.test(numCourses, prerequisites, expect);

      // numCourses = 2;
      // prerequisites = new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
      // expect = new int[] { 0, 2, 1, 3 };
      // sol.test(numCourses, prerequisites, expect);

      numCourses = 1;
      prerequisites = new int[][] {};
      expect = new int[] { 0 };
      sol.test(numCourses, prerequisites, expect);
   }
}

/*
01
44 / 44 test cases passed.
Status: Accepted
Runtime: 10 ms
Memory Usage: 40.2 MB
*/
