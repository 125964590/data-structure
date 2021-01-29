package base.array;

/**
 * @author jbzm
 * @date 7/28/20 9:20 PM
 **/
public class NumberOfSubArray {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int totalNum = 0;
        int tagetSum = k * threshold;

        for (int i = 0; i < arr.length - k + 1; i++) {
            int sum = 0;
            for (int j = k - 1 + i; j >= i; j--) {
                sum = arr[j] + sum;
            }
            if (sum >= tagetSum) {
                totalNum++;
            }
        }

        return totalNum;

    }

    public int numOfSubarraysNB(int[] arr, int k, int threshold) {
        int result = 0;
        int sum = 0;
        for (int n = 0; n < k; n++) {
            sum += arr[n];
        }
        for (int i = k; i < arr.length; i++) {
            if (sum >= k * threshold) result++;
            sum += arr[i];
            sum -= arr[i - k];
        }
        if (sum >= k * threshold) result++;
        return result;
    }

    public static void main(String[] args) {
        NumberOfSubArray numberOfSubArray = new NumberOfSubArray();
        int i = numberOfSubArray.numOfSubarrays(new int[]{2, 6, 12, 15, 4, 13, 2, 63}, 2, 10);
        System.out.println(i);
    }
}