package main

import "fmt"

// Given an integer n, return true if it is a power of three. Otherwise, return false.
// An integer n is a power of three, if there exists an integer x such that n == 3 power of x.
func isPowerOfThree(n int) bool {
	if n == 0 {
		return false
	}

	if n == 1 {
		return true
	}

	if n%3 > 0 {
		return false
	}

	return isPowerOfThree(n / 3)
}

func isMulitpleOfThree(n int) bool {
	if n%3 == 0 {
		return true
	}
	return false
}

func main() {
	n := 0
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = 1
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = 3
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = 9
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = 27
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = 82
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = 72
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = 865
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = -1
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = -3
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = -9
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))

	n = -27
	fmt.Printf("isPowerOfThree(%v): %v\n", n, isPowerOfThree(n))
}
