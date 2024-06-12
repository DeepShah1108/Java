package leetcode.June2024;

import java.util.*;

public class June6_846_HandofStraights {
    public static void main(String[] args) {
        int[] hand = { 1, 2, 3, 4, 5 };
        int groupSize = 4;
        System.out.println(new June6_846_HandofStraights().isNStraightHand(hand, groupSize));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        while (!count.isEmpty()) {
            int firstCard = count.firstKey();
            for (int i = 0; i < groupSize; i++) {
                Integer ans = count.get(firstCard + i);
                if (ans == null) {
                    return false;
                }
                if (ans == 1) {
                    count.remove(firstCard + i);
                } else {
                    count.put(firstCard + i, ans - 1);
                }
            }
        }

        return true;
    }
}
