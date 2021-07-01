/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/124/others/875/
 * Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
*/


import java.util.Arrays;

class Solution {
   //02
   public int trap(int[] height) {
      if (height.length == 0)
         return 0;
      int i = 0, j = height.length - 1, l = height[0], r = height[height.length - 1], s = 0;
      while (i < j) {
         if (height[i] < height[j]) {
            l = Math.max(l, height[i]);
            s += l - height[i];
            i++;
         } else {
            r = Math.max(r, height[j]);
            s += r - height[j];
            j--;
         }
      }
      return s;
   }

   //01
   public int trap1(int[] height) {
      int start = 0, end = height.length - 1;
      int water = 0, minHeight = 0;

      while (start < end) {
         while (start < end && height[start] <= minHeight)
            water += minHeight - height[start++];
         while (start < end && height[end] <= minHeight)
            water += minHeight - height[end--];
         minHeight = Math.min(height[start], height[end]);
      }
      return water;
   }

   public void test(int[] height, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("trap(%s): %s", Arrays.toString(height), trap(height)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
      int expect = 6;
      sol.test(height, expect);

      height = new int[] { 4, 2, 0, 3, 2, 5 };
      expect = 9;
      sol.test(height, expect);

   }
}

/*
01
320 / 320 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 38.4 MB
Your runtime beats 84.99 % of java submissions.

02
320 / 320 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 38.5 MB
*/
