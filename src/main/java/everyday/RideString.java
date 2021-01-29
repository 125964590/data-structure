package everyday;

/**
 * @author jbzm
 * @date 8/13/20 10:25 AM
 **/
public class RideString {
    public String multiply(String num1, String num2) {
        char[] char2 = num2.toCharArray();
        for (int j = 0; j < char2.length / 2; j++) {
            char tmp = char2[j];
            char2[j] = char2[char2.length - j - 1];
            char2[char2.length - j - 1] = tmp;
        }
        String sum = "0";
        for (int i = 0; i < num2.length(); i++) {
            sum = addStrings(sum, rideString(i, char2[i], num1));
        }
        return sum;
    }

    public String rideString(int i, char numChar, String num) {
        String zero = "";
        for (; i > 0; i--) {
            zero = zero + '0';
        }
        num = "0".equals(num) ? "0" : num + zero;
        String sum = "";
        for (int j = 0; j < numChar - '0'; j++) {
            sum = addStrings(sum, num);
        }
        return sum;
    }

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
        RideString rideString = new RideString();
        String multiply = rideString.multiply("0", "123");
        System.out.println(multiply);
    }
}