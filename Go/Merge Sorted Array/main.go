/*
https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3253/
Merge Sorted Array

Solution
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109

You can easily solve this problem if you simply think about two elements at a time rather than two arrays. We know that each of the individual arrays is sorted. What we don't know is how they will intertwine. Can we take a local decision and arrive at an optimal solution?
If you simply consider one element each at a time from the two arrays and make a decision and proceed accordingly, you will arrive at the optimal solution.
*/

package main

func merge(nums1 []int, m int, nums2 []int, n int) {
	for n > 0 {
		if m == 0 || nums2[n-1] > nums1[m-1] {
			nums1[m+n-1] = nums2[n-1]
			n--
		} else {
			nums1[m+n-1] = nums1[m-1]
			m--
		}
	}
}

func merge0(nums1 []int, m int, nums2 []int, n int) {
	if len(nums1) < 1 || len(nums2) < 1 || len(nums1) != m+n || len(nums2) != n || m+n == 0 {
		return
	}

	if m == 0 {
		for k := 0; k < n; k++ {
			nums1[k] = nums2[k]
		}
		return
	}

	temp := make([]int, m+n)

	var i, j int
	for i < m && j < n { //i, j = i+1, j+1
		if nums1[i] <= nums2[j] {
			temp[i+j] = nums1[i]
			i++
		} else if nums1[i] > nums2[j] {
			temp[i+j] = nums2[j]
			j++
		} else {
			temp[i+j] = nums1[i]
			temp[i+j+1] = nums2[j]
			i++
			j++
		}
	}

	if i == m {
		//nums1 finished the loop
		for k := j; k < n; k++ {
			temp[i+k] = nums2[k]
		}
	} else { //j == n
		//nums2 finished the loop
		for k := i; k < m; k++ {
			temp[j+k] = nums1[k]
		}
	}

	copy(nums1, temp)

	return
}

//59 / 59 test cases passed.
//Status: Accepted
//Runtime: 0 ms
//Memory Usage: 2.3 MB
//Your memory usage beats 14.64 % of golang submissions
// ==>
//Your memory usage beats 100.00 % of golang submissions.
