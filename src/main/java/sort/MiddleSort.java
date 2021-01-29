package sort;

import java.util.Arrays;

/**
 * @author zhengyi
 * @date 2018/10/20 6:42 PM
 **/
public class MiddleSort {

    /**
     * 快速排序:
     * 1. 选择分区点
     * 2. 将所有的元素放到分区点的两次(需要根据分区点的大小进行比较)
     * 3. 将移动之后的数组继续进行1和2 直到所有的元素全部完成排序(first>=last)
     * <br>
     * 注意点:
     * 1. 在编写递归的时候需要注意递归结束的判断条件,这里我利用了一个技巧(超出条件比对)
     * 2. 需要注意的是快速排序通过简单的方式实现(创建两个交换数组)这种方式不是原地排序,但是通过创建交换变量(temp)可以使用很少的空间O(1) (原地排序,减少排序需要的内存)
     * <br>
     *
     * @param array 数组变量
     * @param first 起始节点
     * @param last  结束节点
     */
    private static void quickSort(int[] array, int first, int last) {
        //递归跳出条件
        if (first > last) {
            return;
        }
        int j = first;
        int temp;
        //选择分区点并对分区后的结果进行排序
        for (int i = first; i < last; i++) {
            if (array[last] > array[i]) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }
        temp = array[j];
        array[j] = array[last];
        array[last] = temp;
        int skipPoint = j;
        quickSort(array, first, skipPoint - 1);
        quickSort(array, skipPoint + 1, last);
    }

    /**
     * 归并排序:
     * 1. 将数组进行拆分
     * 2. 根据前后节点将两个数组进行合并
     * 3. 使用递归,将合并后的记过继续合并
     * <br>
     * 注意点:
     * 1. 分清传递的是数组指针还是数组长度(这个真的很重要)
     * 2. 在合并的时候通过值得交换完成
     * 3. 监管数据覆盖到原数组上
     * <br>
     *
     * @param array 数组变量
     * @param first 起始节点
     * @param last  结束节点
     */
    private static void mergeSort(int[] array, int first, int last) {
        if (first >= last) {
            return;
        }
        int[] arrayTemp = new int[last - first + 1];
        int point = (last + first) / 2;
        //两段递归调用
        mergeSort(array, first, point);
        mergeSort(array, point + 1, last);
        int i = first;
        int j = point + 1;
        int k = 0;
        //合并两段数组
        while (i <= point && j <= last) {
            if (array[i] > array[j]) {
                arrayTemp[k] = array[j];
                j++;
            } else {
                arrayTemp[k] = array[i];
                i++;
            }
            k++;
        }
        //将剩余没有合并近temp的数组一次性覆盖上
        int start;
        int end;
        if (i >= j) {
            start = j;
            end = last;
        } else {
            start = i;
            end = point;
        }
        while (start <= end) {
            arrayTemp[k] = array[start];
            k++;
            start++;
        }
        //将临时数组覆盖到原数组上
        for (int x = 0; x < k; x++) {
            array[first] = arrayTemp[x];
            first++;
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 32, 2, 13, 23, 4, 5, 64, 1, 78, 8, 3};
        mergeSort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(x -> System.out.print(x + " "));
    }
}