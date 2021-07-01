/**
 *https://leetcode.com/explore/interview/card/top-interview-questions-hard/124/others/874/
 * Queue Reconstruction by Height

You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

Example 1:
Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
Example 2:
Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

Constraints:
1 <= people.length <= 2000
0 <= hi <= 106
0 <= ki < people.length
It is guaranteed that the queue can be reconstructed.

   Hide Hint #1  
What can you say about the position of the shortest person?
If the position of the shortest person is i, how many people would be in front of the shortest person?
   Hide Hint #2  
Once you fix the position of the shortest person, what can you say about the position of the second shortest person?
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
   //02
   public int[][] reconstructQueue(int[][] people) {
      long[] buf = new long[people.length];
      for (int i = 0; i < people.length; i++) {
         buf[i] = i + ((2047L - people[i][1] + (people[i][0] << 11)) << 11);
      }
      Arrays.sort(buf);
      List<int[]> output = new ArrayList<>(people.length);
      for (int i = buf.length - 1; i >= 0; i--) {
         int index = (int) buf[i] & 0x3FF;
         output.add(people[index][1], people[index]);
      }
      return output.toArray(new int[people.length][]);
   }

   // 01
   public int[][] reconstructQueue1(int[][] people) {
      Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
      List<int[]> list = new LinkedList<>();
      for (int[] p : people) {
         list.add(p[1], p);
      }
      return list.toArray(new int[list.size()][]);
   }

   public void test(int[][] people, int[][] expect) {
      System.out.println("--------------------------------------------------------");
      System.out
            .println(String.format("reconstructQueue(%s): %s", Arrays.deepToString(people), Arrays.deepToString(reconstructQueue(people))));
      System.out.println(String.format("Expect: %s", Arrays.deepToString(expect)));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
      int[][] expect = { { 5, 0 }, { 7, 0 }, { 5, 2 }, { 6, 1 }, { 4, 4 }, { 7, 1 } };
      sol.test(people, expect);

      people = new int[][] { { 6, 0 }, { 5, 0 }, { 4, 0 }, { 3, 2 }, { 2, 2 }, { 1, 4 } };
      expect = new int[][] { { 4, 0 }, { 5, 0 }, { 2, 2 }, { 3, 2 }, { 1, 4 }, { 6, 0 } };
      sol.test(people, expect);

   }
}

/*
01
36 / 36 test cases passed.
Status: Accepted
Runtime: 8 ms
Memory Usage: 39.6 MB

02
36 / 36 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 40 MB
Your runtime beats 100.00 % of java submissions.
*/
