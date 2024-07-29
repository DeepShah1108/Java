package leetcode.Problems.Medium;

public class CountNumberOfTeam_1395 {
    public static void main(String[] args) {
        int[] rating = { 2, 5, 3, 4, 1 };
        System.out.println(numTeam(rating));
    }

    static int numTeam(int[] rating) {
        int count = 0;
        int n = rating.length;

        for (int i = 0; i < n; i++) {
            int less_before = 0, less_after = 0;
            int greater_before = 0, greater_after = 0;

            for (int j = 0; j < i; j++) {
                if (rating[i] > rating[j]) {
                    less_before++;
                } else if (rating[j] > rating[i]) {
                    greater_before++;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (rating[i] > rating[j]) {
                    less_after++;
                } else if (rating[j] > rating[i]) {
                    greater_after++;
                }
            }

            count += less_before * greater_after + less_after * greater_before;

        }

        return count;
    }
}
