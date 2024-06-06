package leetcode.June2024;

// You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.

// Return the score of s.

// Example 1:

// Input: s = "hello"

// Output: 13

// Explanation:

// The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.

// Example 2:

// Input: s = "zaz"

// Output: 50

// Explanation:

// The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.

// Constraints:

// 2 <= s.length <= 100
// s consists only of lowercase English letters.

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
