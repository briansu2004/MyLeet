/**
 * 
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/114/others/826/
 * Task Scheduler

Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
Return the least number of units of times that the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:
Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:
Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A

Constraints:
1 <= task.length <= 104
tasks[i] is upper-case English letter.
The integer n is in the range [0, 100].
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


class Solution {
   //01
   public int leastInterval(char[] tasks, int n) {
      if (n == 0)
         return tasks.length;

      Map<Character, Integer> taskToCount = new HashMap<>();
      for (char c : tasks) {
         taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
      }

      Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
      for (char c : taskToCount.keySet())
         queue.offer(taskToCount.get(c));

      Map<Integer, Integer> coolDown = new HashMap<>();
      int currTime = 0;
      while (!queue.isEmpty() || !coolDown.isEmpty()) {
         if (coolDown.containsKey(currTime - n - 1)) {
            queue.offer(coolDown.remove(currTime - n - 1));
         }
         if (!queue.isEmpty()) {
            int left = queue.poll() - 1;
            if (left != 0)
               coolDown.put(currTime, left);
         }
         currTime++;
      }

      return currTime;
   }

   public void test(char[] tasks, int n, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("leastInterval(%s, %s): %s", Arrays.toString(tasks), n, leastInterval(tasks, n)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
      int n = 2;
      int expect = 8;
      sol.test(tasks, n, expect);

      tasks = new char[] { 'A', 'A', 'A', 'B', 'B', 'B' };
      n = 0;
      expect = 6;
      sol.test(tasks, n, expect);

      tasks = new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
      n = 2;
      expect = 16;
      sol.test(tasks, n, expect);
   }
}

/*
01
71 / 71 test cases passed.
Status: Accepted
Runtime: 42 ms
Memory Usage: 39.7 MB
Your memory usage beats 88.60 % of java submissions.
*/

