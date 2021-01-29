package everyday;

/**
 * @author jbzm
 * @date 7/31/20 1:08 AM
 **/
public class GetMagicArray {

    public int findMagicIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}