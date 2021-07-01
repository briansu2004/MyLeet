
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/108/trees-and-graphs/790/
 * Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

   Hide Hint #1  
Try to utilize the property of a BST.
   Hide Hint #2  
Try in-order traversal. (Credits to @chan13)
   Hide Hint #3  
What if you could modify the BST node's structure?
   Hide Hint #4  
The optimal runtime complexity is O(height of BST).
 * 
 */

 
import java.util.ArrayList;
import java.util.Stack;

class Solution {
   //03
   public int kthSmallest(TreeNode root, int k) {
      // Better than PriorityQueue! use Inorder traversal
      ArrayList<Integer> list = inorder(root, new ArrayList<>());
      //System.out.println(list); //[1, 2, 3, 4, 5, 6]
      return list.get(k - 1);
   }

   public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> curr) {
      if (root == null) {
         return curr;
      }
      inorder(root.left, curr);
      curr.add(root.val);
      inorder(root.right, curr);
      return curr;
   }
  
   //02
   public int kthSmallest2(TreeNode root, int k) {
      int result = 0, index = 0;

      Stack<TreeNode> stack = new Stack<TreeNode>();

      while (root != null || !stack.isEmpty()) {
         while (root != null) {
            stack.push(root);
            root = root.left;
         }

         root = stack.pop();
         index++;
         if (index == k) {
            result = root.val;
            break;
         }

         root = root.right;
      }

      return result;
   }

   //01
   public int kthSmallest1(TreeNode root, int k) {
      Stack<TreeNode> stack = new Stack<>();
      TreeNode cur = root;
      while (!stack.isEmpty() || cur != null) {
         while (cur != null) {
            stack.push(cur);
            cur = cur.left;
         }

         cur = stack.pop();
         if (--k == 0) {
            break;
         }

         cur = cur.right;
      }

      return cur.val;
   }

   public void test(TreeNode root, int k, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("kthSmallest(%s, %s): %s", root.toString(root), k, kthSmallest(root, k)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      //[3,1,4,null,2]
      TreeNode t = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
      int k = 1;
      int expect = 1;
      sol.test(t, k, expect);


      //[5,3,6,2,4,null,null,1]
      t = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
      k = 3;
      expect = 3;
      sol.test(t, k, expect);
   }
}


/*
* 01
93 / 93 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 41.9 MB
*/

/*
93 / 93 test cases passed.
Status: Accepted
Runtime: 2 ms
Memory Usage: 42.4 MB
*/

/*
03
93 / 93 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 39.2 MB
*/