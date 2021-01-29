package everyday;

/**
 * @author jbzm
 * @date 7/24/20 9:53 AM
 **/
public class DivisorGame {

    public boolean divisorGame(int N) {
        int count = 0;

        if (N == 1) {
            return false;
        }

        while (true) {
            count++;
            int commonFactor = getCommonFactor(N);
            N = N - commonFactor;
            if (N <= 1) {
                break;
            }

        }

        return count % 2 == 1;
    }

    public int getCommonFactor(int x) {
        if (x == 1) {
            return 1;
        }
        int tag = x / 2;
        for (; tag > 0; tag--) {
            if (x % tag == 0) {
                break;
            }
        }
        return tag;
    }

    public static void main(String[] args) {
        DivisorGame divisorGame = new DivisorGame();
        boolean b = divisorGame.divisorGame(4);
        System.out.println(b);
    }
}