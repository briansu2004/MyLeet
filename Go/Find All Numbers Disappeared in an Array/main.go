/*
https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
Find All Numbers Disappeared in an Array

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]

Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Hint #1
This is a really easy problem if you decide to use additional memory. For those trying to write an initial solution using additional memory, think counters!
Hint #2
However, the trick really is to not use any additional space than what is already available to use. Sometimes, multiple passes over the input array help find the solution. However, there's an interesting piece of information in this problem that makes it easy to re-use the input array itself for the solution.
Hint #3
The problem specifies that the numbers in the array will be in the range [1, n] where n is the number of elements in the array. Can we use this information and modify the array in-place somehow to find what we need?
*/

package main

//2
func findDisappearedNumbers(nums []int) []int {
	nlen := len(nums)
	for i := 0; i < nlen; {
		if nums[i] != i+1 && nums[nums[i]-1] != nums[i] {
			nums[i], nums[nums[i]-1] = nums[nums[i]-1], nums[i]
			continue
		}
		i++
	}

	var res []int
	for i := 0; i < nlen; i++ {
		if nums[i] != i+1 {
			res = append(res, i+1)
		}
	}
	return res
}

//1
func findDisappearedNumbers1(nums []int) []int {
	nlen := len(nums)
	for i := 0; i < nlen; i++ {
		nums[(nums[i]-1)%nlen] += nlen
	}

	out := []int{}
	for i := 0; i < nlen; i++ {
		if nums[i] <= nlen {
			out = append(out, i+1)
		}
	}
	return out
}

// 33 / 33 test cases passed.
// Status: Accepted
// Runtime: 112 ms
// Memory Usage: 7.3 MB

// 33 / 33 test cases passed.
// Status: Accepted
// Runtime: 68 ms
// Memory Usage: 7.1 MB
