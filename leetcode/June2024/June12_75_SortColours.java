package leetcode.June2024;

// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

// You must solve this problem without using the library's sort function.

// Example 1:

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:

// Input: nums = [2,0,1]
// Output: [0,1,2]

// Constraints:

// n == nums.length
// 1 <= n <= 300
// nums[i] is either 0, 1, or 2.

// Follow up: Could you come up with a one-pass algorithm using only constant extra space?

public class June12_75_SortColours {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        new June12_75_SortColours().sortColours(nums);

    }

    private void printArray(int[] nums) {
        for (int num : nums) {
            System.out.println(num + " ");
        }
    }

    public void sortColours(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }

        int i = 0;

        while (count0 > 0) {
            nums[i] = 0;
            count0--;
            i++;
        }

        while (count1 > 0) {
            nums[i] = 1;
            count1--;
            i++;
        }

        while (count2 > 0) {
            nums[i] = 2;
            count2--;
            i++;
        }

        printArray(nums);
    }
}
