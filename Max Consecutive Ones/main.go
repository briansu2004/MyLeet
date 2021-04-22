/*
https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3238/
Max Consecutive Ones

Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.

Hint:
You need to think about two things as far as any window is concerned. One is the starting point for the window. How do you detect that a new window of 1s has started? The next part is detecting the ending point for this window. How do you detect the ending point for an existing window? If you figure these two things out, you will be able to detect the windows of consecutive ones. All that remains afterward is to find the longest such window and return the size.
*/

package main

func findMaxConsecutiveOnes(nums []int) int {
	best, crt := 0, 0

	for _, v := range nums {
		if crt+v > best {
			best = crt + v
		}
		crt = (crt + v) * v
	}

	return best
}

/*
func findMaxConsecutiveOnes1(nums []int) int {
	A, B := 0, 0

	for _, v := range nums {
		if A+v > B {
			B = A + v
		}
		A = (A + v) * v
	}

	return B
}

func findMaxConsecutiveOnes0(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	if len(nums) == 1 {
		if nums[0] == 1 {
			return 1
		}
		return 0
	}

	var i, cnt, start, end int
	needNewSearch := true

	//find the first 1
	for i = 0; i < len(nums); i++ {
		if nums[i] == 1 {
			//found 1
			start = i
			end = i
			cnt = calcCnt(start, end, cnt)
			needNewSearch = false
			break
		}
	}

	//can't find any 1
	if needNewSearch {
		return 0
	}

	for i = start + 1; i < len(nums); i++ {
		if nums[i] == 1 {
			//current number is 1

			//if this is a new search, set the start
			if needNewSearch {
				start = i
				needNewSearch = false
			}

			end = i
			cnt = calcCnt(start, end, cnt)

			//check the next one
		} else {
			//found a number that is not 1
			if needNewSearch {
				//still not 1
				//continue searching 1
				start = i
				end = i
			} else {
				//finish the current search
				//calc the start, end, cnt
				end = i
				cnt = calcCnt(start, end, cnt)
				//start a new search
				needNewSearch = true
			}
		}
	}

	//finish the whole loop
	if !needNewSearch {
		end = len(nums)
		cnt = calcCnt(start, end, cnt)

	}

	return cnt
}

func calcCnt(start int, end int, curCnt int) int {
	if end-start > curCnt {
		return end - start
	}
	return curCnt
}

func main() {
	var n []int

	fmt.Println("[] - expected: 0, output:", findMaxConsecutiveOnes(n))

	n = []int{0}
	fmt.Println("[0] - expected: 0, output:", findMaxConsecutiveOnes(n))

	n = []int{1}
	fmt.Println("[1] - expected: 1, output:", findMaxConsecutiveOnes(n))

	n = []int{0, 0}
	fmt.Println("[0,0] - expected: 0, output:", findMaxConsecutiveOnes(n))

	n = []int{0, 0, 0, 0}
	fmt.Println("[0,0,0,0] - expected: 0, output:", findMaxConsecutiveOnes(n))

	n = []int{1, 1, 1, 1}
	fmt.Println("[1,1,1,1] - expected: 4, output:", findMaxConsecutiveOnes(n))

	n = []int{0, 1}
	fmt.Println("[0,1] - expected: 1, output:", findMaxConsecutiveOnes(n))

	n = []int{1, 0}
	fmt.Println("[1,0] - expected: 1, output:", findMaxConsecutiveOnes(n))

	n = []int{0, 1, 0}
	fmt.Println("[0,1,0] - expected: 1, output:", findMaxConsecutiveOnes(n))

	n = []int{0, 1, 1}
	fmt.Println("[0,1,1] - expected: 2, output:", findMaxConsecutiveOnes(n))

	n = []int{1, 0, 1}
	fmt.Println("[1,0,1] - expected: 1, output:", findMaxConsecutiveOnes(n))

	n = []int{1, 1, 0, 1, 1, 1}
	fmt.Println("[1,1,0,1,1,1] - expected: 3, output:", findMaxConsecutiveOnes(n))

	n = []int{1, 0, 1, 1, 0, 1}
	fmt.Println("[1,0,1,1,0,1] - expected: 2, output:", findMaxConsecutiveOnes(n))

	n = []int{1, 1, 0, 1, 1, 1, 1, 1, 1}
	fmt.Println("[1,1,0,1,1,1,1,1,1] - expected: 6, output:", findMaxConsecutiveOnes(n))

	n = []int{1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0}
	fmt.Println("[1,1,0,1,1,1,1,1,1,0,0] - expected: 6, output:", findMaxConsecutiveOnes(n))
}
*/
