/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/113/math/817/
 * Excel Sheet Column Number

Given a string columnTitle that represents the column title as appear in an Excel sheet, return its corresponding column number.

For example:
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
Example 1:
Input: columnTitle = "A"
Output: 1
Example 2:
Input: columnTitle = "AB"
Output: 28
Example 3:
Input: columnTitle = "ZY"
Output: 701
Example 4:
Input: columnTitle = "FXSHRXW"
Output: 2147483647

Constraints:
1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
 */

class Solution {
   //Mine
   public int titleToNumber(String columnTitle) {
      // -64
      // A: 65 -> 1
      // B: 66 -> 2
      // Z: 90 -> 26

      int sum = 0;
      int level = 1;
      for (int i = columnTitle.length() - 1; i >= 0; i--) {
         sum += (((int) columnTitle.charAt(i)) - 64) * level;
         level *= 26;
      }

      return sum;
   }

   public void test(String columnTitle, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("titleToNumber(%s): %s", columnTitle, titleToNumber(columnTitle)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      //System.out.println((int) 'A');

      String columnTitle = "A";
      int expect = 1;
      sol.test(columnTitle, expect);
      
      columnTitle = "AB";
      expect = 28;
      sol.test(columnTitle, expect);

      columnTitle = "ZY";
      expect = 701;
      sol.test(columnTitle, expect);

      columnTitle = "FXSHRXW";
      expect = 2147483647;
      sol.test(columnTitle, expect);
   }
}

/*
Mine
1002 / 1002 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 38.7 
Your runtime beats 100.00 % of java submissions
Your memory usage beats 75.81 % of java submissions.
*/

/*
01

*/
