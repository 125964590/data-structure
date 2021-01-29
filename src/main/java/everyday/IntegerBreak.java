package everyday;

/**
 * @author jbzm
 * @date 7/30/20 12:44 AM
 **/
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        }

        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        } else if (n % 3 == 1) {
            return (int) (Math.pow(3, n / 3 - 1) * 4);
        } else if (n % 3 == 2) {
            return (int) (Math.pow(3, n / 3) * 2);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println((int)Math.pow(3,-1));
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(1));
    }
}