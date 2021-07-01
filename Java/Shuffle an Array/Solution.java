
/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/98/design/670/
 *  Shuffle an Array

Given an integer array nums, design an algorithm to randomly shuffle the array.
Implement the Solution class:
Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.

Example 1:
Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must be equally likely to be returned. Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

Constraints:
1 <= nums.length <= 200
-106 <= nums[i] <= 106
All the elements of nums are unique.
At most 5 * 104 calls will be made to reset and shuffle.

Hint #1  
The solution expects that we always use the original array to shuffle() else some of the test cases fail. (Credits; @snehasingh31)
 */

import java.util.Arrays;
import java.util.Random;

class Solution {
    // 01
    // private int[] nums;
    // private Random random;

    // public Solution(int[] nums) {
    // this.nums = nums;
    // random = new Random();
    // }

    // /** Resets the array to its original configuration and return it. */
    // public int[] reset() {
    // return nums;
    // }

    // /** Returns a random shuffling of the array. */
    // public int[] shuffle() {
    // if (nums == null)
    // return null;
    // int[] a = nums.clone();
    // for (int j = 1; j < a.length; j++) {
    // int i = random.nextInt(j + 1);
    // swap(a, i, j);
    // }
    // return a;
    // }

    // private void swap(int[] a, int i, int j) {
    // int t = a[i];
    // a[i] = a[j];
    // a[j] = t;
    // }

    // Mine
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }

        int[] a = nums.clone();
        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return a;
    }

    public void test(int[] nums) {
        System.out.println("--------------------------------------------------------");

        Solution solution = new Solution(nums);
        System.out.println(String.format("Initial: %s", Arrays.toString(nums)));

        int[] ret = solution.shuffle(); // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3]
                            // must be equally likely to be returned. Example: return [3, 1, 2]
        System.out.println(String.format("After shuffling: %s", Arrays.toString(ret)));

        ret = solution.reset(); // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
        System.out.println(String.format("After reset: %s", Arrays.toString(ret)));

        ret = solution.shuffle(); // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
        System.out.println(String.format("After shuffling: %s", Arrays.toString(ret)));

        ret = solution.reset(); // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
        System.out.println(String.format("After reset: %s", Arrays.toString(ret)));

        ret = solution.shuffle(); // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
        System.out.println(String.format("After shuffling: %s", Arrays.toString(ret)));

        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        Solution solution = new Solution(nums);
        solution.test(nums);
        // solution.shuffle(); // Shuffle the array [1,2,3] and return its result. Any
        // permutation of [1,2,3]
        // // must be equally likely to be returned. Example: return [3, 1, 2]
        // solution.reset(); // Resets the array back to its original configuration
        // [1,2,3]. Return [1, 2, 3]
        // solution.shuffle(); // Returns the random shuffling of array [1,2,3].
        // Example: return [1, 3, 2]

        nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        solution = new Solution(nums);
        solution.test(nums);
    }
}

/*
 * 01 10 / 10 test cases passed. Status: Accepted Runtime: 76 ms Memory Usage:
 * 47.5 MB
 * 
 */

// Mine
// 10 / 10 test cases passed.
// Status: Accepted
// Runtime: 77 ms
// Memory Usage: 47.6 MB
