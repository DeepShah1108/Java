package leetcode;

public class June1_3110_ScoreOFAString {
    public static void main(String[] args) {
        String s = "zaz";
        int ans = new June1_3110_ScoreOFAString().scoreOfAString(s);
        System.out.println(ans);
    }

    public int scoreOfAString(String s) {
        int ans = 0;
        char[] ch = s.toCharArray();

        for (int i = 1; i < ch.length; i++) {
            ans += Math.abs((ch[i] - 'a') - (ch[i - 1] - 'a'));
        }

        return ans;
    }

}
