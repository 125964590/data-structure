package thread;

/**
 * @author jbzm
 * @date 12/22/20 7:33 PM
 **/
public class Car {
}

class Solution {
    public static int[] sortArray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = t;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 1, 3, 7, 3};
        int[] newNums = sortArray(nums);
        for (int newNum : newNums) {
            System.out.println(newNum);
        }
    }
}