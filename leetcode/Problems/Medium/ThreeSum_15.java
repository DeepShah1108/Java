package leetcode.Problems.Medium;

import java.util.*;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(new ThreeSum_15().threeSum(nums));

    }
    // public List<List<Integer>> threeSum(int[] nums) {
    // Set<List<Integer>> set = new HashSet<>();
    // int n = nums.length;
    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // for (int k = j + 1; k < n; k++) {
    // if (nums[i] + nums[j] + nums[k] == 0) {
    // List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
    // set.add(temp);
    // }

    // }
    // }
    // }

    // List<List<Integer>> ans = new ArrayList<>(set);
    // return ans;
    // }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                }
            }

        }

        return ans;
    }

}
