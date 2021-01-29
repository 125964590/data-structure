package EveryDay

import (
	"log"
	"testing"
)

// 1. zai
func nextPermutation(nums []int) {

	flag := true
	var index int
	for i := len(nums) - 2; i >= 0; i-- {
		if !flag {
			break
		}
		for j := len(nums) - 1; j > i; j-- {
			if nums[i] > nums[j] {
				continue
			} else {
				t := nums[i]
				nums[i] = nums[j]
				nums[j] = t
				flag = false
				index = i
				break
			}
		}
	}
	index++
	for ; index < len(nums); index++ {
		for j := index; j < len(nums); j++ {

		}
	}
	if flag {
		for i := 0; i < len(nums)/2; i++ {
			t := nums[i]
			nums[i] = nums[len(nums)-i-1]
			nums[len(nums)-i-1] = t
		}
	}
	log.Printf("%v", nums)
}

func TestNextPermutation(t *testing.T) {
	nums := []int{1, 2, 3}
	nextPermutation(nums)
}
