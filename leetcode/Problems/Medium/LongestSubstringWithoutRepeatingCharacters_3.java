package leetcode.Problems.Medium;

import java.util.*;

// Given a string s, find the length of the longest 

// substring
//  without repeating characters.

// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Constraints:

// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = new LongestSubstringWithoutRepeatingCharacters_3().lengthOfLongestSubstring(s);
        System.out.println(ans);

    }

    // Brute-Force - O(N2)

    // public int lengthOfLongestSubstring(String s) {
    // int max = Integer.MIN_VALUE;
    // if (s.length() == 0) {
    // return 0;
    // }

    // for (int i = 0; i < s.length(); i++) {
    // Set<Character> set = new HashSet<>();
    // for (int j = i; j < s.length(); j++) {
    // if (set.contains(s.charAt(j))) {
    // max = Math.max(max, j - i);
    // break;
    // }

    // set.add(s.charAt(j));
    // }
    // }

    // return max;
    // }

    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }

        return len;
    }
}
