package everyday;

/**
 * @author jbzm
 * @date 7/27/20 9:50 AM
 **/
public class JudgeSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int offset = 0;
        for (int i = 0; i < sChars.length; i++) {
            while (true) {
                if (offset >= tChars.length) {
                    return false;
                }
                if (sChars[i] == tChars[offset]) {
                    offset++;
                    break;
                }
                offset++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        JudgeSubsequence judgeSubsequence = new JudgeSubsequence();
        boolean subsequence = judgeSubsequence.isSubsequence("aaaaaa", "bbaaaa");
        System.out.println(subsequence);
    }
}