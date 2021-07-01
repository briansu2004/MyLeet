/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/116/array-and-strings/837/
 * Sliding Window Maximum

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:
Input: nums = [1], k = 1
Output: [1]
Example 3:
Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:
Input: nums = [9,11], k = 2
Output: [11]
Example 5:
Input: nums = [4,-2], k = 2
Output: [4]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length

   Hide Hint #1  
How about using a data structure such as deque (double-ended queue)?
   Hide Hint #2  
The queue size need not be the same as the window’s size.
   Hide Hint #3  
Remove redundant elements and the queue should store only elements that need to be considered.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
   //03
   public int[] maxSlidingWindow(int[] nums, int k) {
      Deque<Integer> decreasingStack = new LinkedList<>();
      for (int i = 0; i < k; i++) {
         while (!decreasingStack.isEmpty() && nums[decreasingStack.peekLast()] < nums[i])
            decreasingStack.pollLast();
         decreasingStack.addLast(i);

      }
      int[] ans = new int[nums.length - k + 1];
      for (int i = k - 1; i < nums.length; i++) {
         while ((!decreasingStack.isEmpty()) && decreasingStack.peekFirst() < i - k + 1)
            decreasingStack.pollFirst();
         while ((!decreasingStack.isEmpty()) && nums[decreasingStack.peekLast()] < nums[i])
            decreasingStack.pollLast();
         decreasingStack.addLast(i);
         ans[i - k + 1] = nums[decreasingStack.peekFirst()];
      }
      return ans;
   }

   //02
   public int[] maxSlidingWindow2(int[] nums, int k) {
      int n = nums.length;
      int[] res = new int[n - k + 1];
      int left = 0, right = k - 1, maxIndex = maxIndex(nums, 0, k - 1);
      while (true) {
         if (maxIndex >= left) {
            res[left++] = nums[maxIndex];
            right += 1;
            if (right == n) {
               break;
            }

            if (nums[right] >= nums[maxIndex]) {
               maxIndex = right;
            }

         } else {
            if (nums[right] >= nums[maxIndex] - 1) {
               maxIndex = right;
            } else if (nums[left] >= nums[maxIndex] - 1) {
               maxIndex = left;
            } else {
               maxIndex = maxIndex(nums, left, right);
            }
         }
      }
      return res;
   }

   public int maxIndex(int[] nums, int start, int end) {
      int index = start, val = nums[start];
      for (int i = start + 1; i <= end; i++) {
         if (val <= nums[i]) {
            val = nums[i];
            index = i;
         }
      }
      return index;
   }

   // 01
   public int[] maxSlidingWindow1(int[] nums, int k) {
      Deque<Integer> q = new ArrayDeque<>(); // stores *indices*
      List<Integer> res = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
         while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
            q.removeLast();
         }
         q.addLast(i);
         // remove first element if it's outside the window
         if (q.getFirst() == i - k) {
            q.removeFirst();
         }
         // if window has k elements add to results (first k-1 windows have < k elements
         // because we start from empty window and add 1 element each iteration)
         if (i >= k - 1) {
            res.add(nums[q.peek()]);
         }
      }
      return res.stream().mapToInt(i -> i).toArray();
   }

   public void test(int[] nums, int k, int[] expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("maxSlidingWindow(%s, %s): %s", Arrays.toString(nums), k,
            Arrays.toString(maxSlidingWindow(nums, k))));
      System.out.println(String.format("Expect: %s", Arrays.toString(expect)));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 1 };
      int k = 1;
      int[] expect = { 1 };
      sol.test(nums, k, expect);

      nums = new int[] { 1, -1 };
      k = 1;
      expect = new int[] { 1 };
      sol.test(nums, k, expect);

      nums = new int[] { 9, 11 };
      k = 2;
      expect = new int[] { 11 };
      sol.test(nums, k, expect);

      nums = new int[] { 4, -2 };
      k = 2;
      expect = new int[] { 4 };
      sol.test(nums, k, expect);

      nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
      k = 3;
      expect = new int[] { 3, 3, 5, 5, 6, 7 };
      sol.test(nums, k, expect);

   }
}

/*
01
61 / 61 test cases passed.
Status: Accepted
Runtime: 92 ms
Memory Usage: 130.5 MB
Your runtime beats 12.40 % of java submissions.
Your memory usage beats 11.52 % of java submissions.
*/

/*
02
61 / 61 test cases passed.
Status: Accepted
Runtime: 5 ms
Memory Usage: 60.8 MB
Your runtime beats 99.84 % of java submissions.
*/

/*
61 / 61 test cases passed.
Status: Accepted
Runtime: 27 ms
Memory Usage: 49.2 MB
Your runtime beats 88.56 % of java submissions.
Your memory usage beats 98.95 % of java submissions.
*/
