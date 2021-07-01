
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/109/backtracking/796/
 * Subsets

Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
   //03
   public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> combo = new ArrayList<>();
      backtrack(res, combo, nums, 0);
      return res;
   }

   private void backtrack(List<List<Integer>> res, List<Integer> combo, int[] nums, int index) {
      res.add(new ArrayList<>(combo));
      for (int i = index; i < nums.length; i++) {
         combo.add(nums[i]);
         backtrack(res, combo, nums, i + 1);
         combo.remove(combo.size() - 1);
      }
   }
   
   //02
   List<List<Integer>> ans;
   int[] nums;

   private void helper(List<Integer> curr, int i) {
      ans.add(new ArrayList<>(curr));
      for (; i < nums.length; i++) {
         curr.add(nums[i]);
         helper(curr, i + 1);
         curr.remove(curr.size() - 1);
      }
   }

   public List<List<Integer>> subsets2(int[] nums) {
      this.nums = nums;
      this.ans = new ArrayList<>();
      if (nums == null || nums.length == 0) {
         return ans;
      }
      helper(new ArrayList<>(), 0);
      return ans;
   }

   /*
   list ans

   helper (currlist, nums, index)
      add COPY to ans
      for index to len(nums):
         add nums[i] to currlist
         helper(currlist, nums, i + 1)
         remove last element from currlist


   main
      instantiate ans
      if nums is empty or null
         return ans
      helper(empty list, nums, i=0)

   */

   //01
   public List<List<Integer>> subsets1(int[] S) {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      dfs(S, 0, new ArrayList<Integer>(), result);
      return result;
   }

   public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result) {
      result.add(new ArrayList<Integer>(path));

      for (int i = index; i < s.length; i++) {
         path.add(s[i]);
         dfs(s, i + 1, path, result);
         path.remove(path.size() - 1);
      }
   }

   // public List<List<Integer>> subsets(int[] nums) {
   //    List<List<Integer>> lst = new ArrayList<>();

   //    lst.add(new ArrayList<>());

   //    for (int i : nums) {
   //       List<Integer> l = new ArrayList<Integer>();
   //       l.add(i);
   //       lst.add(l);
   //    }

   //    return lst;
   // }

   public void test(int[] nums) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("subsets(%s): %s", Arrays.toString(nums), subsets(nums)));
      // System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      //[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
      int[] nums = new int[] { 1, 2, 3 };
      sol.test(nums);

      // //[[],[0]]
      // nums = new int[] { 0 };
      // sol.test(nums);
   }
}

/*
* 01
10 / 10 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 39.9 MB
*/

/*
03
10 / 10 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 40.1 MB
*/
