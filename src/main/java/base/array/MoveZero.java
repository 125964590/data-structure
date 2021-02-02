package base.array;

/**
 * <p>https://leetcode-cn.com/leetbook/read/all-about-array/x9rh8e/</p>
 * <P>给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。</P>
 *
 * @author jbzm
 * @date 7/28/20 9:20 PM
 **/
class MoveZero {
    public void moveZeroes(int[] nums) {

        int x = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                x++;
                continue;
            }
            if (x > 0) {
                nums[i - x] = nums[i];
                nums[i] = 0;
            }
        }
    }
}