
/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/110/sorting-and-searching/800/
 * Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
 * 
 */

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
   //03
   public int findKthLargest(int[] nums, int k) {
      int start = 0, end = nums.length - 1, index = nums.length - k;
      while (start < end) {
         int pivot = partion(nums, start, end);
         if (pivot < index)
            start = pivot + 1;
         else if (pivot > index)
            end = pivot - 1;
         else
            return nums[pivot];
      }
      return nums[start];
   }

   private int partion(int[] nums, int start, int end) {
      int pivot = start, temp;
      while (start <= end) {
         while (start <= end && nums[start] <= nums[pivot])
            start++;
         while (start <= end && nums[end] > nums[pivot])
            end--;
         if (start > end)
            break;
         temp = nums[start];
         nums[start] = nums[end];
         nums[end] = temp;
      }
      temp = nums[end];
      nums[end] = nums[pivot];
      nums[pivot] = temp;
      return end;
   }

   // 02
   public int findKthLargest2(int[] nums, int k) {
      if (k > nums.length)
         return -1;
      return quickSelect(nums, 0, nums.length - 1, k);
   }

   private int quickSelect(int[] nums, int s, int e, int k) {
      if (s >= e) {
         return nums[s];
      }

      int i = s, j = e;
      int pivot = nums[(e - s) / 2 + s];
      while (i <= j) {
         while (i <= j && nums[i] > pivot) {
            i++;
         }

         while (i <= j && nums[j] < pivot) {
            j--;
         }

         if (i <= j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
         }
      }

      if (k <= (j - s) + 1) {
         return quickSelect(nums, s, j, k);
      }

      if (k >= i - s + 1) {
         return quickSelect(nums, i, e, k - (i - s));
      }
      return nums[j + 1];
   }

   // 01
   public int findKthLargest1(int[] nums, int k) {
      PriorityQueue<Integer> queue = new PriorityQueue<>(); // min heap
      for (int i = 0; i < nums.length; i++) {
         queue.add(nums[i]);
         if (queue.size() > k)
            queue.remove();
      }

      return queue.remove();
   }

   //Mine
   public int findKthLargest0(int[] nums, int k) {
      // Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
      // List<Integer> l = new ArrayList<Integer>(s);
      // Collections.sort(l);

      Arrays.sort(nums);

      return nums[nums.length - k];
   }

   public void test(int[] nums, int k, int expect) {
      System.out.println("--------------------------------------------------------");
      System.out.println(String.format("findKthLargest(%s, %s): %s", Arrays.toString(nums), k, findKthLargest(nums, k)));
      System.out.println(String.format("Expect: %s", expect));
      System.out.println();
   }

   public static void main(String[] args) {
      Solution sol = new Solution();

      int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
      int k = 2;
      int expect = 5;
      sol.test(nums, k, expect);

      nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
      k = 4;
      expect = 4;
      sol.test(nums, k, expect);

   }
}


/*
* Mine
32 / 32 test cases passed.
Status: Accepted
Runtime: 4 ms
Memory Usage: 41.7 MB
Your runtime beats 59.53 % of java submissions.
*/

/*
01
32 / 32 test cases passed.
Status: Accepted
Runtime: 11 ms
Memory Usage: 42.1 MB
*/

/*
02
32 / 32 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 41.7 MB
Your runtime beats 97.77 % of java submissions.
*/

/*
03
32 / 32 test cases passed.
Status: Accepted
Runtime: 11 ms
Memory Usage: 39.3 MB
*/
