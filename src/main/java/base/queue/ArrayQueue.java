package base.queue;

/**
 * 手动实现顺序队列
 * @author zhengyi
 * @date 2018/10/10 4:16 PM
 **/
public class ArrayQueue {
    private static int[] array;
    private static int head = 0;
    private static int tail = 0;

    private static void createQueue(int arraySize) {
        array = new int[arraySize];
    }

    private static void insertQueue(int data) {
        if (tail == array.length) {
            array = reLinkUp(array);
        }
        if (tail == array.length && head == 0) {
            System.out.println("wait");
            return;
        }
        array[tail] = data;
        tail++;
    }

    private static int removeQueue() {
        return array[head++];
    }

    private static int[] reLinkUp(int[] array) {
        int[] newArray = new int[array.length];
        int i = 0;
        for (; i < array.length - head; i++) {
            newArray[i] = array[head + i];
        }
        head = 0;
        tail = i;
        return newArray;
    }

    public static void main(String[] args) {
        createQueue(5);
        insertQueue(3);
        insertQueue(5);
        insertQueue(5);
        insertQueue(5);
        insertQueue(5);
        insertQueue(5);
        removeQueue();
        removeQueue();
        removeQueue();
        insertQueue(5);
        insertQueue(2);
        insertQueue(1);
        insertQueue(2);
        insertQueue(1);
        System.out.println(removeQueue());
    }
}