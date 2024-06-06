package leetcode.June2024;

import java.util.HashMap;

// Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
// palindrome
//  that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

// Example 1:

// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
// Example 2:

// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.

// Constraints:

// 1 <= s.length <= 2000
// s consists of lowercase and/or uppercase English letters only.

public class June4_409_LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        int ans = new June4_409_LongestPalindrome().longestPalindrome(s);
        System.out.println(ans);
    }

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.get(ch) == 2) {
                ans += 2;
                map.remove(ch);
            }
        }

        if (!map.isEmpty()) {
            ans += 1;
        }

        return ans;
    }
}
