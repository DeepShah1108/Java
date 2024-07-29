package leetcode.June2024;

import java.util.*;

public class June7_648_ReplaceWords {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        String ans = new June7_648_ReplaceWords().replaceWords(dictionary, sentence);
        System.out.println(ans);

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String ans = "HELLO";

        return ans;
    }
}