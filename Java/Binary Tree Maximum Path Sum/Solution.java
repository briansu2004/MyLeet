/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/118/trees-and-graphs/845/
 * Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any path.

Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.

Constraints:
The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {
   // //04
   // int max = Integer.MIN_VALUE;

   // public int maxPathSum(TreeNode root) {
   //    helper(root);
   //    return max;
   // }

   // // helper returns the max branch
   // // plus current node's value
   // int helper(TreeNode root) {
   //    if (root == null)
   //       return 0;

   //    int left = Math.max(helper(root.left), 0);
   //    int right = Math.max(helper(root.right), 0);

   //    max = Math.max(max, root.val + left + right);

   //    return root.val + Math.max(left, right);
   // }

   // 03
   int maxVal = Integer.MIN_VALUE;

   public int maxPathSum(TreeNode root) {
      if (root == null)
         return 0;

      List<TreeNode> postOrder = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
         TreeNode node = stack.pop();
         postOrder.add(0, node);
         if (node.left != null)
            stack.push(node.left);
         if (node.right != null)
            stack.push(node.right);
      }

      int max = Integer.MIN_VALUE;
      Map<TreeNode, Integer> map = new HashMap<>();
      for (TreeNode node : postOrder) {
         int left = 0;
         if (node.left != null) {
            left = Math.max(0, map.getOrDefault(node.left, 0));
         }
         int right = 0;
         if (node.right != null) {
            right = Math.max(0, map.getOrDefault(node.right, 0));
         }

         map.put(node, Math.max(left, right) + node.val);
         max = Math.max(max, node.val + left + right);
      }

      return max;
   }
   
   //02
   int ans = Integer.MIN_VALUE;

   int func(TreeNode root) {
      if (root == null)
         return 0;
      int l = func(root.left);
      int r = func(root.right);
      int a = Math.max(l, r);
      int b = Math.max(root.val, root.val + a);
      ans = Math.max(ans, b);
      ans = Math.max(ans, root.val + l + r);
      return b;
   }

   public int maxPathSum2(TreeNode root) {
      if (root == null)
         return 0;
      func(root);
      return ans;
   }

   // 01
   int maxValue;

   public int maxPathSum1(TreeNode root) {
      maxValue = Integer.MIN_VALUE;
      maxPathDown(root);
      return maxValue;
   }

   private int maxPathDown(TreeNode node) {
      if (node == null)
         return 0;
      int left = Math.max(0, maxPathDown(node.left));
      int right = Math.max(0, maxPathDown(node.right));
      maxValue = Math.max(maxValue, left + right + node.val);
      return Math.max(left, right) + node.val;
   }

   public void test(TreeNode root, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("maxPathSum(%s): %s", root, maxPathSum(root)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      TreeNode head = new TreeNode(1, new TreeNode(2), new TreeNode(3));
      int expect = 6;
      sol.test(head, expect);

      // [-10,9,20,null,null,15,7]
      head = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
      expect = 42;
      sol.test(head, expect);

      head = new TreeNode(-1, new TreeNode(-2147483648), new TreeNode(-2147483648));
      expect = -1;
      sol.test(head, expect);
   }
}

/*
01
94 / 94 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 45.2 MB
*/

/*
02
94 / 94 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 41 MB
*/

/*
03
94 / 94 test cases passed.
Status: Accepted
Runtime: 53 ms
Memory Usage: 47.4 MB
*/
