package base.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengyi
 * @date 2018/10/12 1:52 PM
 **/
public class bsse {
    private static Map<Integer, Integer> map = new HashMap();

    static int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return f(n - 1) + f(n - 2);
    }

    static int f_fast(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int ret = f(n - 1) + f(n - 2);
        map.put(n, ret);
        System.out.println("2");
        return ret;
    }

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        System.out.println(f(48));
        System.out.println((System.currentTimeMillis() - l));
    }
}