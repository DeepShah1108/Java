package leetcode.June2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

// Example 1:

// Input: words = ["bella","label","roller"]
// Output: ["e","l","l"]
// Example 2:

// Input: words = ["cool","lock","cook"]
// Output: ["c","o"]

// Constraints:

// 1 <= words.length <= 100
// 1 <= words[i].length <= 100
// words[i] consists of lowercase English letters.

public class June5_1002_FindCommonCharacters {
    public static void main(String[] args) {
        String[] words = { "bella", "label", "roller" };
        List<String> list = new June5_1002_FindCommonCharacters().commonChars(words);
        System.out.println(list);

    }

    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        int freq[];
        int freq1[];
        freq = getFreqArray(words[0]);

        for (int i = 1; i < words.length; i++) {
            freq1 = getFreqArray(words[i]);
            for (int j = 0; j < 26; j++) {
                freq[j] = Math.min(freq[j], freq1[j]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                list.add(String.valueOf((char) (i + 'a')));
                freq[i]--;
            }
        }

        return list;
    }

    public int[] getFreqArray(String word) {
        int freq[] = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        return freq;
    }
}