package everyday;

/**
 * @author jbzm
 * @date 8/3/20 2:44 AM
 **/
public class StringSum {

    public String addStrings(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();

        boolean carry = false;

        StringBuilder add = new StringBuilder(char1.length + char2.length);

        for (int i = 1; i <= (Math.max(char1.length, char2.length) + 1); i++) {
            int int1 = char1.length >= i ? char1[char1.length - i] - 48 : 0;
            int int2 = char2.length >= i ? char2[char2.length - i] - 48 : 0;
            int tmp = carry ? 1 : 0;
            int sum = int1 + int2 + tmp;
            if (i == (Math.max(char1.length, char2.length) + 1)) {
                if (carry) {
                    add.append(1);
                }
                return add.reverse().toString();
            }
            carry = sum >= 10;
            add.append(sum % 10);
        }
        return null;
    }

    public static void main(String[] args) {
        StringSum stringSum = new StringSum();
        String s = stringSum.addStrings("1", "0");
        System.out.println(s);
    }
}