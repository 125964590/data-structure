package tool;

import java.util.Random;

/**
 * @author jbzm
 * @date 1/29/21 2:49 PM
 **/
public class GenerateUtils {
    public static int[] randomGenerateIntArray(int size, int bound) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }
}