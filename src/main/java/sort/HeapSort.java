package sort;

import tool.GenerateUtils;

import java.util.Arrays;

/**
 * [jikeshijina](https://time.geekbang.org/column/article/69913?utm_source=geektime&utm_medium=tycpz-pc&utm_campaign=100070801&utm_content=popups-a&utm_term=pc_interstitial_837_
 * Time complexity : nlogn
 * Heap is a complete binary tree;
 * The value of every node in the heap must be greater than or equals (less than or equals) to the value of each node in its subtree.
 * * @author jbzm
 *
 * @date 1/29/21 11:41 AM
 **/
public class HeapSort {

    public int[] createHeap(int[] array, int n, int tag) {
        if (n == array.length) {
            return array;
        }
        int tmp = 0;
        if (array[n] < tag) {
            tmp = array[n];
            array[n] = tag;
            tag = tmp;
        }
        if (n * 2 > array.length) {
            createHeap(array, n * 2, tag);
            return array;
        }
        return null;
    }


    public static void main(String[] args) {
        Arrays.stream(GenerateUtils.randomGenerateIntArray(200, 100)).forEach(System.out::println);
    }


}