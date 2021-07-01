/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/118/trees-and-graphs/847/
 * Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 
Constraints:
1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
   Hide Hint #1  
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
   Hide Hint #2  
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
   Hide Hint #3  
Topological sort could also be done via BFS.
 * 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
   //02

   
   // 01 BFS
   public boolean canFinish(int numCourses, int[][] prerequisites) {
      ArrayList[] graph = new ArrayList[numCourses];
      int[] degree = new int[numCourses];
      Queue queue = new LinkedList();
      int count = 0;

      for (int i = 0; i < numCourses; i++)
         graph[i] = new ArrayList();

      for (int i = 0; i < prerequisites.length; i++) {
         degree[prerequisites[i][1]]++;
         graph[prerequisites[i][0]].add(prerequisites[i][1]);
      }
      for (int i = 0; i < degree.length; i++) {
         if (degree[i] == 0) {
            queue.add(i);
            count++;
         }
      }

      while (queue.size() != 0) {
         int course = (int) queue.poll();
         for (int i = 0; i < graph[course].size(); i++) {
            int pointer = (int) graph[course].get(i);
            degree[pointer]--;
            if (degree[pointer] == 0) {
               queue.add(pointer);
               count++;
            }
         }
      }
      if (count == numCourses)
         return true;
      else
         return false;
   }

   public void test(int numCourses, int[][] prerequisites, boolean expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("canFinish(%s, %s): %s", numCourses, Arrays.deepToString(prerequisites),
            canFinish(numCourses, prerequisites)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int numCourses = 2;
      int[][] prerequisites = { { 1, 0 } };
      boolean expect = true;
      sol.test(numCourses, prerequisites, expect);

      numCourses = 2;
      prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };
      expect = false;
      sol.test(numCourses, prerequisites, expect);
   }
}

/*
01
49 / 49 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 38.8 MB
Your runtime beats 86.78 % of java submissions.
Your memory usage beats 98.58 % of java submissions.
*/
