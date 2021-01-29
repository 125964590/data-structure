package EveryDay

import (
	"fmt"
	"math"
	"testing"
)

// [题目连接](https://leetcode-cn.com/problems/find-common-characters/solution/cha-zhao-chang-yong-zi-fu-by-leetcode-solution/)
// 存在两种控制:
// - 先计算出自身字符串中重复的和非重复的在26个字母中出现的次数
// - 和准备好的数组进行匹配将不存在的(及为零的字符清楚)
// - 输出结果
// 总结:
// 在考虑有限范围的排序查找等情况可以考虑使用链表进行筛选匹配
func CommonChars(a []string) (ans []string) {
	minFreq := [26]int{}
	for i := range minFreq {
		minFreq[i] = math.MaxInt64
	}
	for _, word := range a {
		freq := [26]int{}
		for _, b := range word {
			freq[b-'a']++
		}
		for i, f := range freq[:] {
			if f < minFreq[i] {
				minFreq[i] = f
			}
		}
	}
	for i := byte(0); i < 26; i++ {
		for j := 0; j < minFreq[i]; j++ {
			ans = append(ans, string('a'+i))
		}
	}
	return
}

func TestCommonChars(t *testing.T) {
	strings := []string{
		"ashr", "arhb", "ssarhr",
	}
	chars := CommonChars(strings)

	fmt.Printf("%v", chars)

}
