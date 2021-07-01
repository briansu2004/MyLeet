import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-hard/123/math/872/
 *  Largest Number

Solution
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:

Input: nums = [1]
Output: "1"
Example 4:

Input: nums = [10]
Output: "10"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
*/

class Solution {
   //03
   public String largestNumber(int[] nums) {
      int n = nums.length;
      // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
      Integer[] numsArr = new Integer[n];
      for (int i = 0; i < n; i++) {
         numsArr[i] = nums[i];
      }

      Arrays.sort(numsArr, (x, y) -> {
         long sx = 10, sy = 10;
         while (sx <= x) {
            sx *= 10;
         }
         while (sy <= y) {
            sy *= 10;
         }
         return (int) (-sy * x - y + sx * y + x);
      });

      if (numsArr[0] == 0) {
         return "0";
      }
      StringBuilder ret = new StringBuilder();
      for (int num : numsArr) {
         ret.append(num);
      }
      return ret.toString();
   }

   //02
   private int[] digits;

   public String largestNumber2(int[] nums) {
      digits = new int[nums.length];

      for (int i = 0; i < nums.length; i++) {
         digits[i] = countDigits(nums[i]);
      }

      sort(nums, 0, nums.length - 1);
      StringBuilder builder = new StringBuilder();

      boolean nonZeroNumberSeen = false;
      for (int i = 0; i < nums.length; i++) {
         builder.append(nums[i]);

         if (nums[i] != 0) {
            nonZeroNumberSeen = true;
         }
      }

      if (!nonZeroNumberSeen) {
         return "0";
      }

      return builder.toString();
   }

   // Arranges the numbers in nums so that when read from left to right, the
   // numbers
   // form the largest number possible. Assumes that the digits array for nums has
   // already been filled.
   private void sort(int[] nums, int lo, int hi) {
      if (lo <= hi) {
         int pivot = nums[lo];
         int pivotIndex = lo;

         for (int i = lo + 1; i <= hi; i++) {
            if (greater(nums[i], pivot, digits[i], digits[lo])) {
               pivotIndex++;
               swap(nums, pivotIndex, i);
               swap(digits, pivotIndex, i);
            }
         }

         swap(nums, lo, pivotIndex);
         swap(digits, lo, pivotIndex);
         sort(nums, lo, pivotIndex - 1);
         sort(nums, pivotIndex + 1, hi);
      }
   }

   // Swaps nums[index1] and nums[index2].
   private void swap(int[] nums, int index1, int index2) {
      int temp = nums[index1];
      nums[index1] = nums[index2];
      nums[index2] = temp;
   }

   // Returns true if appending num2 to num1 forms a larger number than
   // appending num1 to num2. Assumes that num1Digits and num2Digits equal
   // the number of digits in num1 and num2, respectively.
   private boolean greater(int num1, int num2, int num1Digits, int num2Digits) {
      if (num1Digits == num2Digits) {
         return num1 > num2;
      }

      int numDigitsCutOff;
      int digitsCutOff;
      int normalizedNum1;
      int normalizedNum2;

      if (num1Digits > num2Digits) {
         numDigitsCutOff = num1Digits - num2Digits;
         int divisor = powerOfTen(numDigitsCutOff);
         digitsCutOff = num1 % divisor;
         normalizedNum1 = num1 / divisor;
         normalizedNum2 = num2;
      } else {
         numDigitsCutOff = num2Digits - num1Digits;
         int divisor = powerOfTen(numDigitsCutOff);
         digitsCutOff = num2 % divisor;
         normalizedNum1 = num1;
         normalizedNum2 = num2 / divisor;
      }

      if (normalizedNum1 > normalizedNum2) {
         return true;
      } else if (normalizedNum1 < normalizedNum2) {
         return false;
      }

      // At this point, normalizedNum1 == normalizedNum2.

      if (num1Digits > num2Digits) {
         return greater(digitsCutOff, num2, numDigitsCutOff, num2Digits);
      } else {
         return greater(num1, digitsCutOff, num1Digits, numDigitsCutOff);
      }
   }

   // Returns 10 raised to the power of the given exponent. Assumes that exponent
   // >= 0.
   private int powerOfTen(int exponent) {
      int result = 1;

      for (int i = exponent; i > 0; i--) {
         result *= 10;
      }

      return result;
   }

   // Returns the number of digits in num.
   private int countDigits(int num) {
      int numDigits = 0;

      do {
         numDigits++;
         num = num / 10;
      } while (num != 0);

      return numDigits;
   }

   //01
   public String largestNumber1(int[] num) {
      if (num == null || num.length == 0)
         return "";

      // Convert int array to String array, so we can sort later on
      String[] s_num = new String[num.length];
      for (int i = 0; i < num.length; i++)
         s_num[i] = String.valueOf(num[i]);

      // Comparator to decide which string should come first in concatenation
      Comparator<String> comp = new Comparator<String>() {
         @Override
         public int compare(String str1, String str2) {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1); // reverse order here, so we can do append() later
         }
      };

      Arrays.sort(s_num, comp);
      // An extreme edge case by lc, say you have only a bunch of 0 in your int array
      if (s_num[0].charAt(0) == '0')
         return "0";

      StringBuilder sb = new StringBuilder();
      for (String s : s_num)
         sb.append(s);

      return sb.toString();
   }

   public void test(int[] nums, String expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("largestNumber(%s): %s", Arrays.toString(nums), largestNumber(nums)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = { 10, 2 };
      String expect = "210";
      sol.test(nums, expect);

      nums = new int[] { 3, 30, 34, 5, 9 };
      expect = "9534330";
      sol.test(nums, expect);

      nums = new int[] { 1 };
      expect = "1";
      sol.test(nums, expect);

      nums = new int[] { 10 };
      expect = "10";
      sol.test(nums, expect);
   }
}

/*
01
229 / 229 test cases passed.
Status: Accepted
Runtime: 5 ms
Memory Usage: 38.1 MB
*/

/*
02
229 / 229 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 36.9 MB
*/

/*
03
229 / 229 test cases passed.
Status: Accepted
Runtime: 3 ms
Memory Usage: 37 MB
*/
