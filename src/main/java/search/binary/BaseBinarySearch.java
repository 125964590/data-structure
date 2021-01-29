package search.binary;

/**
 * @author zhengyi
 * @date 12/3/18 1:33 PM
 **/
public class BaseBinarySearch {


    public int base(int[] array, int target) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * base binary search
     * <p>
     * search first
     */
    public int binarySearch(int[] nums, int target) {
        int index = -1;
        int mid;
        //set big low
        int low = 0;
        //set big high
        int high = nums.length - 1;
        boolean flag = true;
        while (flag) {
            //check jump
            if (low > high) {
                return -1;
            }
            //get mid
            mid = (high + low) >> 1;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    index = mid;
                    flag = false;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    /**
     * base binary search
     * <p>
     * search last
     */
    public static int binarySearchLast(int[] nums, int target) {
        int index = -1;
        int mid;
        //set big low
        int low = 0;
        //set big high
        int high = nums.length - 1;
        boolean flag = true;
        while (flag) {
            //check jump
            if (low > high) {
                return -1;
            }
            //get mid
            mid = (high + low) >> 1;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    index = mid;
                    flag = false;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    /**
     * base binary search
     */
    private static int binarySearchFirstBig(int[] array, int target) {
        int index = -1;
        int mid;
        //set big low
        int low = 0;
        //set big high
        int high = array.length - 1;
        boolean flag = true;
        while (flag) {
            //get mid
            mid = (high + low) >> 1;
            if (array[mid] >= target) {
                high = mid - 1;
            } else {
                if (mid == 0 || array[mid + 1] < target) {
                    index = mid;
                    flag = false;
                } else {
                    low = mid + 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 6, 8, 12, 45, 78, 190};
        int[] array2 = {2, 3, 4, 6, 7, 8, 9};

        System.out.println(2 ^ 18);
    }
}