package leetcode.Problems.Medium;

public class RotateImage48 {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotate(arr);

    }

    static int[][] rotate(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][rows - 1 - j];
                arr[i][rows - 1 - j] = temp;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        return arr;

    }
}
