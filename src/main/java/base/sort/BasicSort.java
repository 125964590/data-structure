package base.sort;

import java.util.Arrays;

/**
 * @author zhengyi
 * @date 2018/10/16 5:06 PM
 **/
public class BasicSort {

    private static int array[] = {1, 21, 33, 45, 13, 25, 3, 4, 123};

    /**
     * 冒泡排序
     * 和每个未排序元素进行比较出最大的,并且传递下去,将结果放到末尾
     *
     * @param a 数组
     * @param n 数组长度
     * @return 排序后的集合
     */
    public static int[] bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return null;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int t;
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        return a;
    }

    /**
     * 插入:
     * 和前方元素进行比对如果小于前方元素向后移动该元素插入前方
     *
     * @param a 待排序数组
     * @param n 数组长度
     * @return 排序后的集合
     */
    public static int[] insertSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int temp = a[i];
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    a[j] = a[j - 1];
                } else {
                    a[j] = temp;
                    break;
                }
            }
        }
        return a;
    }

    /**
     * 选择排序:
     * 先找到未排序元素中最小的,将其和前方的元素交换位置
     *
     * @param a 待排序数组
     * @param n 数组长度
     * @return 排序后集合
     */
    public static int[] checkSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int temp;
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] ints1 = bubbleSort(array, array.length);
        int[] ints2 = insertSort(array, array.length);
        int[] ints3 = checkSort(array, array.length);

        Arrays.stream(ints1).forEach(System.out::println);
        Arrays.stream(ints2).forEach(System.out::println);
        Arrays.stream(ints3).forEach(System.out::println);
    }
}