package DSA.graph;

import java.util.ArrayList;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 3, 9, 4, 9, 8, 3, 1 };
        System.out.println(solution(nums));
    }

    static int solution(int[] nums) {
        int[] count = new int[1001];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1000; i >= 0; i--) {
            if (count[i] == 1)
                return i;
        }

        return -1;
    }

}
