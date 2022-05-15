package problems

import "fmt"

func P1() {
	result := 0
	for i := 1; i <= 1000; i++ {
		if i%3 == 0 || i%5 == 0 {
			result += i
		}
	}

	fmt.Println(result)
	if result != 234168 {
		panic(1)
	}
}
