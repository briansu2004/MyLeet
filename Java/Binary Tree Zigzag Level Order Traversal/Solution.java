
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/787/
 *  Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:
Input: root = [1]
Output: [[1]]
Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

   //02
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> sol = new ArrayList<>();
      travel(root, sol, 0);
      return sol;
   }

   private void travel(TreeNode curr, List<List<Integer>> sol, int level) {
      if (curr == null)
         return;

      if (sol.size() <= level) {
         List<Integer> newLevel = new LinkedList<>();
         sol.add(newLevel);
      }

      List<Integer> collection = sol.get(level);
      if (level % 2 == 0)
         collection.add(curr.val);
      else
         collection.add(0, curr.val);

      travel(curr.left, sol, level + 1);
      travel(curr.right, sol, level + 1);
   }

   // 01 bfs
   public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
      List<List<Integer>> ret = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      int l = 0;
      while (!queue.isEmpty()) {
         int size = queue.size();
         List<Integer> level = new ArrayList<>();
         for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node != null) {
               level.add(node.val);
               queue.add(node.left);
               queue.add(node.right);
            }
         }
         if (!level.isEmpty()) {
            if (l % 2 == 1) {
               Collections.reverse(level);
            }
            ret.add(level);
         }
         l++;
      }
      return ret;
   }

   public void test(TreeNode root) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("zigzagLevelOrder(%s): %s", root.toString(root), zigzagLevelOrder(root)));
      //System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      TreeNode t = new TreeNode();
      sol.test(t);

      t = new TreeNode(5);
      sol.test(t);

      t = new TreeNode(5, new TreeNode(4), new TreeNode(6));
      sol.test(t);

      t = new TreeNode(10, new TreeNode(4, new TreeNode(3), new TreeNode(5)), new TreeNode(18, new TreeNode(12), new TreeNode(20)));
      sol.test(t);
   }
}


/*
* 01
33 / 33 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 39 MB
*/

/*
*02
33 / 33 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 39.8 MB
*/
