package main

import "fmt"

// fib returns a function that returns
// successive Fibonacci numbers.
func generate_fibonaccis() func() float64 {
	a, b := float64(0), float64(1)
	return func() float64 {
		a, b = b, a+b
		return a
	}
}

func main() {
	fib := generate_fibonaccis()
	for j := 0; j < 100; j++ {
		fmt.Printf("%v \n", fib())
	}
}
