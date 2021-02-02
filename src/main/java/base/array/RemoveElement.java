package base.array;

import java.util.Arrays;

/**
 * 给一个数组nums和值val,需要原第一处所有数值等于拔拔凉
 * @author jbzm
 * @date 2/1/21 5:27 PM
 **/
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (; j >= i; j--) {
                    if (nums[j] != val) {
                        nums[i] = nums[j];
                        j--;
                        break;
                    }
                }
            }
        }
        return  j + 1;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement.removeElement(nums, 2);
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println(i);
    }
}