package leetcode.June2024;

// You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

// Return the minimum number of moves to make every value in nums unique.

// The test cases are generated so that the answer fits in a 32-bit integer.

// Example 1:

// Input: nums = [1,2,2]
// Output: 1
// Explanation: After 1 move, the array could be [1, 2, 3].
// Example 2:

// Input: nums = [3,2,1,2,1,7]
// Output: 6
// Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
// It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

// Constraints:

// 1 <= nums.length <= 105
// 0 <= nums[i] <= 105

public class June14_945_MinimumIncrementtoMakeArrayUnique {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        System.out.println(new June14_945_MinimumIncrementtoMakeArrayUnique().minIncrementForUnique(nums));
    }

    public int minIncrementForUnique(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max + nums.length];

        for (int num : nums) {
            freq[num]++;
        }

        int ans = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] <= 1) {
                continue;
            }

            int dup = freq[i] - 1;
            freq[i + 1] += dup;
            freq[i] = 1;
            ans += dup;
        }

        return ans;
    }
}