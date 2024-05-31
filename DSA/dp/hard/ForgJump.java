package DSA.dp.hard;

// There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

// For Example
// If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.

// Constraints:
// 1 <= T <= 10
// 1 <= N <= 100000.
// 1 <= HEIGHTS[i] <= 1000 .

// Sample Input 1:
// 2
// 4
// 10 20 30 10
// 3
// 10 50 10
// Sample Output 1:
// 20
// 0

// Sample Input 2:
// 2
// 8
// 7 4 4 2 6 6 3 4 
// 6
// 4 8 3 10 4 4 
// Sample Output 2:
// 7
// 2

public class ForgJump {

    public static void main(String[] args) {
        int heights[] = { 10, 20, 30, 10 };
        int n = heights.length;

        int ans = new ForgJump().frogJump(n, heights);
        System.out.println(ans);
    }

    public int frogJump(int n, int heights[]) {

        int dp[] = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            if (i > 1) {
                jumpTwo = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(jumpOne, jumpTwo);
        }

        return dp[n - 1];
    }
}
